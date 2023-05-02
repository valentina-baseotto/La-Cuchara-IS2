package Ofertas;

/**
 * Esta clase representa una oferta y proporciona los métodos para obtener y
 * modificar sus atributos.
 */
public class Oferta implements Oferta_interface {

	/**
	 * _descripcion de tipo String, descripcion de lo qe significa la Oferta
	 */
	private String _descripcion;
	/**
	 * _nombreLocal de tipo String, el nombre del Local del cual pertenece la oferta
	 */
	private String _nombreLocal;
	/**
	 * _ID de tipo String, el ID unico para cada Oferta para identificarlas
	 */
	private String _ID;

	/**
	 * Constructor que inicializa los atributos de la oferta.
	 * 
	 * @param _ID          el id de la oferta.
	 * @param _descripcion la descripción de la oferta.
	 * @param _nombre      el nombre del local asociado a la oferta.
	 */
	public Oferta(String _ID, String _descripcion, String _nombre) {
		this._descripcion = _descripcion;
		this._nombreLocal = _nombre;
		this._ID = _ID;
	}

	/**
	 * Obtiene la descripción de la oferta.
	 * 
	 * @return la descripción de la oferta.
	 */
	public String getDescripcion() {
		return _descripcion;
	}

	/**
	 * Modifica la descripción de la oferta.
	 * 
	 * @param descripcion la nueva descripción de la oferta.
	 */
	public void setDescripcion(String descripcion) {
		this._descripcion = descripcion;
	}

	/**
	 * Obtiene el nombre del local asociado a la oferta.
	 * 
	 * @return el nombre del local asociado a la oferta.
	 */
	public String getNombre() {
		return _nombreLocal;
	}

	/**
	 * Modifica el nombre del local asociado a la oferta.
	 * 
	 * @param nombre el nuevo nombre del local asociado a la oferta.
	 */
	public void setNombre(String nombre) {
		this._nombreLocal = nombre;
	}

	/**
	 * Obtiene el id de la oferta.
	 * 
	 * @return el id de la oferta.
	 */
	public String getID() {
		return _ID;
	}

	/**
	 * Modifica el id de la oferta.
	 * 
	 * @param iD el nuevo id de la oferta.
	 */
	public void setID(String iD) {
		_ID = iD;
	}
}
