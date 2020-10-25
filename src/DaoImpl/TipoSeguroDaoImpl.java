package DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dao.TipoSeguroDao;
import Entidad.TipoSeguro;


public class TipoSeguroDaoImpl implements TipoSeguroDao {

	private static final String Listar = "SELECT * FROM TIPOSEGUROS";
	
	public ArrayList<TipoSeguro> LeerTodosLosTiposDeSeguro() {
			
		ArrayList<TipoSeguro> lTipoSeguro = new ArrayList<TipoSeguro>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		Statement st;
		
	try {
		st = conexion.createStatement();
		ResultSet result = st.executeQuery(Listar);
		
		while (result.next()) {

			TipoSeguro aux = new TipoSeguro(Integer.parseInt(result.getString("idTipo")),result.getString("descripcion"));
			lTipoSeguro.add(aux);
			
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}			
		return lTipoSeguro;
	}

}
