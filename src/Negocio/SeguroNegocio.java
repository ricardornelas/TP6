package Negocio;

import java.sql.ResultSet;

public interface SeguroNegocio {
	ResultSet DevolverSegurosConDescripcionDeTipo(int IdTipoSeguro);
}
