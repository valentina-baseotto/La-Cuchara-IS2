package Locales.SA;

import java.util.List;

import Locales.Local;

/**
	*	Esta clase representa un objeto FachadaSALocalesImp
	*	Esta clase implementa IFachadaSALocales
	*/
public class FachadaSALocalesImp implements IFachadaSALocales {
	/**
     * El SALocal de la ISALocales
     */
	private ISALocales SALocales;
	
	/**
     	* Crea una nueva instancia de la clase SALocalesImpl.
		* la crea como vacio
     	*/
	public FachadaSALocalesImp() {
		SALocales = new SALocalesImpl();
	}

	/**
	 * Modifica un local existente en la base de datos.
	 * @param local El objeto Local que se va a modificar.
	 * @return true si el local se ha modificado correctamente, false en caso contrario.
	 */
	public boolean modify(Local local) {
		return SALocales.modify(local);
	}

	/**
	 * Consulta un local en la base de datos.
	 * @param id El identificador del local.
	 * @return El objeto Local si existe en la base de datos, null en caso contrario.
	 */
	public Local consult(String id) {
		return SALocales.consult(id);
	}

	/**
	 * Elimina un local de la base de datos.
	 * @param id El identificador del local.
	 * @return true si el local se ha eliminado correctamente, false en caso contrario.
	 */
	public boolean delete(String id) {
		return SALocales.delete(id);
	}

	/**
	 * Crea un nuevo local en la base de datos.
	 * @param local El objeto Local que se va a crear.
	 * @return true si el local se ha creado correctamente, false en caso contrario.
	 */
	public boolean create(Local local) {
		return SALocales.create(local);
	}

	@Override
	/**
	 * Busca locales en la base de datos por nombre.
	 * @param nombre El nombre o parte del nombre de los locales que se van a buscar.
	 * @return Una lista de objetos Local que coinciden con la búsqueda.
	 */
	public List<Local> search(String nombre) {
		return SALocales.search(nombre);
	}


	/**
	 * Obtiene una lista de locales ordenados según un criterio específico.
	 * @param orden El criterio de ordenamiento (por ejemplo, por nombre, por fecha de creación, etc.).
	 * @return Una lista de objetos Local ordenados según el criterio especificado.
	 */
	@Override
	public List<Local> get(int orden) {
		return SALocales.get(orden);
	}

}
