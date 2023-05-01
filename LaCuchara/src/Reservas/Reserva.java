package Reservas;


/**
 * Esta clase representa un objeto Reserva e implementa Reserva_interface.
 */

public class Reserva implements Reserva_interface {

	/**
     *	El numero de comensales de la Reserva.
     */

	private int _comensales;

	/**
     * El ID de la Reserva.
     */

	private String _ID;
	
	/**
	 * El ID del local en el que se realiza la reserva.
	 * */
	
	private String local;
	
	/**
	 * El ID del usuario que realiza la reserva.
	 * */
	
	private String usuario;
	
	/**
	* La fecha de la reserva con formato "YYYY-MM-DD".
	* */
	private String fecha;

	/**
     * Crea una nueva instancia de la clase Persona.
     * @param usuario El usuario que realiza la reserva
     * @param comensales El numero de comensales de la Reserva.
	 * @param ID El ID de la Reserva.
	 * @param local El local en el que se realiza la reserva.
	 * @param fecha La fecha de la reserva con formato "YYYY-MM-DD".
     */

	public Reserva(String ID, String local, String usuario,int comensales, String fecha) {
		this._comensales = comensales;
		this._ID = ID;
		this.usuario = usuario;
		this.local = local;
		this.fecha = fecha;
	}
	
	/**
     * Devuelve usuario como String.
     * @return el usuario.
     */
	
	public String getUsuario() {
		return usuario;
	}

	/**
     *Iguala el Usuario local con el dado por parametro
	 * @param usuario iguala el usuario con el dado 
     * 
     */
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
     * Devuelve local como String.
     * @return local.
     */
	
	public String getLocal() {
		return local;
	}

	/**
     *Iguala el Local this con el dado por parametro
	 * @param local iguala el Local con el dado 
     */
	
	public void setLocal(String local) {
		this.local = local;
	}

	/**
     * Devuelve el numero de comensales de la Reserva.
     * @return el numero de comensales de la Reserva.
     */

	public int getComensales() {
		return _comensales;
	}

	/**
     * Devuelve el numero de comensales de la Reserva.
     * @ @param comensales el numero de comensales de la Reserva.
     */

	public void setComensales(int comensales) {
		_comensales = comensales;
	}

	/**
     * Devuelve el ID de la Reserva.
     * @return el ID de la Reserva.
	 */

	public String getID() {
		return _ID;
	}

	/**
     * Devuelve el ID de la Reserva.
     * @ @param ID el ID de la Reserva.
     */

	public void setID(String ID) {
		_ID = ID;
	}
	
	/**
	 * Devuelve la Fecha
	 * @return
	 */
	public String getFecha(){
		return fecha;
	}
	
}
