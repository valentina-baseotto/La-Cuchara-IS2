package Locales;

public class Local implements Local_interface {

	private String _nombre;
	private String _direccion;
	private String _carta;
	private int _telefono;
	public String getNombre() {
		return _nombre;
	}
	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
	public String getDireccion() {
		return _direccion;
	}
	public void setDireccion(String direccion) {
		this._direccion = direccion;
	}
	public String getCarta() {
		return _carta;
	}
	public void setCarta(String carta) {
		this._carta = carta;
	}
	public int getTelefono() {
		return _telefono;
	}
	public void setTelefono(String telefono) {
		try {
			this._telefono = Integer.parseInt(telefono);
		}
		catch(NumberFormatException e) {
			throw new NumberFormatException();
		}
	}
		
}
