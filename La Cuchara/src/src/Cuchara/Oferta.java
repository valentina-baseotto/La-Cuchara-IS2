package Cuchara;

public class Oferta implements Oferta_interface {

	private String _descripcion;
	private String _nombre;
	private String _ID;

	public Oferta(String _descripcion, String _nombre, String _ID) {
		this._descripcion = _descripcion;
		this._nombre = _nombre;
		this._ID = _ID;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		this._descripcion = descripcion;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		this._nombre = nombre;
	}

	public String getID() {
		return _ID;
	}

	public void setID(String iD) {
		_ID = iD;
	}
}
