package Entidad;

public class Contratacion {
	private int IdContratacion;
	private String NombreUsuario;
	private int IdSeguro;
	private float CostoContratacion;
	Contratacion(){
		
	}
	public int getIdContratacion() {
		return IdContratacion;
	}
	public void setIdContratacion(int idContratacion) {
		IdContratacion = idContratacion;
	}
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}
	public int getIdSeguro() {
		return IdSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		IdSeguro = idSeguro;
	}
	public float getCostoContratacion() {
		return CostoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		CostoContratacion = costoContratacion;
	}
	
}
