package Reservas.DAO;

import java.util.List;

import Reservas.Reserva;

/**
    * Esta clase representa una interfaz IDAOReserva
     */


public interface IDAOReserva {

	/**
     * Devuelve si la reserva se ha modificado.
     * @param id identificador
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
	 * @param r Objeto reserva 
	 * @return reservas.create().
     */
	
	public boolean create(Reserva r);

	/**
     * Devuelve la reserva con String reserva.
	 * @param r 
	 * @return reservas.search().
     */
	
	public List<Reserva> search(String r);

	/**
     * Devuelve la lista de reservas.
	 * @return reservas.getList().
     */
	
	public List<Reserva> getList(int orden);
}
