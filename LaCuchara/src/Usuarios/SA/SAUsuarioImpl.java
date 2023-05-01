package Usuarios.SA;

import java.util.List;

import Usuarios.Usuario;
import Usuarios.DAO.FachadaDAOUsuarioImpl;
import Usuarios.DAO.IFachadaDAOUsuario;

/**
    * Esta clase representa un objeto SAUsuarioImpl implementa la clase ISAUsuario
     */

public class SAUsuarioImpl implements ISAUsuario {

	/**
     * La usuarioDao de la IFachadaDAOUsuario.
     */

	private IFachadaDAOUsuario usuarioDAO;


	/**
     * Crea una nueva instancia de la clase SAUsuarioImpl.
	* la crea como vacio
     */

	
	public SAUsuarioImpl() {
		usuarioDAO = new FachadaDAOUsuarioImpl();
	}

	/**
     * Devuelve el usuario con String reserva.
	 * @param usuario el usuario a buscar.
	 * @return reservas.search().
     */	


	public boolean modify(Usuario usuario) {

		return usuarioDAO.modify(usuario);
	}

	/**
     * Devuelve el usuario con String reserva.
	 * @param usuario el usuario a buscar.
	 * @return reservas.search().
     */	


	public Usuario consult(String id) {
		return usuarioDAO.consult(id);
	}

	/**
     * Devuelve si el usuario se ha eliminado.
	 * @param id la id del usuario a eliminar.
	 * @return reservas.delete().
     */

	public boolean delete(String id) {
		return usuarioDAO.delete(id);
	}

	/**
     * Devuelve si el usuario se ha creado.
	 * @param reserva la id del usuario a crear.
	 * @return reservas.create().
     */	

	public boolean create(Usuario usuario) {
		return usuarioDAO.create(usuario);
	}

	/**
	*	hace el login del nuevo usuario
	*	@param id La id del nuevo usuario
	*   @param pass la contraseña del nuevo usuario
	*/

	@Override
	public boolean login(String nombre, String pass) {
		return usuarioDAO.login(nombre, pass);
	}

	/**
     * Devuelve el usuario con String reserva.
	 * @param usuario el usuario a buscar.
	 * @return reservas.search().
     */

	@Override
	public List<Usuario> search(String usuario) {
		return usuarioDAO.search(usuario);
	}

	/**
     * Devuelve la lista de reservas.
	 * @orden el int del que genera la lista
	 * @return reservas.getList().
     */

	@Override
	public List<Usuario> getList(int orden) {
		return usuarioDAO.getList(orden);
	}


}
