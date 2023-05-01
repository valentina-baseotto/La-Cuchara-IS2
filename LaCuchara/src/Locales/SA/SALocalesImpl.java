package Locales.SA;

import java.util.List;

import Locales.Local;
import Locales.DAO.FachadaDAOLocalesImpl;
import Locales.DAO.IFachadaDAOLocales;
	/**
	*	Esta clase implementa ISALocales
	*/
public class SALocalesImpl implements ISALocales {
	/**
     * El local de la IFachadaDAOLocales.
     */
	private IFachadaDAOLocales LocalDAO;
		
		/**
     	* Crea una nueva instancia de la clase SALocalesImpl.
		* la crea como vacio
     	*/

	public SALocalesImpl() {
		LocalDAO = new FachadaDAOLocalesImpl();
	}
	/**
	*	Modifica un local
	*	@param local del local que se quiere modificar
	*	@return true or false que indica si se ha modificado o no un local
	*/
	public boolean modify(Local local) {

		return LocalDAO.modify(local);
	}
	/**
	*	Devuelve un Local consultado apartir de una ide
	*	@param id del local que se quiere consultar
	*	@return local consultado
	*/
	public Local consult(String id) {
		return LocalDAO.consult(id);
	}
	/**
	*	Elimina un local
	*	@param id del local que se quiere eliminar
	*	@return true or false que indica si se puede eliminar o no un local
	*/
	public boolean delete(String id) {
		return LocalDAO.delete(id);
	}
	/**
	*	Crea y añade un nuevo Local
	*	@param local variable tipo Local
	*	@return true or false que indica si se puede crear o no un local
	*/
	public boolean create(Local local) {
		return LocalDAO.create(local);
	}
	
	/**
	*	Devuelve una lista con los Locales relacionados con lo que se busca
	*	@param Local String que se quiere buscar
	*	@return List<Local> LocalDAO..search(Local) devuelve la lista de los elementos de la busqueda
	*/
	@Override
	public List<Local> search(String Local) {
		return LocalDAO.search(Local);
	}
	/**
	*	Devuelve una lista ordenada
	*	@param orden tipo de orden que quiere obtener
	*	@return List<Local> LocalDAO.getList(orden) devuelve la lista ordenada
	*/
	@Override
	public List<Local> get(int orden) {
		return LocalDAO.getList(orden);
	}
}
