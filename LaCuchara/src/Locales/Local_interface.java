package Locales;
/**
 * Esta clase representa una interfaz Local_interface.
 */
public interface Local_interface {
	/**
	*	Devuelve el nombre del local
	*	@return _nombre devuelve el nombre del local
	*/
	public String getNombre();
	/**
	*	introduce el nombre del local
	*	@param nombre String con el nombre
	*/
	public void setNombre(String nombre);
	/**
	*	Devuelve la direccion del local
	*	@return _direccion devuelve la direccion del local
	*/
	public String getDireccion();
	/**
	*	introduce la direccion del local
	*	@param direccion String con la direccion
	*/
	public void setDireccion(String direccion);
	/**
	*	Devuelve la carta del local
	*	@return _carta devuelve un String con la carta
	*/
	public String getCarta();
	/**
	*	introduce la carta del local
	*	@param carta String con la carta
	*/
	public void setCarta(String carta);
	/**
	*	Devuelve un numero de telefono
	*	@return _telefono devuelve el numero de telefono
	*/
	public int getTelefono();
	/**
	*	Introduce un telefono
	*	@param telefono String del telefono que se quiere añadir
	*	@throws NumberFormatException() cuando el numero de telefono no es un entero
	*/
	public void setTelefono(String telefono);
	/**
	*	introduce la descripcion del local
	*	@param nombre String con la descripcion
	*/
	public void setDescripcion(String desc);
	/**
	*	Devuelve la descripcion del local
	*	@return _desc devuelve la descripcion del local
	*/
	public String getDescripcion();
}
