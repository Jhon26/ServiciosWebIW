package co.edu.udea.dispositivos.ws;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Las siguientes clases se pudieron importar gracias a que se lig� a este proyecto
 * el otro proyecto llamado "Dispositivos". Para ligarlo, click derecho en este proyecto,
 * properties, deployment assembly, add, project y luego escoger el proyecto que se desea ligar
 */
import co.edu.udea.dispositivos.bl.FuncionalidadesGenerales;
import co.edu.udea.dispositivos.dto.Usuario;
import co.edu.udea.dispositivos.dto.Dispositivo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo; 
   
/**
 * Se implementan los servicios web asociados a las funcionalidades generales del sistema
 * @author lenovo
 *
 */

@Path("investigador")//Ruta para acceder a este conjunto de servicios web
@Component 
public class FuncionalidadesGeneralesService {
	 
	@Autowired
	FuncionalidadesGenerales funcionalidadesGenerales;
	
	//Getter para usuarioBl. Permite obtener desde afuera de esta clase el valor de esta variable
	public FuncionalidadesGenerales getUsuarioBl(){
		return this.funcionalidadesGenerales;
	}
	
	//Setter para usuarioBl. Permite asignar desde afuera de esta clase un valor a esta variable
	public void setUsuarioBl(FuncionalidadesGenerales usuarioBl){
		this.funcionalidadesGenerales = usuarioBl;
	}
	
	//Cualquiera de los siguientes servicios que se desee utilizar debe usarse de la siguiente manera:
	//http://localhost:8080/DispositivosWS/rest/investigador/[[servicio]]/[[par�metros]]
	
	//******************SERVICIO AUTENTICAR************************
	
	@GET//Los datos enviados al "Servidor" por el siguiente m�todo viajan a trav�s de la URL, a la vista de todos
	@Produces(MediaType.APPLICATION_JSON)//Es el tipo de respuesta. En este caso se responder� un archivo JSON
	@Path("autenticar/{nombreUsuario}/{contrasena}")//El nombre de usuario y la contrase�a se ingresan como par�metros en la URL aunque en un escenario real esto ser�a una muy mala pr�ctica
	//En este m�todo se obtienen los par�metros ingresados en la URL y se les asigna una variable a cada uno por medio de
	//la anotaci�n @PathParam. Este m�todo tendr� la capacidad de lanzar una excepci�n debida a la llamada a un m�todo remoto.
	/**
	 * Servicio Web que permite a un usuario autenticar su ingreso al sistema
	 * @param nombreUsuario indica el nombre del usuario del investigador
	 * @param contrasena indica la contrase�a del investigador
	 * @return un usuario que  hace referencia al usuario encontrado en la base de datos con el nombre de 
	 * 		   usuario y la contrase�a especificadas
	 * @throws RemoteException
	 */
	public Usuario autenticar(@PathParam("nombreUsuario") String nombreUsuario, @PathParam("contrasena") String contrasena) throws RemoteException{
		Usuario usuario = null;//Contiene el objeto de tipo Usuario que se retornar� en caso de una autenticaci�n correcta
		try{
			usuario = funcionalidadesGenerales.loguear(nombreUsuario, contrasena);//Mediante el m�todo loguear en la clase FuncionalidadesGenerales se verifica que los
			//par�metros ingresados si coincidan con un usuario existente, de ser as� se retorna el objeto encontrado.	
		}catch(ExcepcionPrestamo exception){//Cuando no se encuentra el usuario se lanza esta excepci�n
			throw new RemoteException(exception.getMessage(), exception);//Se imprime el mensaje de la excepci�n
		}
		return usuario;//Se retorna el usuario en caso de ser encontrado
	}
	
	
	//********SERVICIO LISTAR DISPOSITIVOS DISPONIBLES*************
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar-disponibles")
	/**
	 * Servicio Web que devuelve una lista con los dispositivos que tienen estado "Disponible"
	 * @return una lista de dispositivos con todos los dispositivos disponibles
	 * @throws RemoteException
	 */
	public List<Dispositivo> listarDispositivosDisponibles() throws RemoteException{
		List<Dispositivo> lista = new ArrayList<Dispositivo>();
		try{
			lista = (List<Dispositivo>)funcionalidadesGenerales.listarDispositivosDisponibles();
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
		return lista;
	}
	
	
	//********SERVICIO SOLICITAR PRESTAMO*************
	
	@POST//Los datos enviados al "Servidor" por el siguiente m�todo viajan en el header, ocultos a la vista del usuario
	@Path("solicitar-prestamo")
	/**
	 * Servicio Web que permite solicitar un pr�stamo de un dispositivo
	 * @param investigador indica la id del usuario que realiza la solicitud
	 * @param dispositivo hace referencia a la id del dispositivo a prestar
	 * @param fechaInicio la fecha de inicio del pr�stamo
	 * @param fechaFin la fecha de finalizaci�n del pr�stamo
	 * @throws RemoteException
	 */
	public void solicitarPrestamo(@FormParam("investigador") String investigador, @FormParam("dispositivo") String dispositivo, 
			@FormParam("fechaInicio") String fechaInicio, @FormParam("fechaFin") String fechaFin) throws RemoteException{
		try{
			funcionalidadesGenerales.solicitarPrestamoDispositivo(investigador, dispositivo, fechaInicio, fechaFin);
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
	}
}