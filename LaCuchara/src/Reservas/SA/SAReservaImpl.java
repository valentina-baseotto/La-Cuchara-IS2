package Reservas.SA;

import java.util.List;

import Reservas.Reserva;
import Reservas.DAO.FachadaDAOReservasImpl;
import Reservas.DAO.IFachadaDAOReservas;

/**
    * Esta clase representa un objeto SAReservaImpl implementa la clase ISAReservas
     */

public class SAReservaImpl implements ISAReservas{

	/**
     * La reserva de la IFachadaDAOReserva.
     */
	private IFachadaDAOReservas reservas;

/**
     * Crea una nueva instancia de la clase SAReservaImpl.
	* la crea como vacio
     */
	
	public SAReservaImpl() {
		reservas = new FachadaDAOReservasImpl();
	}

	/**
     * Modifica una reserva en la base de datos. 
     * @param id la Reserva con la info nueva 
	 * @return true si se han introducido la informacion nueva. False, en el caso contrario. 
     */
	
	public boolean modify(Reserva id) {
		return reservas.modify(id);
	}

	/**
     * Hace una consulta en la base de datos por el id de la reserva 
	 * @param id la id de la reserva a consultar.
	 * @return la reserva con toda su informacion.
     */
	
	public Reserva consult(String id) {
	return reservas.consult(id);
	}	

	/**
     * Borra la informacion de la base de datos.
	 * @param id la id de la reserva a eliminar.
	 * @return true, si se ha eliminado la informacion de la reserva. False en el caso contrario.
     */
	
	public boolean delete(String id) {
		return reservas.delete(id);
	}

	/**
     * Crea una nueva reserva en la base de datos. 
	 * @param reserva Con toda la informacion nueva a la base de datos 
	 * @return true, si se han introducido la informacion nueva. false en el caso contrario. 
     */
	
	public boolean create(Reserva reserva) {
		return reservas.create(reserva); 
	}

	/**
     * Devuelve una lista de reservas que cumplen un criterio.
	 * @param reserva el filtro de busqueda. 
	 * @return Las reservas que cumplen los criterios. 
     */
	
	public List<Reserva> search(String reserva) {
		return reservas.search(reserva);
	}

	/**
     * Devuelve la lista de reservas ordenadas. 
	 *@param orden El criterio de orden 
	 *@return Lista de reservas ordenada 
     */


	@Override
	public List<Reserva> getList(int orden) {
		return reservas.getList(orden);
	}
	

}
