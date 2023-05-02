package Usuarios.SA;

import java.util.List;

import Usuarios.Usuario;

/**
    * Esta clase representa un objeto IFachadaSAUsuario
     */

public interface IFachadaSAUsuario {

	/**
     * Devuelve el usuario con String reserva.
	 * @param usuario el usuario a buscar.
	 * @return reservas.search().
     */	

	public boolean modify(Usuario usuario);

	/**
     * Devuelve el usuario con la id especificada.
	 * @param id la id del usuario a consultar.
	 * @return reservas.consut().
     */	
	
	public Usuario consult(String id);

	/**
     * Devuelve si el usuario se ha eliminado.
	 * @param id la id del usuario a eliminar.
	 * @return reservas.delete().
     */
	
	public boolean delete(String id);

	/**
     * Devuelve si el usuario se ha creado.
	 * @param usuario
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
     * Devuelve el usuario con String reserva.
	 * @param nombre
	 * @return reservas.search().
     */	
	
	public List<Usuario> search(String nombre);

	/**
     * Devuelve la lista de reservas.
	 * @param orden
	 * 
     */
	
	public List<Usuario> getList(int orden);
	

}
