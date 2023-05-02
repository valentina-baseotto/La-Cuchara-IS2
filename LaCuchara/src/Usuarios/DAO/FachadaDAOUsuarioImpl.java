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
	* @return usuariosDAO.check()
     */
	
	@Override
	public boolean check(String id) {
		return usuariosDAO.check(id);
	}

	/**
     * Devuelve el usuario con la id especificada.
	 * @param id la id del usuario a consultar.
	 * @return reservas.consut().
     */	

	@Override
	public Usuario consult(String id) {
		return usuariosDAO.consult(id);
	}

	/**
     * Devuelve si el usuario se ha creado.
	 * @param usuario
	 * @return reservas.create().
     */	

	@Override
	public boolean create(Usuario usuario) {
		return usuariosDAO.create(usuario);
	}

	/**
	*	hace el login del nuevo usuario
	*	@param id La id del nuevo usuario
	*   @param pass la contraseña del nuevo usuario
	*/

	@Override
	public boolean login(String id, String pass) {
		return usuariosDAO.login(id, pass);
	}

	/**
     * Devuelve si el usuario se ha eliminado.
	 * @param id la id del usuario a eliminar.
	 * @return reservas.delete().
     */	

	@Override
	public boolean delete(String id) {
		return usuariosDAO.delete(id);
	}

	/**
     * Devuelve si el usuario se ha modificado.
	 * @param usuario el usuario a modificar
	 * @return reservas.modify().
     */	

	@Override
	public boolean modify(Usuario usuario) {
		return usuariosDAO.modify(usuario);
	}

	/**
     * Devuelve el usuario con String reserva.
	 * @param name
	 * @return reservas.search().
     */	


	@Override
	public List<Usuario> search(String name) {
		return usuariosDAO.search(name);
	}

	/**
     * Devuelve la lista de reservas.
	 * @orden orden
	 * @return reservas.getList().
     */
	
	@Override
	public List<Usuario> getList(int orden){
		return usuariosDAO.getList(orden);
	}


}
