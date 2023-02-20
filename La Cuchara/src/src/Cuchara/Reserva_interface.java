package Cuchara;

import java.util.Date;

public interface Reserva_interface {

	public Date getFecha(); 
	public void setFecha(Date fecha); 
	public int getComensales(); 
	public void setComensales(int comensales);
	public String getID();
	public void setID(String ID);
}