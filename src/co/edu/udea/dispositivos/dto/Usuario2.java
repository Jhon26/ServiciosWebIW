package co.edu.udea.dispositivos.dto;

/**
 * Especifica el DTO Usuario con sus setters y getters
 * @author lenovo
 *
 */
public class Usuario2{

	private String id;
	private String nombres;
	private String apellidos;
	private String nombreUsuario;
	private String contrasena;
	private String rol;//{Administrador, Investigador}
	/**
	 * @return la identificaci�n del usuario
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id la identificaci�n o DNI del usuario
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return el(los) nombre(s) del usuario
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres el(los) nombre(s) del usuario
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return el(los) apellido(s) del usuario
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos el(los) apellido(s) del usuario
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return el nombre de usuario que tendr� cada usuario para autenticarse en el sistema
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario el nombre de usuario que tendr� cada usuario para autenticarse en el sistema
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return la contrase�a que tendr� cada usuario para autenticarse en el sistema
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena la contrase�a que tendr� cada usuario para autenticarse en el sistema
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * @return el rol al cual pertenece el usuario
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * @param rol el rol al cual pertenece el usuario
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
