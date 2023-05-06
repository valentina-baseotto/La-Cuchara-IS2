package Usuarios.SA;

import java.util.List;

import Usuarios.Usuario;

/**
    * Esta clase representa un objeto FachadaSAUsuarioImp implementa la clase IFachadaSAUsuario
     */

public class FachadaSAUsuarioImp implements IFachadaSAUsuario {
	
	/**
     * El usuariosDAO de la IDAOUsuario.
     */

	private ISAUsuario SAUsuario;

	/**
     * Crea una nueva instancia de la clase FachadaDAOUsuarioImpl.
	* la crea como vacio
     */
	
	public FachadaSAUsuarioImp() {
		SAUsuario = new SAUsuarioImpl();
	}

	/**
     * Modifica la informacion de un usuario en la base de datos
	 * @param usuario la informacoin del usuario con la nueva informacion 
	 * @return true, se han modificado los datos. False, en el caso contrario.
     */

	public boolean modify(Usuario usuario) {

		return SAUsuario.modify(usuario);
	}

 	/**
      * Devuelve el usuario con toda su informacion
 	 * @param id el identificador del usuario 
 	 * @return El objeto usuaario con toda su informacion
      */	

	public Usuario consult(String id) {
		return SAUsuario.consult(id);
	}

	/**
     * Eliminar un usuario de la base de datos
	 * @param id el id del usuario a eliminar.
	 * @return true si se ha eliminado el usuario. False en el caso contrario.
     */

	public boolean delete(String id) {
		return SAUsuario.delete(id);
	}

	/**
     * Crea un usuario nuevo que no estaba en la base de datos. 
	 * @param usuario el nuevo usuario
	 * @return true si se han introducido los datos correctamente. False, en el caso contrario. 
     */	

	public boolean create(Usuario usuario) {
		return SAUsuario.create(usuario);
	}

	/**
	*	El iniciar sesion para un usuario que existe en la base de datos
	*	@param nombre 
	*   @param pass la contraseña del nuevo usuario
	*   @return true, si se puede inicar sesion. False, en caso contrario.
	*/

	@Override
	public boolean login(String nombre, String pass) {
		return SAUsuario.login(nombre, pass);
	}

	/**
     * Devuelve una lista de usuarios que cumplen con los filtros de busqueda. 
	 * @param usuario el usuario a buscar.
	 * @return Lista de Usuarios que cumplen los filtros
     */

	@Override
	public List<Usuario> search(String usuario) {
		return SAUsuario.search(usuario);
	}

	/**
     * Devuelve una lista de usuarios ordenados
	 * @param orden el criterio de orden
	 * @return la lista ordenada
     */

	@Override
	public List<Usuario> getList(int orden) {
		return SAUsuario.getList(orden);
	}


}
