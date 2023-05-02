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
     * Devuelve si el usuario se ha modificado.
	 * @param usuario el usuario a modificar
	 * @return reservas.modify().
     */	

	public boolean modify(Usuario usuario) {

		return SAUsuario.modify(usuario);
	}

	/**
     * Devuelve el usuario con la id especificada.
	 * @param id la id del usuario a consultar.
	 * @return reservas.consut().
     */	

	public Usuario consult(String id) {
		return SAUsuario.consult(id);
	}

	/**
     * Devuelve si el usuario se ha eliminado.
	 * @param id la id del usuario a eliminar.
	 * @return reservas.delete().
     */	

	public boolean delete(String id) {
		return SAUsuario.delete(id);
	}

	/**
     * Devuelve el usuario con la id especificada.
	 * @param usuario
	 * @return reservas.consut().
     */	

	public boolean create(Usuario usuario) {
		return SAUsuario.create(usuario);
	}

	/**
	*	hace el login del nuevo usuario
	*	@param id La id del nuevo usuario
	*   @param pass la contraseña del nuevo usuario
	*/

	@Override
	public boolean login(String nombre, String pass) {
		return SAUsuario.login(nombre, pass);
	}

	/**
     * Devuelve el usuario con String reserva.
	 * @param usuario el usuario a buscar.
	 * @return reservas.search().
     */	

	@Override
	public List<Usuario> search(String usuario) {
		return SAUsuario.search(usuario);
	}

	/**
     * Devuelve la lista de reservas.
	 * @param orden
	 * @return reservas.getList().
     */

	@Override
	public List<Usuario> getList(int orden) {
		return SAUsuario.getList(orden);
	}


}
