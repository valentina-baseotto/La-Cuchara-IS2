package Locales.SA;

import java.util.List;

import Locales.Local;

/**
    * Esta clase representa una interfaz IFachadaSALocales
    */
public interface IFachadaSALocales {

	/**
	*	Modifica un local que esta en la base de datos 
	*	@param local del local que se quiere modificar con la informaion nueva
	*	@return true si se ha modificado la informacion de un local. False, en caso contrario. 
	*/
	public boolean modify(Local Local);
	
	/**
	*	Hace una consulta en la base de datos para obtener un solo local. 
	*	@param id del local que se quiere consultar
	*	@return local con toda su informacion.
	*/
	public Local consult(String id);

	/**
	*	Elimina un local de la base de datos. 
	*	@param id del local que se quiere eliminar
	*	@return true si se ha eliminado exitosamente. False, en el caso contrario. 
	*/	
	public boolean delete(String id);

	/**
	*	Crea y añade un nuevo Local
	*	@param local con toda la informacion nueva a introducir. 
	*	@return true si se ha introducido correctamente. False, en el caso contrario. 
	*/
	public boolean create(Local Local);

	
	/**
	*	Devuelve una lista con los Locales relacionados con lo que se busca
	*	@param Local String que se quiere buscar
	*	@return Una lista de locales que cumplen los filtros. 
	*/
	public List<Local> search(String nombre);
	
	/**
	*	Devuelve una lista ordenada
	*	@param orden tipo de orden que quiere obtener
	*	@return lista de locales ordenados.
	*/
	public List<Local> get(int orden);	
}
