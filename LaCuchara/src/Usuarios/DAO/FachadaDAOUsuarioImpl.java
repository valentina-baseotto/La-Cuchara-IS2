package Usuarios.DAO;

import java.util.List;

import Usuarios.Usuario;


/**
    * Esta clase representa un objeto FachadaDAOUsuarioImpl implementa la clase IFachadaDAOUsuario
     */

public class FachadaDAOUsuarioImpl implements IFachadaDAOUsuario {


	/**
     * El usuariosDAO de la IDAOUsuario.
     */

	IDAOUsuario usuariosDAO;

	/**
     * Crea una nueva instancia de la clase FachadaDAOUsuarioImpl.
	* la crea como vacio
     */
	
	public FachadaDAOUsuarioImpl() {
		usuariosDAO = new DAOUsuariosImpl();
	}

	/**
     * devuelve el usuario que se ha querido comprobar
	 * @param id la id del usuario a comprobar
	 * @return true, si el id coincide con un usuario de la base de datos. False, en caso contrario.
    */
	
	@Override
	public boolean check(String id) {
		return usuariosDAO.check(id);
	}

	/**
     * Hace una consulta en la base de datos para un solo usuario. 
	 * @param id la id del usuario a consultar.
	 * @return el usuario con toda su informacion
     */

	@Override
	public Usuario consult(String id) {
		return usuariosDAO.consult(id);
	}

	/**
     * Crea un nuevo usuario en la base de datos. 
	 * @param usuario el objeto que se quiere introducir en la base de datos. 
	 * @return True si se han introducido los datos. False, en caso contrario. 
     */	

	@Override
	public boolean create(Usuario usuario) {
		return usuariosDAO.create(usuario);
	}

	/**
	*	Inicia sesion en la aplicaion. 
	*	@param id La id del nuevo usuario
	*   @param pass la contraseña del nuevo usuario
	*   @return true si el id y el pass es del mismo usuario existen en la base de datos. False, en caso contrario. 
	*/

	@Override
	public boolean login(String id, String pass) {
		return usuariosDAO.login(id, pass);
	}

	/**
     *	Elimina un usuario de la base de datos
	 * @param id la id del usuario a eliminar.
	 * @return true, si se ha eliminado el usuario. False, en el caso contrario. 
     */

	@Override
	public boolean delete(String id) {
		return usuariosDAO.delete(id);
	}

	/**
     * Modifica un usuario en la base de datos. 
	 * @param usuario el usuario a modificar con la nueva informacion.
	 * @return true, si se han introducido los nuevos datos. False, en el caso contrario. 
     */	

	@Override
	public boolean modify(Usuario usuario) {
		return usuariosDAO.modify(usuario);
	}

	/**
     * Devuelve una lista de Usuarios que cumplen con los filtros. 
	 * @param name
	 * @return La lista de usuarios que cumplen con los filtros.
     */	


	@Override
	public List<Usuario> search(String name) {
		return usuariosDAO.search(name);
	}

	/**
     * Devuelve la lista de usuario ordenados. 
	 * @param orden el criterio para ordenar
	 * @return la lista ordenada.
     */
	
	@Override
	public List<Usuario> getList(int orden){
		return usuariosDAO.getList(orden);
	}


}
