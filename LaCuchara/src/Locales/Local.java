package Locales;
	/**
	*	Esta clase representa un objeto Local
	*	Esta clase implementa Local_interface
	*/
public class Local implements Local_interface {
	
	/**
	 * El nombre del local
	 * */
	private String _nombre;
	/**
	 * La direccion del local
	 * */
	private String _direccion;
	/**
	 * La carta del local
	 * */
	private String _carta;
	/**
	 * El telefono del local
	 * */
	private int _telefono;
	/**
	 * La descrippcion del local
	 * */
	private String _desc;
	/**
     * Crea una nueva instancia de la clase Persona.
     * @param _nombre El nombre del local
     * @param _direccion La direccion del local
	 * @param _carta La carta del local
	 * @param _telefono El telefono del local
	 * @param _desc La descrippcion del local
     */
	public Local(String nombre, String dir, String carta, int tel, String desc) {
		_nombre = nombre;
		_direccion  = dir;
		_carta = carta;
		_telefono = tel;
		_desc = desc;
		
	}
	/**
	*	Devuelve la descripcion del local
	*	@return _desc devuelve la descripcion del local
	*/
	public String getDescripcion() {
		return _desc;
	}
	/**
	*	introduce la descripcion del local
	*	@param nombre String con la descripcion
	*/
	public void setDescripcion(String desc) {
		_desc = desc;
	}
	/**
	*	Devuelve el nombre del local
	*	@return _nombre devuelve el nombre del local
	*/
	public String getNombre() {
		return _nombre;
	}
	/**
	*	introduce el nombre del local
	*	@param nombre String con el nombre
	*/
	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
	/**
	*	Devuelve la direccion del local
	*	@return _direccion devuelve la direccion del local
	*/
	public String getDireccion() {
		return _direccion;
	}
	/**
	*	introduce la direccion del local
	*	@param direccion String con la direccion
	*/
	public void setDireccion(String direccion) {
		this._direccion = direccion;
	}
	/**
	*	Devuelve la carta del local
	*	@return _carta devuelve un String con la carta
	*/
	public String getCarta() {
		return _carta;
	}
	/**
	*	introduce la carta del local
	*	@param carta String con la carta
	*/
	public void setCarta(String carta) {
		this._carta = carta;
	}
	/**
	*	Devuelve un numero de telefono
	*	@return _telefono devuelve el numero de telefono
	*/
	public int getTelefono() {
		return _telefono;
	}
	/**
	*	Introduce un telefono
	*	@param telefono String del telefono que se quiere añadir
	*	@throws NumberFormatException() cuando el numero de telefono no es un entero
	*/
	public void setTelefono(String telefono) {
		try {
			this._telefono = Integer.parseInt(telefono);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
	}

}
