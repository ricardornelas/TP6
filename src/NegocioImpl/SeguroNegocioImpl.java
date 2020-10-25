package NegocioImpl;

import java.sql.ResultSet;

import DaoImpl.SeguroDaoImpl;
import Negocio.SeguroNegocio;

public class SeguroNegocioImpl implements SeguroNegocio {

	@Override
	public ResultSet DevolverSegurosConDescripcionDeTipo(int id) {
		
		ResultSet RS = new SeguroDaoImpl().obtenerRSSeguros(id);
		
		return RS;
	}
	
	
	
}
