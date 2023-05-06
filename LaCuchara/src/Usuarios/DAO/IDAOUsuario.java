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
	 * @return true, si el id coincide con un usuario de la base de datos. False, en caso contrario.
    */

	public boolean check(String id);

	/**
     * Hace una consulta en la base de datos para un solo usuario. 
	 * @param id la id del usuario a consultar.
	 * @return el usuario con toda su informacion
     */	

	public Usuario consult(String id);

	/**
     * Crea un nuevo usuario en la base de datos. 
	 * @param usuario el objeto que se quiere introducir en la base de datos. 
	 * @return True si se han introducido los datos. False, en caso contrario. 
     */	

	public boolean create(Usuario usuario);

	/**
	*	Inicia sesion en la aplicaion. 
	*	@param id La id del nuevo usuario
	*   @param pass la contraseña del nuevo usuario
	*   @return true si el id y el pass es del mismo usuario existen en la base de datos. False, en caso contrario. 
	*/

	public boolean login(String id, String pass);

	/**
     *	Elimina un usuario de la base de datos
	 * @param id la id del usuario a eliminar.
	 * @return true, si se ha eliminado el usuario. False, en el caso contrario. 
     */

	public boolean delete(String id);

	/**
     * Modifica un usuario en la base de datos. 
	 * @param usuario el usuario a modificar con la nueva informacion.
	 * @return true, si se han introducido los nuevos datos. False, en el caso contrario. 
     */

	public boolean modify(Usuario usuario);

	/**
     * Devuelve una lista de Usuarios que cumplen con los filtros. 
	 * @param name
	 * @return La lista de usuarios que cumplen con los filtros.
     */	

	public List<Usuario> search(String name);

	/**
     * Devuelve la lista de usuario ordenados. 
	 * @param orden el criterio para ordenar
	 * @return la lista ordenada.
     */

	public List<Usuario> getList(int orden);

}
