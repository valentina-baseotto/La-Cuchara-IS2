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
     * Devuelve si la reserva se ha modificado.
	 * @return reservas.modify().
     */
	
	public boolean modify(Reserva id) {
		return reservas.modify(id);
	}

	/**
     * Devuelve la reserva con la id especificada.
	 * @param id la id de la reserva a consultar.
	 * @return reservas.consut().
     */
	
	public Reserva consult(String id) {
	return reservas.consult(id);
	}	

	/**
     * Devuelve si la reserva se ha eliminado.
	 * @param id la id de la reserva a eliminar.
	 * @return reservas.delete().
     */
	
	public boolean delete(String id) {
		return reservas.delete(id);
	}

	/**
     * Devuelve si la reserva se ha creado.
	 * @param reserva la id de la reserva a crear.
	 * @return reservas.create().
     */
	
	public boolean create(Reserva reserva) {
		return reservas.create(reserva); 
	}

	/**
     * Devuelve la reserva con String reserva.
	 * @param reserva la reserva a buscar.
	 * @return reservas.search().
     */
	
	public List<Reserva> search(String reserva) {
		return reservas.search(reserva);
	}

	/**
     * Devuelve la lista de reservas.
	 * @return reservas.getList().
     */


	@Override
	public List<Reserva> getList(int orden) {
		return reservas.getList(orden);
	}
	

}
