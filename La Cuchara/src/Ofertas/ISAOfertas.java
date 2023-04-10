package Ofertas;

import java.util.List;
import java.util.Scanner;

public class ISAOfertas {

	private List<Oferta> ofertas;

	public boolean modify(String local) {
		int index = -1, opcion = 0;
		Scanner get = new Scanner(System.in);
		String valor;
		boolean modified = false;

		index = existe(local);
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
				System.out.print("Indique nuevo nombre(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					ofertas.get(index).setNombre(valor);
					modified = true;
				}
				break;

			case 2:
				System.out.print("Indique nueva ID(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					ofertas.get(index).setID(valor);
					modified = true;
				}
				break;

			case 3:
				System.out.print("Indique nueva Descripcion(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					ofertas.get(index).setDescripcion(valor);
					modified = true;
				}
				break;
			}
		}
		
		get.close();
		
		return modified;
	}

	private int existe(String local) {
		int existe = -1, index = -1;
		
		for(Oferta i: ofertas) {
			index++;
			if(i.getNombre().equalsIgnoreCase(local))
				existe = index;
			
		}
		
		return existe;
	}
	
	public void consult(String local) {
		int index = existe(local);
		if(index != -1) {
			System.out.println("Nombre: " + ofertas.get(index).getNombre());
			System.out.println("ID: " + ofertas.get(index).getID());
			System.out.println("Descripcion: " + ofertas.get(index).getDescripcion());
		}
		else
			System.out.println("No existe el local.");
	}
	
	public void delete(String local) {
		int index = existe(local);
		
		if(index != -1) {
			ofertas.remove(index);
		}
	}
	
	public void create(Oferta oferta) {
		ofertas.add(oferta); 
	}
	
}
