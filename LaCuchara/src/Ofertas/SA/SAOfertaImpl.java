package Ofertas.SA;

import java.util.List;

import Ofertas.Oferta;
import Ofertas.DAO.FachadaDAOOfertaImpl;
import Ofertas.DAO.IFachadaDAOOferta;

/**
*	Esta clase implementa la interfaz ISAOferta y proporciona los métodos para realizar operaciones con las ofertas.
*/
public class SAOfertaImpl implements ISAOferta {
/**
 * usuarioDAO de IFachadaDAOOferta
 */
private IFachadaDAOOferta usuarioDAO;

/**
 * Constructor por defecto que inicializa la instancia de usuarioDAO con una nueva instancia de FachadaDAOOfertaImpl.
 */
public SAOfertaImpl() {
	usuarioDAO = new FachadaDAOOfertaImpl();
}

/**
 * Modifica la información de una oferta en la base de datos.
 * @param oferta la oferta a modificar.
 * @return true si la oferta se modificó con éxito, false en caso contrario.
 */
public boolean modify(Oferta oferta) {
	return usuarioDAO.modify(oferta);
}

/**
 * Consulta la información de una oferta en la base de datos.
 * @param id el id de la oferta a consultar.
 * @return la oferta consultada o null si no se encontró ninguna oferta con el id especificado.
 */
public Oferta consult(String id) {
	return usuarioDAO.consult(id);
}

/**
 * Elimina una oferta de la base de datos.
 * @param id el id de la oferta a eliminar.
 * @return true si la oferta se eliminó con éxito, false en caso contrario.
 */
public boolean delete(String id) {
	return usuarioDAO.delete(id);
}

/**
 * Crea una nueva oferta en la base de datos.
 * @param oferta la oferta a crear.
 * @return true si la oferta se creó con éxito, false en caso contrario.
 */
public boolean create(Oferta oferta) {
	return usuarioDAO.create(oferta);
}

/**
 * Busca las ofertas asociadas a un local en la base de datos.
 * @param local el local a buscar.
 * @return una lista de ofertas asociadas al local especificado.
 */
public List<Oferta> searchLocal(String local) {
	return usuarioDAO.searchLocal(local);
}

@Override
/**
 * Obtiene una lista de ofertas ordenadas según el criterio especificado.
 * @param orden el criterio de ordenamiento (1 = precio ascendente, 2 = precio descendente, 3 = fecha de creación descendente).
 * @return una lista de ofertas ordenadas según el criterio especificado.
 */
public List<Oferta> getList(int orden) {
	return usuarioDAO.getList(orden);
}

@Override
/**
 * Verifica si una oferta existe en la base de datos.
 * @param id el id de la oferta a verificar.
 * @return true si la oferta existe en la base de datos, false en caso contrario.
 */
public boolean check(String id) {
	return usuarioDAO.check(id);
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
		return usuarioDAO.searchLocalLike(localStrt);
	}
}
