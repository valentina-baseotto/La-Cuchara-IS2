package Ofertas.SA;

import java.util.List;

import Ofertas.Oferta;
/**
 * Esta clase representa un objeto FachadaSAOfertaImpl
 * Esta clase implementa IFachadaSAOferta
 * 
 *
 */
public class FachadaSAOfertaImpl implements IFachadaSAOferta {
	/**
	 * El oferta de la ISAOferta
	 */
	private ISAOferta oferta;
	/**
	 * Crea una nueva instancia de la clase SAOfertaImpl.
	 * La crea como vacio 
	 */
	public FachadaSAOfertaImpl() {
		oferta = new SAOfertaImpl();
	}
	/**
	 * Modifica la Oferta existense en la base de datos 
	 * @param Oferta El objeto Oferta que se va a modificar
	 * @return true si la Oferta se ha modificado correctamente, false en caso contrario 
	 */
	public boolean modify(Oferta Oferta) {

		return oferta.modify(Oferta);
	}
	/**
	 * Consulta un Oferta por su id
	 * @param id El identificador unico de la Oferta 
	 * @return El objeto Oferto que tiene ese id
	 */
	public Oferta consult(String id) {
		return oferta.consult(id);
	}
	/**
	 * Elimina una Oferta que ya existia en la base de datos
	 * @param id El identificador de la Oferta a eliminar 
	 * @return true si se ha eliminado con exito la Oferta, false el caso contrario 
	 */
	public boolean delete(String id) {
		return oferta.delete(id);
	}
	/**
	 * Crea una nueva Oferta que no estaba antes en a base de datos 
	 * @param Oferta El objeto Oferta con toda la informacion nueva 
	 * @return true si se han intriducido los datos en la base de datos, false en el caso contrario 
	 */
	public boolean create(Oferta Oferta) {
		return oferta.create(Oferta);
	}
	/**
	 * Busca Oferta en la base de datos por el nombre 
	 * @param Lista de objetos Oferta que compluen con el filtro
	 */
	
	public List<Oferta> searchLocal(String local) {
		return oferta.searchLocal(local);
	}
	/**
	 * Obtiene una lista de Ofertas ordenadas segun un criterio especifico
	 * @param orden El criterio de ordenamiento 
	 * @return Una lista de objetos Oferta ordenados segun el criterio
	 */

	@Override
	public List<Oferta> getList(int orden) {
		return oferta.getList(orden);
	}
	/**
	 * 
	 */

	@Override
	public boolean check(String id) {
		return oferta.check(id);
	}
	@Override
	public List<Oferta> searchLocalLike(String localStrt){
		return oferta.searchLocalLike(localStrt);
	}
}
