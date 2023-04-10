package Reservas;

public class Reserva implements Reserva_interface {

	private Fecha _fecha;
	private int _comensales;
	private String _ID;

	public Reserva(Fecha _fecha, int _comensales, String _ID) {
		this._fecha = _fecha;
		this._comensales = _comensales;
		this._ID = _ID;

	}

	public String getFecha() {
		return _fecha.toString();
	}

	public void setFecha(Fecha fecha) {
		_fecha = fecha;
	}

	public int getComensales() {
		return _comensales;
	}

	public void setComensales(int comensales) {
		_comensales = comensales;
	}

	public String getID() {
		return _ID;
	}

	public void setID(String ID) {
		_ID = ID;
	}
}
