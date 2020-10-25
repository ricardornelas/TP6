package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DaoImpl.SeguroDaoImpl;
import Entidad.Seguro;
import NegocioImpl.SeguroNegocioImpl;

/**
 * Servlet implementation class servletSeguros
 */
@WebServlet("/servletSeguros")
public class servletSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSeguros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(request.getParameter("btnAceptar")!=null) {
			
			Seguro s = new Seguro();
			

			s.setDescripcion(request.getParameter("txtDescripcion"));
			s.setIdTipo(Integer.parseInt(request.getParameter("ddlTiposSeguros")));
			s.setCostoContratacion(Float.parseFloat(request.getParameter("txtCostoContratacion")));
			s.setCostoAsegurado(Float.parseFloat(request.getParameter("txtCostoMax")));
			
			
			
			SeguroDaoImpl Sdao = new SeguroDaoImpl();
			if(Sdao.verificarNombre(request.getParameter("txtDescripcion")))
			Sdao.Agregar(s);
			
		}

		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnFiltrar")!=null) {
			
			ResultSet RS= new SeguroNegocioImpl().DevolverSegurosConDescripcionDeTipo(Integer.parseInt(request.getParameter("DdlTipoSeguro")));
			
			request.setAttribute("tabla", RS);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}
	}

}
