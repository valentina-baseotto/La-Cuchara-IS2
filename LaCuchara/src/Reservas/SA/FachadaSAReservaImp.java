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
     * Devuelve si la reserva se ha modificado.
	 * @param id la id de la reserva a modificar
	 * @return SAReservas.modify().
     */

	public boolean modify(Reserva id) {
		return SAReserva.modify(id);
	}

	/**
     * Devuelve la reserva con la id especificada.
	 * @param id la id de la reserva a consultar.
	 * @return SAReservas.consut().
     */	

	public Reserva consult(String id) {
		return SAReserva.consult(id);
	}

	/**
     * Devuelve si la reserva se ha eliminado.
	 * @param id la id de la reserva a eliminar.
	 * @return SAReservas.delete().
     */	

	public boolean delete(String id) {
		return SAReserva.delete(id);
	}

	/**
     * Devuelve si la reserva se ha creado.
	 * @param r la id de la reserva a crear.
	 * @return SAReservas.create().
     */

	public boolean create(Reserva r) {
		return SAReserva.create(r);
	}

	/**
     * Devuelve la reserva con String reserva.
	 * @param r la reserva a buscar.
	 * @return SAReservas.search().
     */	
	
	@Override
	public List<Reserva> search(String r) {
		return SAReserva.search(r);
	}

	/**
     * Devuelve la lista de reservas.
	 * @return reservas.getList().
     */


	@Override
	public List<Reserva> getList(int orden) {
		return SAReserva.getList(orden);
	}
}
