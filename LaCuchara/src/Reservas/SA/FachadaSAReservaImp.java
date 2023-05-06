package Reservas.SA;

import java.util.List;

import Reservas.Reserva;

/**
    * Esta clase representa un objeto FachadaSAReservaImp implementa la clase IFachadaSAReserva
     */

public class FachadaSAReservaImp implements IFachadaSAReserva {


	/**
     * La reserva de la ISAReservas.
     */

	private ISAReservas SAReserva;

	/**
     * Crea una nueva instancia de la clase SAReservaImpl.
	* la crea como vacio
     */
	
	public FachadaSAReservaImp() {
		SAReserva = new SAReservaImpl();
	}

	/**
     * Modifica una reserva en la base de datos. 
     * @param id la Reserva con la info nueva 
	 * @return true si se han introducido la informacion nueva. False, en el caso contrario. 
     */

	public boolean modify(Reserva id) {
		return SAReserva.modify(id);
	}

	/**
     * Hace una consulta en la base de datos por el id de la reserva 
	 * @param id la id de la reserva a consultar.
	 * @return la reserva con toda su informacion.
     */

	public Reserva consult(String id) {
		return SAReserva.consult(id);
	}

	/**
     * Borra la informacion de la base de datos.
	 * @param id la id de la reserva a eliminar.
	 * @return true, si se ha eliminado la informacion de la reserva. False en el caso contrario.
     */	

	public boolean delete(String id) {
		return SAReserva.delete(id);
	}

	/**
     * Crea una nueva reserva en la base de datos. 
	 * @param r Con toda la informacion nueva a la base de datos 
	 * @return true, si se han introducido la informacion nueva. false en el caso contrario. 
     */

	public boolean create(Reserva r) {
		return SAReserva.create(r);
	}

	/**
     * Devuelve una lista de reservas que cumplen un criterio.
	 * @param r el filtro de busqueda. 
	 * @return Las reservas que cumplen los criterios. 
     */
	
	@Override
	public List<Reserva> search(String r) {
		return SAReserva.search(r);
	}

	/**
     * Devuelve la lista de reservas ordenadas. 
	 *@param orden El criterio de orden 
	 *@return Lista de reservas ordenada 
     */


	@Override
	public List<Reserva> getList(int orden) {
		return SAReserva.getList(orden);
	}
}
