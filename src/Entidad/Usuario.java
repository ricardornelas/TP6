package Entidad;

public class Usuario {
	private String NombreUsuario;
	private String Pass;
	private int TipoUsuario;
	private String DNI;
	private String Nombre;
	private String Apellido;
	
	public Usuario() {
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public int getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	

}
