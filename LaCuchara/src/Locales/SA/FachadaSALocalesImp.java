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
	*	Modifica un local que esta en la base de datos 
	*	@param local del local que se quiere modificar con la informaion nueva
	*	@return true si se ha modificado la informacion de un local. False, en caso contrario. 
	*/
	public boolean modify(Local local) {
		return SALocales.modify(local);
	}

	/**
	*	Hace una consulta en la base de datos para obtener un solo local. 
	*	@param id del local que se quiere consultar
	*	@return local con toda su informacion.
	*/
	public Local consult(String id) {
		return SALocales.consult(id);
	}

	/**
	*	Elimina un local de la base de datos. 
	*	@param id del local que se quiere eliminar
	*	@return true si se ha eliminado exitosamente. False, en el caso contrario. 
	*/
	public boolean delete(String id) {
		return SALocales.delete(id);
	}

	/**
	*	Crea y añade un nuevo Local
	*	@param local con toda la informacion nueva a introducir. 
	*	@return true si se ha introducido correctamente. False, en el caso contrario. 
	*/
	public boolean create(Local local) {
		return SALocales.create(local);
	}

	@Override
	/**
	*	Devuelve una lista con los Locales relacionados con lo que se busca
	*	@param Local String que se quiere buscar
	*	@return Una lista de locales que cumplen los filtros. 
	*/
	public List<Local> search(String nombre) {
		return SALocales.search(nombre);
	}


	/**
	*	Devuelve una lista ordenada
	*	@param orden tipo de orden que quiere obtener
	*	@return lista de locales ordenados.
	*/
	@Override
	public List<Local> get(int orden) {
		return SALocales.get(orden);
	}

}
