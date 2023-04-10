package Reservas;

public class Fecha {
	private int dia;
	private int mes;
	private int year;
	
	public Fecha(int dia, int mes, int year) {
		this.dia=dia;
		this.mes=mes;
		this.year=year;
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getYear() {
		return year;
	}
	
	private String toMes() {
		if(mes == 1)
			return "Enero";
		else if(mes == 2)
			return "Febrero";
		else if(mes == 3)
			return "Marzo";
		else if(mes == 4)
			return "Abril";
		else if(mes == 5)
			return "Mayo";
		else if(mes == 6)
			return "Junio";
		else if(mes == 7)
			return "Julio";
		else if(mes == 8)
			return "Agosto";
		else if(mes == 9)
			return "Septiembre";
		else if(mes == 10)
			return "Octubre";
		else if(mes == 11)
			return "Noviembre";
		else
			return "Diciembre";
		
	}
	
	public String toString() {
		return dia+"-"+toMes()+"-"+year;
	}
}
