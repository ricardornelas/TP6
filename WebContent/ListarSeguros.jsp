<%@page import="java.sql.ResultSet"%>
<%@page import="DaoImpl.SeguroDaoImpl"%>
<%@page import="NegocioImpl.SeguroNegocioImpl"%>
<%@page import="Entidad.Seguro"%>
<%@page import="DaoImpl.TipoSeguroDaoImpl"%>
<%@page import="Entidad.TipoSeguro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

<form action= "servletSeguros" method="get">

&nbsp; <a id="Inicio" href="Inicio.jsp"> Inicio </a>  &nbsp; 
<a id="AgregarSeguro" href="AgregarSeguro.jsp"> Agregar Seguro </a>  &nbsp; 
<a id="Listar seguros" href="ListarSeguros.jsp">Listar Seguros</a>  
</form>
<form method="post" action="servletSeguros">
<H1> <b>Tipos de seguros en la base de datos: </b> </H1> 
Busqueda por tipo de Seguros:
			<select name="DdlTipoSeguro">
<%
 						ArrayList<TipoSeguro> ListaTiposSeguros = new TipoSeguroDaoImpl().LeerTodosLosTiposDeSeguro();
 							for(TipoSeguro tipo:ListaTiposSeguros){ %>
 						
 						<option value=<%=tipo.getIdTipo()%>><%=tipo.getDescripcion() %></option>
 						<%}%>
			</select>
			<input type="submit" name="btnFiltrar" value="Filtrar">
			
<table border="1">
<tr> <th>ID Seguro</th><th>Descripcion Seguro</th><th>Descripcion Tipo Seguro</th><th>Costo Contratación</th><th>Costo máximo asegurado</th></tr>
<%
		ResultSet tabla = null;
	if(request.getParameter("btnFiltrar")==null){
		tabla = new SeguroNegocioImpl().DevolverSegurosConDescripcionDeTipo(-1);
	} else {
		tabla = (ResultSet)request.getAttribute("tabla");
	}
	while(tabla.next()){
		%>
<tr><th><%=tabla.getInt(1)%></th><th><%=tabla.getString(2) %></th><th><%=tabla.getString(3) %></th><th><%=tabla.getFloat(4) %></th><th><%=tabla.getFloat(5) %></th></tr>
	<%}%>

</table>

</form>

</body>
</html>