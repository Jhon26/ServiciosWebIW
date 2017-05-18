package co.edu.udea.dispositivos.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * La siguiente clase se pudo importar gracias a que se ligó a este proyecto
 * el otro proyecto llamado "Dispositivos". Para ligarlo, click derecho en este proyecto,
 * properties, deployment assembly, add, project y luego escoger el proyecto que se desea ligar
 */
import co.edu.udea.dispositivos.bl.FuncionalidadesRestringidas;
import co.edu.udea.dispositivos.dto.Prestamo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;


/**
 * Se implementan los servicios web asociados a las funcionalidades restringidas del sistema
 * @author Santiago
 *
 */
@Path("administrador")
@Component
public class FuncionalidadesRestringidasService {
	//Logger log = 
	
	@Autowired
	FuncionalidadesRestringidas funcionalidadesRestringidas;	
	
	//Getter para funcionalidadesRestringidas. Permite obtener desde afuera de esta clase el valor de esta variable
	public FuncionalidadesRestringidas getUsuarioBl(){
		return this.funcionalidadesRestringidas;
	}
	
	//Setter para funcionalidadesRestringidas. Permite asignar desde afuera de esta clase un valor a esta variable
	public void setUsuarioBl(FuncionalidadesRestringidas usuarioBl){
		this.funcionalidadesRestringidas = usuarioBl;
	}
	
	//Cualquiera de los siguientes servicios que se desee utilizar debe usarse de la siguiente manera:
	//http://localhost:8080/DispositivosWS/rest/administrador/[[servicio]]/[[parámetros]]
	
	
	//********SERVICIO REGISTRAR INVESTIGADOR***********
	@POST
	@Path("registrar-investigador")
	/**
	 * Servicio Web que permite ingresar o registrar en el sistema a un nuevo investigador
	 * @param id hace referencia a la id del investigador
	 * @param nombres indica los nombres del investigador
	 * @param apellidos indica los apellidos del investigador
	 * @param nombreUsuario es el nombre con el cual el usuario desea ingresar al sistema
	 * @param contrasena es la contraseña con el cual el usuario desea ingresar al sistema
	 * @param administrador hace referencia a la id del administrador que realiza el registro
	 * @throws RemoteException
	 */
	public void registrarInvestigador(@FormParam("id") String id, @FormParam("nombres") String nombres, @FormParam("apellidos") String apellidos, 
			@FormParam("nombreUsuario") String nombreUsuario, @FormParam("contrasena") String contrasena, @FormParam("administrador") String administrador) throws RemoteException{
		try{
			//log.debug("El usuario es "+nombreUsuario);
			funcionalidadesRestringidas.registrarInvestigador(id, nombres, apellidos, nombreUsuario, contrasena, administrador);
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
	}
	
	
	//********SERVICIO ELIMINAR INVESTIGADOR*************
	@DELETE
	@Path("eliminar-investigador")
	/**
	 * Servicio Web que permite eliminar del sistema a un investigador
	 * @param id indica la id del investigador a eliminar
	 * @param administrador es la id del administrador que realiza la eliminación
	 * @throws RemoteException
	 */
	public void eliminarInvestigador(@FormParam("id") String id, @FormParam("administrador") String administrador) throws RemoteException{
		try{
			funcionalidadesRestringidas.eliminarInvestigador(id, administrador);
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
	}
	
	//********SERVICIO ACTUALIZAR INVESTIGADOR*************
	@PUT
	@Path("actualizar-investigador")
	/**
	 * Servicio Web que permite actualizar los datos de un investigador ya registrado
	 * @param id hace referencia a la id del investigador
	 * @param nombres indica los nombres del investigador
	 * @param apellidos indica los apellidos del investigador
	 * @param nombreUsuario es el nombre con el cual el usuario desea ingresar al sistema
	 * @param contrasena es la contraseña con el cual el usuario desea ingresar al sistema
	 * @param administrador hace referencia a la id del administrador que realiza la actualización
	 * @throws RemoteException
	 */
	public void actualizarInvestigador(@FormParam("id") String id, @FormParam("nombres") String nombres, @FormParam("apellidos") String apellidos, 
			@FormParam("nombreUsuario") String nombreUsuario, @FormParam("contrasena") String contrasena, @FormParam("administrador") String administrador) throws RemoteException{
		try{
			funcionalidadesRestringidas.actualizarInvestigador(id, nombres, apellidos, nombreUsuario, contrasena, administrador);
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
	}
	
	//********SERVICIO REGISTRAR DISPOSITIVO*************
	@POST
	@Path("registrar-dispositivo")
	/**
	 * Servicio Web que permite registrar un dispositivo en el sistema
	 * @param id la id del dispositivo a registrar en el sistema
	 * @param tipo el tipo de dispositivo
	 * @param administrador la id del administrador que realiza el registro
	 * @throws RemoteException
	 */
	public void registrarDispositivo(@FormParam("id") String id, @FormParam("tipo") String tipo, @FormParam("administrador") String administrador) throws RemoteException{
		try{
			funcionalidadesRestringidas.registrarDispositivo(id, tipo, administrador);
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
	}
	
	
	//********SERVICIO ELIMINAR DISPOSITIVO*************
	@DELETE
	@Path("eliminar-dispositivo")
	/**
	 * Servicio Web que permite eliminar un dispositivo del sistema
	 * @param id la id del dispositivo a eliminar
	 * @param administrador la id del administrador que ejecuta la eliminación
	 * @throws RemoteException
	 */
	public void eliminarDispositivo(@FormParam("id") String id, @FormParam("administrador") String administrador) throws RemoteException{
		try{
			funcionalidadesRestringidas.eliminarDispositivo(id, administrador);
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
	}
		
	
	//********SERVICIO ACTUALIZAR DISPOSITIVO*************
	@PUT
	@Path("actualizar-dispositivo")
	/**
	 * Servicio Web que permite actualizar un dispositivo
	 * @param id la id del dispositivo a actualizar
	 * @param tipo el tipo de dispositivo
	 * @param estado situación actual del dispositivo
	 * @param administrador la id del administrador que realiza la actualización
	 * @throws RemoteException
	 */
	public void actualizarDispositivo(@FormParam("id") String id, @FormParam("tipo") String tipo, @FormParam("estado") String estado, 
			@FormParam("administrador") String administrador) throws RemoteException{
		try{
			funcionalidadesRestringidas.actualizarDispositivo(id, tipo, estado, administrador);
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
	}
	
	//********SERVICIO LISTAR PRESTAMOS SIN PROCESAR*************
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar-prestamos-sin-procesar")
	/**
	 * Servicio Web que permite listar los préstamos sin procesar
	 * @return una lista de los préstamos sin procesar
	 * @throws RemoteException
	 */
	public List<Prestamo> listarPrestamosSinProcesar() throws RemoteException{
		List<Prestamo> lista = new ArrayList<Prestamo>();
		try{
			lista = (List<Prestamo>)funcionalidadesRestringidas.listarPrestamosSinProcesar();
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
		return lista;
	}
	
	//********SERVICIO RESPONDER PRESTAMO*************
	@PUT
	@Path("responder-prestamo")
	/**
	 * Servicio Web que permite responder a la solicitud de un préstamo
	 * @param id la id del préstamo a responder
	 * @param respuesta la respuesta al préstamo
	 * @param administrador el administrador que responde a la solicitud
	 * @throws RemoteException
	 */
	public void responderPrestamo(@FormParam("idS") String idS, @FormParam("respuesta") String respuesta, 
			@FormParam("administrador") String administrador) throws RemoteException{
		try{
			Long id;
			if(idS==""||"".equals(idS)){
				id = 0L;
			}else{
				id = Long.valueOf(idS);
			}			
			funcionalidadesRestringidas.responderPrestamo(id, respuesta);
		}catch(ExcepcionPrestamo exception){
			throw new RemoteException(exception.getMessage(), exception);
		}
	}
}
