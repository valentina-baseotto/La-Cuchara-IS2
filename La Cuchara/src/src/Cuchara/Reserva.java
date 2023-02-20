package Cuchara;

import java.util.Date;

public class Reserva implements Reserva_interface {

	private Date _fecha;
	private int _comensales;
	private String _ID;

	public Reserva(Date _fecha, int _comensales, String _ID) {
		this._fecha = _fecha;
		this._comensales = _comensales;
		this._ID = _ID;

	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
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
