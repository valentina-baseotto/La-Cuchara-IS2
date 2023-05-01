package Ofertas;

/**
*	Esta interfaz define los métodos que deben implementar las ofertas.
*/
public interface Oferta_interface {

	/**
 * Obtiene la descripción de la oferta.
 * @return la descripción de la oferta.
 */
public String getDescripcion();

/**
 * Modifica la descripción de la oferta.
 * @param descripcion la nueva descripción de la oferta.
 */
public void setDescripcion(String descripcion);

/**
 * Obtiene el nombre del local asociado a la oferta.
 * @return el nombre del local asociado a la oferta.
 */
public String getNombre();

/**
 * Modifica el nombre del local asociado a la oferta.
 * @param nombre el nuevo nombre del local asociado a la oferta.
 */
public void setNombre(String nombre);

/**
 * Obtiene el id de la oferta.
 * @return el id de la oferta.
 */
public String getID();

/**
 * Modifica el id de la oferta.
 * @param iD el nuevo id de la oferta.
 */
public void setID(String iD);
}
