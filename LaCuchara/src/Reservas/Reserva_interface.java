package Reservas;


/**
 * Esta clase representa una interfaz Reserva_interface.
 */

public interface Reserva_interface {

	/**
     * Devuelve el numero de comensales de la Reserva.
     * @return el numero de comensales de la Reserva.
     */

	public int getComensales(); 

	/**
     * Devuelve el numero de comensales de la Reserva.
     * @param comensales el numero de comensales de la Reserva.
     */

	public void setComensales(int comensales);

	/**
     * Devuelve el ID de la Reserva.
     * @return el ID de la Reserva.
	 */

	public String getID();

	/**
     * Devuelve el ID de la Reserva.
     * @param ID el ID de la Reserva.
     */

	public void setID(String ID);
	
	/**
     * Devuelve el ID del local de la reserva.
     * @param local el ID del local de la reserva.
     */
	
	public void setLocal(String local);
	
	/**
     * Devuelve el ID del local de la reserva.
     * @return el local
     */
	
	public String getLocal();
	
	/**
     * Devuelve el ID del usuario de la reserva.
     * @param usuario 
     */
	
	public void setUsuario(String usuario);
	
	/**
     * Devuelve el ID del usuario de la reserva.
     * @return el usuario
     */
	
	public String getUsuario();
}