package Locales.DAO;

import java.util.List;

import Locales.Local;

public class FachadaDAOLocalesImpl implements IFachadaDAOLocales {

	/**
     * El localesDao de la IDAOLocales
     */
	IDAOLocales localesDAO;
	
		
		
	/**
	 * Contructor de la clase.
	 * 
	 * 
	 */
	public FachadaDAOLocalesImpl() {
		localesDAO = new DAOLocalesImpl();
	}
	/**
	 * Verifica si un local existe en la base de datos.
	 * @param id El identificador del local.
	 * @return true si el local existe, false en caso contrario.
	 */
	@Override
	public boolean check(String id) {
		return localesDAO.check(id);
	}

	/**
	*	Hace una consulta en la base de datos para obtener un solo local. 
	*	@param id del local que se quiere consultar
	*	@return local con toda su informacion.
	*/
	@Override
	public Local consult(String id) {
		return localesDAO.consult(id);
	}


	/**
	*	Crea y añade un nuevo Local
	*	@param local con toda la informacion nueva a introducir. 
	*	@return true si se ha introducido correctamente. False, en el caso contrario. 
	*/
	@Override
	public boolean create(Local Local) {
		return localesDAO.create(Local);
	}

	/**
	*	Elimina un local de la base de datos. 
	*	@param id del local que se quiere eliminar
	*	@return true si se ha eliminado exitosamente. False, en el caso contrario. 
	*/
	@Override
	public boolean delete(String id) {
		return localesDAO.delete(id);
	}

	/**
	*	Modifica un local que esta en la base de datos 
	*	@param local del local que se quiere modificar con la informaion nueva
	*	@return true si se ha modificado la informacion de un local. False, en caso contrario. 
	*/
	@Override
	public boolean modify(Local Local) {
		return localesDAO.modify(Local);
	}

	/**
	*	Devuelve una lista con los Locales relacionados con lo que se busca
	*	@param Local String que se quiere buscar
	*	@return Una lista de locales que cumplen los filtros. 
	*/
	@Override
	public List<Local> search(String name) {
		return localesDAO.search(name);
	}
	
	/**
	*	Devuelve una lista ordenada
	*	@param orden tipo de orden que quiere obtener
	*	@return lista de locales ordenados.
	*/
	@Override
	public List<Local> getList(int orden){
		return localesDAO.getList(orden);
	}
}
