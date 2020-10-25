package Entidad;

public class Seguro {
	private int IdSeguro=0;
	private String Descripcion;
	private int IdTipo;
	private float CostoContratacion;
	private float CostoAsegurado;
	
	public Seguro() {
		
	}

	public int getIdSeguro() {
		return IdSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		IdSeguro = idSeguro;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getIdTipo() {
		return IdTipo;
	}

	public void setIdTipo(int idTipo) {
		IdTipo = idTipo;
	}

	public float getCostoContratacion() {
		return CostoContratacion;
	}

	public void setCostoContratacion(float costoContratacion) {
		CostoContratacion = costoContratacion;
	}

	public float getCostoAsegurado() {
		return CostoAsegurado;
	}

	public void setCostoAsegurado(float costoAsegurado) {
		CostoAsegurado = costoAsegurado;
	}
	
}
