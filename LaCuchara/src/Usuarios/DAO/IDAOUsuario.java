package Usuarios.DAO;

import java.util.List;

import Usuarios.Usuario;


/**
    * Esta clase representa un objeto IDAOUsuario
     */


public interface IDAOUsuario {
	
	/**
     * devuelve el usuario que se ha querido comprobar
	 * @param id la id del usuario a comprobar
	 * @return usuariosDAO.check()
    */

	public boolean check(String id);

	/**
     * Devuelve el usuario con la id especificada.
	 * @param id la id del usuario a consultar.
	 * @return reservas.consut().
     */	

	public Usuario consult(String id);

	/**
     * Devuelve si el usuario se ha creado.
	 * @param reserva la id del usuario a crear.
	 * @return reservas.create().
     */	

	public boolean create(Usuario usuario);

	/**
	*	hace el login del nuevo usuario
	*	@param id La id del nuevo usuario
	*   @param pass la contraseña del nuevo usuario
	*/

	public boolean login(String id, String pass);

	/**
     * Devuelve si el usuario se ha eliminado.
	 * @param id la id del usuario a eliminar.
	 * @return reservas.delete().
     */	

	public boolean delete(String id);

	/**
     * Devuelve si el usuario se ha modificado.
	 * @param usuario el usuario a modificar
	 * @return reservas.modify().
     */	

	public boolean modify(Usuario usuario);

	/**
     * Devuelve el usuario con String reserva.
	 * @param usuario el usuario a buscar.
	 * @return reservas.search().
     */	

	public List<Usuario> search(String name);

	/**
     * Devuelve la lista de reservas.
	 * @orden el int del que genera la lista
	 * @return reservas.getList().
     */

	public List<Usuario> getList(int orden);

}
