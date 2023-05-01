package Locales.DAO;

import java.util.List;

import Locales.Local;

public interface IFachadaDAOLocales {
	
	/**
	 * Verifica si un local existe en la base de datos.
	 * @param id El identificador del local.
	 * @return true si el local existe, false en caso contrario.
	 */
	public boolean check(String id);
	
	/**
	 * Consulta un local en la base de datos.
	 * @param id El identificador del local.
	 * @return El objeto Local si existe en la base de datos, null en caso contrario.
	 */
	public Local consult(String id);
	
	/**
	 * Crea un nuevo local en la base de datos.
	 * @param local El objeto Local que se va a crear.
	 * @return true si el local se ha creado correctamente, false en caso contrario.
	 */
	public boolean create(Local local);
	
	/**
	 * Elimina un local de la base de datos.
	 * @param id El identificador del local.
	 * @return true si el local se ha eliminado correctamente, false en caso contrario.
	 */
	public boolean delete(String id);
	
	/**
	 * Modifica un local existente en la base de datos.
	 * @param local El objeto Local que se va a modificar.
	 * @return true si el local se ha modificado correctamente, false en caso contrario.
	 */
	public boolean modify(Local local);
	
	/**
	 * Busca locales en la base de datos por nombre.
	 * @param name El nombre o parte del nombre de los locales que se van a buscar.
	 * @return Una lista de objetos Local que coinciden con la búsqueda.
	 */
	public List<Local> search(String name);
	
	/**
	 * Obtiene una lista de locales ordenados según un criterio específico.
	 * @param orden El criterio de ordenamiento (por ejemplo, por nombre, por fecha de creación, etc.).
	 * @return Una lista de objetos Local ordenados según el criterio especificado.
	 */
	public List<Local> getList(int orden);
}
