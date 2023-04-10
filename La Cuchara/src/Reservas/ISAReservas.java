package Reservas;

import java.util.List;
import java.util.Scanner;

public class ISAReservas {

	private List<Reserva> Reservas;

	public boolean modify(String oferta) {
		int index = -1, opcion = 0;
		Scanner get = new Scanner(System.in);
		String valor;
		boolean modified = false;

		index = existe(oferta);
		if (index != -1) {
			do {
				System.out.print("1. Nombre");
				System.out.println("2. ID");
				System.out.println("3. Descripcion");
				System.out.print("Indique indice del valor a modificar: ");
				opcion = get.nextInt();
			} while (opcion < 1 && opcion > 3);

			switch (opcion) {
			case 1:
				System.out.print("Indique nuevo dia(-1 para cancelar operacion): ");
				int dia = get.nextInt();
				System.out.print("Indique nuevo mes en formato numerico(-1 para cancelar operacion): ");
				int mes = get.nextInt();
				System.out.print("Indique nuevo año(-1 para cancelar operacion): ");
				int year = get.nextInt();
				if (dia != -1 && mes != -1 && year != -1) {
					Reservas.get(index).setFecha(new Fecha(dia, mes, year));
					modified = true;
				}
				break;

			case 2:
				System.out.print("Indique nueva ID(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					Reservas.get(index).setID(valor);
					modified = true;
				}
				break;

			case 3:
				System.out.print("Indique nuevo numero de comensales(-1 para cancelar operacion): ");
				int comensales = get.nextInt();
				if (comensales != -1) {
					Reservas.get(index).setComensales(comensales);
					modified = true;
				}
				break;
			}
		}
		
		get.close();
		
		return modified;
	}

	private int existe(String reserva) {
		int existe = -1, index = -1;
		
		for(Reserva i: Reservas) {
			index++;
			if(i.getID().equalsIgnoreCase(reserva))
				existe = index;
			
		}
		
		return existe;
	}
	
	public void consult(String local) {
		int index=existe(local);
		if(index != -1) {
			System.out.println("ID de la reserva: " + Reservas.get(index).getID());
			System.out.println("Fecha: " + Reservas.get(index).getFecha());
			System.out.println("Comensales: " + Reservas.get(index).getComensales());
		}
		else
			System.out.println("No existe el local.");
	}
	
	public void delete(String local) {
		int index = existe(local);
		
		if(index != -1) {
			Reservas.remove(index);
		}
	}
	
	public void create(Reserva oferta) {
		Reservas.add(oferta); 
	}
	
}
