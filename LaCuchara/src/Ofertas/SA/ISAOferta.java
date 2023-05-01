package Ofertas.SA;

import java.util.List;

import Ofertas.Oferta;

/**
 * Esta interfaz define los métodos que deben implementar los servicios de
 * aplicaciones de ofertas.
 */
public interface ISAOferta {
	/**
	 * Modifica una oferta existente.
	 * 
	 * @param oferta la oferta a modificar.
	 * @return true si la modificación se realizó correctamente, false en caso
	 *         contrario.
	 */
	public boolean modify(Oferta oferta);

	/**
	 * Consulta una oferta por su id.
	 * 
	 * @param id el id de la oferta a consultar.
	 * @return la oferta consultada.
	 */
	public Oferta consult(String id);

	/**
	 * Elimina una oferta por su id.
	 * 
	 * @param id el id de la oferta a eliminar.
	 * @return true si la eliminación se realizó correctamente, false en caso
	 *         contrario.
	 */
	public boolean delete(String id);

	/**
	 * Crea una nueva oferta.
	 * 
	 * @param oferta la oferta a crear.
	 * @return true si la creación se realizó correctamente, false en caso
	 *         contrario.
	 */
	public boolean create(Oferta oferta);

	/**
	 * Busca ofertas por el nombre del local asociado.
	 * 
	 * @param local el nombre del local asociado a las ofertas a buscar.
	 * @return una lista de ofertas encontradas.
	 */
	public List<Oferta> searchLocal(String local);

	/**
	 * Verifica si una oferta existe por su id.
	 * 
	 * @param id el id de la oferta a verificar.
	 * @return true si la oferta existe, false en caso contrario.
	 */
	public boolean check(String id);

	/**
	 * Obtiene una lista de ofertas.
	 * 
	 * @param orden el orden en el que se ordenará la lista (1: por id ascendente,
	 *              2: por id descendente).
	 * @return una lista de ofertas ordenada.
	 */
	public List<Oferta> getList(int orden);
	
	/**
	 * 
	 * Busca ofertas en la base de datos cuyo local empiece por localStrt.
	 *
	 * @param localStrt string que sirve para hacer la busqueda.
	 * 
	 * @return Una lista de ofertas que empiecen por localStrt.
	 */
	public List<Oferta> searchLocalLike(String localStrt);

}
