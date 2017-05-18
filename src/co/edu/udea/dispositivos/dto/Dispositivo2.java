package co.edu.udea.dispositivos.dto;

/**
 * Especifica el DTO Dispositivo con sus setters y getters
 * @author lenovo
 *
 */
public class Dispositivo2{

	private String id;
	private String tipo;
	private String estado;//{Disponible, Ocupado}
	/**
	 * @return la id del dispositivo
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id la id que diferencia un dispositivo de otro
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return el tipo de dispositivo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo la categoria en la cual se encuentra el dispositivo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return el estado actual del dispositivo
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado la condici�n en la cual se encuentra el dispositivo a ser prestado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}	
}