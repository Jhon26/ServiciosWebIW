package co.edu.udea.dispositivos.ws.exception;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
* Manejo de excepciones relacionadas a la ejecución de los Servicios Web
* @author lenovo
*
*/
public class ExcepcionServicio extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//Añadido automáticamente por Eclipse
	private final static Logger logger = Logger.getLogger(ExcepcionServicio.class);

	public ExcepcionServicio(String message, Throwable cause){
		super(message, cause);
		guardarExcepcionesLog4j();
	}
	
	private void guardarExcepcionesLog4j(){
		PropertyConfigurator.configure("src/log4j.properties");
		logger.error("Se ha producido un error en el servicio[log4j]:  "+getMessage());		
	}

	public ExcepcionServicio(Throwable cause){
		super(cause);
		logger.error(cause.getMessage());
	}

	@Override
	public void printStackTrace() {
		System.out.println("Error servicio: "+ getMessage());
	}
}
