package Ofertas.SA;

import java.util.List;

import Ofertas.Oferta;

/**
 * Esta clase implementa la fachada IFachadaSAOferta, forma parte del Servicio de Aplicaciones de Oferta.
 * Llama al Servicio de Aplicaciones de Oferta.
 *
 */
public class FachadaSAOfertaImpl implements IFachadaSAOferta {
	
	/**
	 * oferta de ISAOferta 
	 */
	private ISAOferta oferta;
	
	/**
	 * El constructor de la clase 
	 */
	public FachadaSAOfertaImpl() {
		oferta = new SAOfertaImpl();
	}

	/**
	 * Modifica la informacion del objeto Oferta
	 * @param Oferta El objeto tipo Oferta con la informacion nueva
	 * @return true si se ha modificado la informacion en la base de datos. False, en caso contrario. 
	 */
	public boolean modify(Oferta Oferta) {

		return oferta.modify(Oferta);
	}

	/**
	 *Consulta en la base de datos a traves de su ID
	 *@param id de tipo String, para identificar a la Oferta en concreto
	 *@return El objeto tipo Oferta con toda su informacion. 
	 */
	public Oferta consult(String id) {
		return oferta.consult(id);
	}

	/**
	 *Elimina una oferta en la base de datos 
	 *@param id el identificador de la Oferta que se quiere eliminar 
	 *@return True, si se ha realizado la operacion con exito. False, en caso contrario.
	 */
	public boolean delete(String id) {
		return oferta.delete(id);
	}

	/**
	 *Crea una nueva oferta que no existia previamente en la base de datos
	 *@param Oferta con toda su informacion 
	 *@return True, si se ha introducido la informacion en la base de datos. False, en caso contrario 
	 */
	public boolean create(Oferta Oferta) {
		return oferta.create(Oferta);
	}
	
	/**
	 *Busca en la base de datos en busca de ofertas que cumplan con el filtro.
	 *@param local El filtro de busqueda
	 *@return Una lista con todas las ofertas que cumplen
	 */
	public List<Oferta> searchLocal(String local) {
		return oferta.searchLocal(local);
	}

	/**
	 *Metodo para ordenar la lista
	 *@param orden 
	 *@return la lista de ofertas ordenada
	 */
	@Override
	public List<Oferta> getList(int orden) {
		return oferta.getList(orden);
	}

	/**
	 *Chequea el id de una Oferta 
	 *@param id el identificador de la Oferta que se quiere comprobar 
	 *@return True, si existe la Oferta a la cual le pertenece el id. False en caso contrario.
	 */
	@Override
	public boolean check(String id) {
		return oferta.check(id);
	}
	/**
	 *Busca ofertas que cumplen el filtro de busqueda siendo este una letras.
	 *@param localStrt las letras que hacen de filtro
	 *@return Lista de Ofertas que cumplen el requisito. 
	 */
	@Override
	public List<Oferta> searchLocalLike(String localStrt){
		return oferta.searchLocalLike(localStrt);
	}
}
