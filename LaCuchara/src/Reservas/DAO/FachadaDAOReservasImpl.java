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
     * Modifica una reserva en la base de datos. 
     * @param id la Reserva con la info nueva 
	 * @return true si se han introducido la informacion nueva. False, en el caso contrario. 
     */
	
	@Override
	public boolean modify(Reserva id) {
		return reserva.modify(id);
	}

	/**
     * Hace una consulta en la base de datos por el id de la reserva 
	 * @param id la id de la reserva a consultar.
	 * @return la reserva con toda su informacion.
     */	

	@Override
	public Reserva consult(String id) {
		return reserva.consult(id);
	}

	/**
     * Borra la informacion de la base de datos.
	 * @param id la id de la reserva a eliminar.
	 * @return true, si se ha eliminado la informacion de la reserva. False en el caso contrario.
     */	

	@Override
	public boolean delete(String id) {
		return reserva.delete(id);
	}

	/**
     * Crea una nueva reserva en la base de datos. 
	 * @param r Con toda la informacion nueva a la base de datos 
	 * @return true, si se han introducido la informacion nueva. false en el caso contrario. 
     */	

	@Override
	public boolean create(Reserva r) {
		return reserva.create(r);
	}

	/**
     * Devuelve una lista de reservas que cumplen un criterio.
	 * @param r el filtro de busqueda. 
	 * @return Las reservas que cumplen los criterios. 
     */

	@Override
	public List<Reserva> search(String r) {
		return reserva.search(r);
	}

	/**
     * Devuelve la lista de reservas ordenadas. 
	 *@param orden El criterio de orden 
	 *@return Lista de reservas ordenada 
     */

	@Override
	public List<Reserva> getList(int orden) {
		return reserva.getList(orden);
	}

}
