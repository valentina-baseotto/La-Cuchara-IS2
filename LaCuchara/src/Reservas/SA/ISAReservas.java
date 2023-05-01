package Reservas.SA;

import java.util.List;

import Reservas.Reserva;

/**
    * Esta clase representa una interfaz ISAReservas
     */

public interface ISAReservas {

	/**
     * Devuelve si la reserva se ha modificado.
	 * @return reservas.modify().
     */

	public boolean modify(Reserva id);

	/**
     * Devuelve la reserva con la id especificada.
	 * @param id la id de la reserva a consultar.
	 * @return reservas.consut().
     */
	
	public Reserva consult(String id);

	/**
     * Devuelve si la reserva se ha eliminado.
	 * @param id la id de la reserva a eliminar.
	 * @return reservas.delete().
     */
	
	public boolean delete(String id);

	/**
     * Devuelve si la reserva se ha creado.
	 * @param reserva la id de la reserva a crear.
	 * @return reservas.create().
     */
	
	public boolean create(Reserva r);

	/**
     * Devuelve la reserva con String reserva.
	 * @param reserva la reserva a buscar.
	 * @return reservas.search().
     */
	
	public List<Reserva> search(String r);

	/**
     * Devuelve la lista de reservas.
	 * @return reservas.getList().
     */

	public List<Reserva> getList(int orden);
}
