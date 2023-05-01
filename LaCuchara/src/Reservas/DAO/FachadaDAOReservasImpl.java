package Reservas.DAO;

import java.util.List;

import Reservas.Reserva;

/**
    * Esta clase representa un objeto FachadaDAOReservasImpl implementa la clase IFachadaDAOReservas
     */

public class FachadaDAOReservasImpl implements IFachadaDAOReservas {

	/**
     * La reserva de la IFachadaDAOReserva.
     */

	private IDAOReserva reserva;

	/**
     * Crea una nueva instancia de la clase FachadaDAOReservasImpl.
	* la crea como vacio
     */
	
	public FachadaDAOReservasImpl() {
		reserva = new DAOReservasImpl();
	}

	/**
     * Devuelve si la reserva se ha modificado.
	 * @return reservas.modify().
     */	
	
	@Override
	public boolean modify(Reserva id) {
		return reserva.modify(id);
	}

	/**
     * Devuelve la reserva con la id especificada.
	 * @param id la id de la reserva a consultar.
	 * @return reservas.consut().
     */	

	@Override
	public Reserva consult(String id) {
		return reserva.consult(id);
	}

	/**
     * Devuelve si la reserva se ha eliminado.
	 * @param id la id de la reserva a eliminar.
	 * @return reservas.delete().
     */	

	@Override
	public boolean delete(String id) {
		return reserva.delete(id);
	}

	/**
     * Devuelve si la reserva se ha creado.
	 * @param reserva la id de la reserva a crear.
	 * @return reservas.create().
     */	

	@Override
	public boolean create(Reserva r) {
		return reserva.create(r);
	}

	/**
     * Devuelve la reserva con String reserva.
	 * @param reserva la reserva a buscar.
	 * @return reservas.search().
     */	

	@Override
	public List<Reserva> search(String r) {
		return reserva.search(r);
	}

	/**
     * Devuelve la lista de reservas.
	 * @return reservas.getList().
     */	

	@Override
	public List<Reserva> getList(int orden) {
		return reserva.getList(orden);
	}

}
