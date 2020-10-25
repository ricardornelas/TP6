package NegocioImpl;

import java.util.ArrayList;

import Entidad.TipoSeguro;
import Negocio.TipoSeguroNegocio;
import DaoImpl.TipoSeguroDaoImpl;
public class TipoSeguroNegocioImpl implements TipoSeguroNegocio{

	public ArrayList<TipoSeguro> TodosLosNegocios() {
		
		ArrayList <TipoSeguro> lista = new ArrayList<TipoSeguro>(); 
		lista = new TipoSeguroDaoImpl().LeerTodosLosTiposDeSeguro();
		return lista;
	}

}
