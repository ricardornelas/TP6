package Dao;

import java.sql.ResultSet;
import Entidad.Seguro;

public interface SeguroDao {
	
	public boolean Agregar(Seguro seguro);
	public ResultSet obtenerRSSeguros(int IdTipoSeguro);
}
