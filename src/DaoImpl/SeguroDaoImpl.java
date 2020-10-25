package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Dao.SeguroDao;
import Entidad.Seguro;


public class SeguroDaoImpl implements SeguroDao{
	
	private static final String Insertar = "INSERT INTO Seguros( descripcion, idtipo, costoContratacion, costoAsegurado) VALUES(?, ?,?,?)";
	private static final String Listar = "Select * from seguros";
	private  String ListarConDescTipoSeguro = "SELECT idSeguro,seguros.descripcion,tiposeguros.descripcion,costoContratacion,costoAsegurado FROM seguros INNER JOIN tiposeguros ON seguros.idTipo = tiposeguros.idTipo";
	
	public boolean verificarNombre(String nombre) {
		Statement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		String Buscar = "Select Count(idSeguro) From seguros Where descripcion = '" +nombre +"'";
		boolean respuesta = false;
		try{
			statement = conexion.createStatement();
			ResultSet result = statement.executeQuery(Buscar);    
			result.next();
         if(result.getInt(1)==0) {
             respuesta = true;
         }
     } catch(Exception e){
         System.err.print("Ha ocurrido un error: "+ e.getMessage());
     } 
     return respuesta;
	}
	
	public boolean Agregar(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean SeInserto = false;
		boolean verificar=verificarNombre(seguro.getDescripcion());	
		try
		{
		statement = conexion.prepareStatement(Insertar);
		statement.setString(1, seguro.getDescripcion());
		statement.setInt(2, seguro.getIdTipo());
		statement.setFloat(3, seguro.getCostoContratacion());
		statement.setFloat(4, seguro.getCostoAsegurado());
		if(statement.executeUpdate() > 0)
		{
			conexion.commit();
			SeInserto= true;
		}}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return SeInserto;
		}
	
@Override
	public ResultSet obtenerRSSeguros(int IdTipoSeguro) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		Statement st;

		try {
			st = conexion.createStatement();			
			ResultSet rs;
			if(IdTipoSeguro==-1) { rs = st.executeQuery(ListarConDescTipoSeguro);} 
			else rs = st.executeQuery(ListarConDescTipoSeguro +  " WHERE seguros.idTipo=" + Integer.toString(IdTipoSeguro));
			return rs;

		} 

		catch (Exception e) {

			e.printStackTrace();

		}

		finally {}

		return null;
	}

	public int CantidadRegistros() {

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}	
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Statement statement;
		try {

			statement = conexion.createStatement();
			ResultSet result = statement.executeQuery("SELECT COUNT(idSeguro) FROM Seguros");
			result.next();
			return result.getInt(1)+1;

		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
