package Locales.SA;

import java.util.List;

import Locales.Local;

	/**
    * Esta clase representa una interfaz ISALocales
    */
public interface ISALocales {

	/**
	*	Modifica un local
	*	@param local del local que se quiere modificar
	*	@return true or false que indica si se ha modificado o no un local
	*/
	public boolean modify(Local Local);
	
	/**
	*	Devuelve un Local consultado apartir de una ide
	*	@param id del local que se quiere consultar
	*	@return local consultado
	*/
	public Local consult(String id);

	/**
	*	Elimina un local
	*	@param id del local que se quiere eliminar
	*	@return true or false que indica si se puede eliminar o no un local
	*/	
	public boolean delete(String id);

	/**
	*	Crea y añade un nuevo Local
	*	@param local variable tipo Local
	*	@return true or false que indica si se puede crear o no un local
	*/
	public boolean create(Local Local);
	
	/**
	*	Devuelve una lista con los Locales relacionados con lo que se busca
	*	@param Local String que se quiere buscar
	*	@return List<Local> LocalDAO..search(Local) devuelve la lista de los elementos de la busqueda
	*/
	public List<Local> search(String nombre);
	
	/**
	*	Devuelve una lista ordenada
	*	@param orden tipo de orden que quiere obtener
	*	@return List<Local> LocalDAO.getList(orden) devuelve la lista ordenada
	*/
	public List<Local> get(int orden);	
}
