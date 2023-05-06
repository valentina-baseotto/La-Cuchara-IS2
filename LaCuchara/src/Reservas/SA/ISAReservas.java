package Reservas.SA;

import java.util.List;

import Reservas.Reserva;

/**
    * Esta clase representa una interfaz ISAReservas
     */

public interface ISAReservas {

	/**
     * Modifica una reserva en la base de datos. 
     * @param id la Reserva con la info nueva 
	 * @return true si se han introducido la informacion nueva. False, en el caso contrario. 
     */

	public boolean modify(Reserva id);

	/**
     * Hace una consulta en la base de datos por el id de la reserva 
	 * @param id la id de la reserva a consultar.
	 * @return la reserva con toda su informacion.
     */
	
	public Reserva consult(String id);

	/**
     * Borra la informacion de la base de datos.
	 * @param id la id de la reserva a eliminar.
	 * @return true, si se ha eliminado la informacion de la reserva. False en el caso contrario.
     */
	
	public boolean delete(String id);

	/**
     * Crea una nueva reserva en la base de datos. 
	 * @param reserva Con toda la informacion nueva a la base de datos 
	 * @return true, si se han introducido la informacion nueva. false en el caso contrario. 
     */
	
	public boolean create(Reserva r);

	/**
     * Devuelve una lista de reservas que cumplen un criterio.
	 * @param reserva el filtro de busqueda. 
	 * @return Las reservas que cumplen los criterios. 
     */
	
	public List<Reserva> search(String r);

	/**
     * Devuelve la lista de reservas ordenadas. 
	 *@param orden El criterio de orden 
	 *@return Lista de reservas ordenada 
     */

	public List<Reserva> getList(int orden);
}
