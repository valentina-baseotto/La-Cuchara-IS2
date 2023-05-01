package Ofertas.DAO;

import java.util.List;

import Ofertas.Oferta;

/**
 * Esta clase implementa la interfaz IFachadaDAOOferta y define los métodos para
 * acceder a la capa de datos de las ofertas.
 */
public class FachadaDAOOfertaImpl implements IFachadaDAOOferta {

	IDAOOferta OfertaDAO;

	/**
	 * Constructor por defecto que inicializa el objeto OfertaDAO con una instancia
	 * de DAOOfertaImpl.
	 */
	public FachadaDAOOfertaImpl() {
		OfertaDAO = new DAOOfertaImpl();
	}

	/**
	 * Verifica si existe una oferta con el id especificado.
	 * 
	 * @param id el id de la oferta a buscar.
	 * @return true si la oferta existe, false en caso contrario.
	 */
	@Override
	public boolean check(String id) {
		return OfertaDAO.check(id);
	}

	/**
	 * Obtiene la oferta con el id especificado.
	 * 
	 * @param id el id de la oferta a consultar.
	 * @return la oferta con el id especificado, o null si no existe.
	 */
	@Override
	public Oferta consult(String id) {
		return OfertaDAO.consult(id);
	}

	/**
	 * Crea una nueva oferta.
	 * 
	 * @param Oferta la oferta a crear.
	 * @return true si la oferta se ha creado correctamente, false en caso
	 *         contrario.
	 */
	@Override
	public boolean create(Oferta Oferta) {
		return OfertaDAO.create(Oferta);
	}

	/**
	 * Elimina la oferta con el id especificado.
	 * 
	 * @param id el id de la oferta a eliminar.
	 * @return true si la oferta se ha eliminado correctamente, false en caso
	 *         contrario.
	 */
	@Override
	public boolean delete(String id) {
		return OfertaDAO.delete(id);
	}

	/**
	 * Modifica la oferta especificada.
	 * 
	 * @param Oferta la oferta a modificar.
	 * @return true si la oferta se ha modificado correctamente, false en caso
	 *         contrario.
	 */
	@Override
	public boolean modify(Oferta Oferta) {
		return OfertaDAO.modify(Oferta);
	}

	/**
	 * Obtiene una lista de ofertas ordenada según el criterio especificado.
	 * 
	 * @param orden el criterio de ordenación.
	 * @return la lista de ofertas ordenada según el criterio especificado.
	 */
	@Override
	public List<Oferta> getList(int orden) {
		return OfertaDAO.getList(orden);
	}

	/**
	 * Busca ofertas por local.
	 * 
	 * @param local el local donde se ofrecen las ofertas.
	 * @return una lista de ofertas ofrecidas en el local especificado.
	 */
	@Override
	public List<Oferta> searchLocal(String local) {
		return OfertaDAO.searchLocal(local);
	}

	/**
	 * 
	 * Busca ofertas en la base de datos cuyo local empiece por localStrt.
	 *
	 * @param localStrt string que sirve para hacer la busqueda.
	 * 
	 * @return Una lista de ofertas que empiecen por localStrt.
	 */
	@Override
	public List<Oferta> searchLocalLike(String localStrt){
		return OfertaDAO.searchLocalLike(localStrt);
	}

}
