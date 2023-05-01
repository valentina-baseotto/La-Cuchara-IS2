package Cuchara;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.List;


import Locales.Local;
import Locales.SA.FachadaSALocalesImp;
import Locales.SA.IFachadaSALocales;
import Ofertas.Oferta;
import Ofertas.SA.FachadaSAOfertaImpl;
import Ofertas.SA.IFachadaSAOferta;
import Reservas.Reserva;
import Reservas.SA.FachadaSAReservaImp;
import Reservas.SA.IFachadaSAReserva;
import Usuarios.Usuario;
import Usuarios.SA.FachadaSAUsuarioImp;
import Usuarios.SA.IFachadaSAUsuario;
import windows.AdminPanel;
import windows.AppWindow;
/**
 * Esta clase funcionar como el controlador para los 4 subsistemas, es la capa entre las GUIs y el Servicio de Aplicaciones
 * 
 *
 */
public class Controller {
	
	private IFachadaSAUsuario usuarios;
	private IFachadaSALocales locales;
	private IFachadaSAOferta ofertas;
	private IFachadaSAReserva reservas;
	private AppWindow app;
	boolean admin = false;
	String id;

/**
 * Constructor de la clase Controller
 */
public Controller() {
	usuarios = new FachadaSAUsuarioImp();
	locales = new FachadaSALocalesImp();
	ofertas = new FachadaSAOfertaImpl();
	reservas = new FachadaSAReservaImp();
}

/**
 * Función para validar las credenciales del usuario
 * 
 * @param ID   Identificador del usuario
 * @param pass Contraseña del usuario
 * @return true si las credenciales son válidas, false en caso contrario
 */
public boolean login(String ID, String pass) {
	if(usuarios.login(ID, pass)) {
		if(ID.equals("admin")) {
			admin = true;
		}
		return true;
	}
	return false;
}

/**
 * Función para abrir la ventana principal de la aplicación
 * @param u Identificador del usuario
 */
public void openApp(String u) {
	app = new AppWindow(this);	
}

/**
 * Función para establecer el identificador del usuario
 * @param usuario Identificador del usuario
 */
public void setUsuario(String usuario) {
	id = usuario;
}
/**
 * Función para identificar si un usuario es admin
 * @return admin Identificador del admin
 */
public boolean isAdmin() {
	return admin;
}

/**
 * Función para abrir la ventana principal del admin
 */
public void openAdmin() {
	AdminPanel adminPanel = new AdminPanel(this);
}

/**
 * Función para obtener el usuario actualmente conectado
 * @return Usuario actualmente conectado
 */
public Usuario getUser() {
	return usuarios.consult(id);
}

/**
 * Función para modificar los datos de un usuario
 * @param u Usuario con los datos modificados
 * @return true si la modificación fue exitosa, false en caso contrario
 */
public boolean modifyUser(Usuario u) {
	return usuarios.modify(u);
}

/**
 * Funcion que devuelve la lista de Reservas para un usuario concreto
 * 
 * @param user usuario a buscar su lista de reservas
 * @return lista de reservas del usuario
 * */

public List<Reserva> searchReserva(String user){
	return reservas.search(user);
}

/**
 * Funcion para eliminar una reserva concreta
 * 
 * @param id id de la reserva a eliminar
 * */

public void deleteReserva(String id) {
	if(reservas.delete(id))
		JOptionPane.showMessageDialog(new JPanel(), "Reserva cancelada");
	else
		JOptionPane.showMessageDialog(new JPanel(), "No se ha podido cancelar la reserva");
}

/**
 * Función para modificar los datos de una oferta
 * @param o Usuario con los datos modificados
 */
public void modifyOferta(Oferta o) {
	if(ofertas.modify(o))
		JOptionPane.showMessageDialog(new JPanel(), "Oferta modificada con éxito");
	else
		JOptionPane.showMessageDialog(new JPanel(), "La oferta no ha podido ser modificada");
}

/**
 * Función para crear un nuevo usuario
 * @param u Usuario a crear
 * @return true si la creación fue exitosa, false en caso contrario
 */
public boolean createUser(Usuario u) {
	return usuarios.create(u);
}

/**
 * Función para crear una nueva reserva
 * @param r Reserva a crear
 * @return true si la creación fue exitosa, false en caso contrario
 */
public boolean create(Reserva r) {
	return reservas.create(r);
}

/**
 * Función para crear una nueva oferta
 * @param o Oferta a crear
 * @return true si la creación fue exitosa, false en caso contrario
 */
public boolean createofer(Oferta o) {
	return ofertas.create(o);
}

/**
 * Funcion para crear una nueva reserva
 * @param o Reserva a crear 
 * @return true si la creacion fue exitosa, false en caso contrario
 */

public boolean createreser(Reserva o) {
	return reservas.create(o);
}


/**
 * Función para obtener una lista de locales ordenados según un criterio específico
 * @param orden Criterio de ordenamiento
 * @return Lista de locales ordenados según el criterio especificado
 */
	public List<Local> getListLocales(int orden){
		return locales.get(orden);
	}

	/**
 * Función para obtener una lista de reservas ordenados según un criterio específico
 * @param orden Criterio de ordenamiento
 * @return Lista de Reservas ordenados según el criterio especificado
 */
	public List<Reserva> getListReservas(int orden){
		return reservas.getList(orden);
	}
	
	/**
	 * Función para obtener una lista de locales ordenados según un criterio específico
	 * @param orden Criterio de ordenamiento
	 * @return Lista de locales ordenados según el criterio especificado
	 */
		public List<Oferta> getListOfertas(int orden){
			return ofertas.getList(orden);
		}

	/**
 	* Elimina un usuario de la base de datos.
	 * 
 	* @param u El usuario a eliminar.
 	*/
	
	public void delete(Usuario u) {
		if(!usuarios.delete(u.getID())) {
			JOptionPane.showMessageDialog(new JPanel(), "No existe este usuario");
		}
		else
			JOptionPane.showMessageDialog(new JPanel(), "Usuario eliminado con exito");
	}
	
	/**
 	* Elimina un local de la base de datos.
	 * 
 	* @param l El local a eliminar.
 	*/
	public void delete(Local l) {
		if(!locales.delete(l.getNombre())) {
			JOptionPane.showMessageDialog(new JPanel(), "No existe este local");
		}
		else
			JOptionPane.showMessageDialog(new JPanel(), "Local eliminado con exito");
	}
	
	/**
	 * Elimina una Oferta de la base de datos
	 * @param l Oferta a eliminar 
	 */

	public void delete(Oferta l) {
		if(!ofertas.delete(l.getID())) {
			JOptionPane.showMessageDialog(new JPanel(), "No existe esta oferta");
		}
		else
			JOptionPane.showMessageDialog(new JPanel(), "Oferta eliminada con exito");
	}
	
	/**
	 * Elimina una Reserva de la base de datos
	 * 
	 * @param l Reserva a eliminar 
	 */

	public void delete(Reserva l) {
		if(!reservas.delete(l.getID())) {
			JOptionPane.showMessageDialog(new JPanel(), "No existe esta reserva");
		}
		else
			JOptionPane.showMessageDialog(new JPanel(), "Reserva eliminada con exito");
	}

	/**
 	* Modifica una reserva de la base de datos.
	 * 
 	* @param r La reserva a modificada con la nueva información a introducir en la base de datos.
 	*/
	public void modifyReserva(Reserva r){

		if(!reservas.modify(r))
			JOptionPane.showMessageDialog(new JPanel(), "Modificacion no exitosa");
		else
			JOptionPane.showMessageDialog(new JPanel(), "Modificacion exitosa!");
		
	}
	
	/**
	 * Modifica un local de la base de datos
	 * @param l Local a modificar con una nueva informacion a cambiar en la base de datos
	 */

	public void modifyLocal(Local l){
		if(!locales.modify(l))
			JOptionPane.showMessageDialog(new JPanel(), "Modificacion no exitosa");
		
		else
			JOptionPane.showMessageDialog(new JPanel(), "Modificacion exitosa!");
	}
	
	/**
	 * Modifica un Usuario de la base de datos
	 * @param l Usuario a modificar con una nueva informacion a cambiar en la base de datos
	 */
	
	public void modifyUsuario(Usuario l){
		if(!usuarios.modify(l))
			JOptionPane.showMessageDialog(new JPanel(), "Modificacion no exitosa");
		
		else
			JOptionPane.showMessageDialog(new JPanel(), "Modificacion exitosa!");
	}
	
	/**
	 * Hace una consulta en la base de datos a partir de la clave primaria de Local
	 * @param nombre ID del local
	 * @return Local con su informacion 
	 */
	public Local consultLocal(String nombre) {
		return locales.consult(nombre);
	}
	
	/**
	 * Hace una consulta en la base de datos a partir de la clave primaria de Usuario
	 * @param nombre IS del Usuario
	 * @return Usuario con su informacion
	 */
	
	public Usuario consultUsuario(String nombre) {
		return usuarios.consult(nombre);
	}
	
	/**
	 * Crea un nuevo Local que no estaba anteriormente en la base de datos
	 * @param local con la informacion del nuevo local
	 */
	
	public void create(Local local) {
		if(locales.create(local))
			JOptionPane.showMessageDialog(new JPanel(), "Local creado con exito");
		else
			JOptionPane.showMessageDialog(new JPanel(), "No ha sido posible crear el local");
	}

	/**
	 * Función para obtener una lista de usuarios ordenados según un criterio específico
	 * @param orden Criterio de ordenamiento
	 * @return Lista de usuarios ordenados según el criterio especificado
	 */
	public List<Usuario> getListUsuarios(int orden){
		return usuarios.getList(orden);
	}

	/**
	 * Función para obtener una lista de usuarios ordenados según un criterio específico
	 * @param orden Criterio de ordenamiento
	 * @return Lista de usuarios ordenados según el criterio especificado
	 */
	public List<Usuario> getListRe(int orden){
		return usuarios.getList(orden);
	}


	/**
	 * 
	 * Busca ofertas en la base de datos cuyo local empiece por localStrt.
	 *
	 * @param localStrt string que sirve para hacer la busqueda.
	 * 
	 * @return Una lista de ofertas que empiecen por localStrt.
	 */
	public List<Oferta> searchOfertaLike(String localStrt){
		return ofertas.searchLocalLike(localStrt);
	}
	/**
	 * Busca en Local en la base de datos 
	 * @param local
	 * @return Lista de locales que cumplen el criterio
	 */
	
	public List<Local> searchLocalLike(String local){
		return locales.search(local);
	}
	/**
	 * Busca el Usuario en la base de datos
	 * @param local
	 * @return Lista de Usuarios que compluen el criterio 
	 */
	public List<Usuario> searchUsuarioLike(String local){
		return usuarios.search(local);
	}
	/**
	 * Buscaen la Reserva en la base de datos
	 * @param local
	 * @return Lista de Reservas que complen con el criterio 
	 */

	public List<Reserva> searchReservaLike(String local){
		return reservas.search(local);
	}
}
