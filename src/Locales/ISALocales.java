package Locales;

import java.util.List;
import java.util.Scanner;

public class ISALocales {
	private List<Local> locales;

	public boolean modify(String local) {
		int index = -1, opcion = 0;
		Scanner get = new Scanner(System.in);
		String valor;
		boolean modified = false;

		index = existe(local);
		if (index != -1) {
			do {
				System.out.print("1. Nombre");
				System.out.println("2. Direccion");
				System.out.println("3. Carta");
				System.out.println("4. Telefono");
				System.out.print("Indique indice del valor a modificar: ");
				opcion = get.nextInt();
			} while (opcion < 1 && opcion > 4);

			switch (opcion) {
			case 1:
				System.out.print("Indique nuevo nombre(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					locales.get(index).setNombre(valor);
					modified = true;
				}
				break;

			case 2:
				System.out.print("Indique nueva direccion(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					locales.get(index).setDireccion(valor);
					modified = true;
				}
				break;

			case 3:
				System.out.print("Indique nueva carta(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					locales.get(index).setCarta(valor);
					modified = true;
				}
				break;

			case 4:
				System.out.print("Indique nuevo telefono(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					try {
						locales.get(index).setTelefono(valor);
						modified = true;
					} catch (NumberFormatException e) {
						System.out.println("Parametro invalido(no es un numero valido)");
					}
				}
				break;
			}
		}
		
		get.close();
		
		return modified;
	}

	private int existe(String local) {
		int existe = -1, index = -1;
		
		for(Local i: locales) {
			index++;
			if(i.getNombre() == local)
				existe = index;
			
		}
		
		return existe;
	}
	
	public void consult(String local) {
		int index=existe(local);
		if(index != -1) {
			System.out.println("Nombre: " + locales.get(index).getNombre());
			System.out.println("Direccion: " + locales.get(index).getDireccion());
			System.out.println("Telefono: " + locales.get(index).getTelefono());
			System.out.println("Carta: " + locales.get(index).getCarta());
		}
		else
			System.out.println("No existe el local.");
	}
	
	public void delete(String local) {
		int index = existe(local);
		
		if(index != -1) {
			locales.remove(index);
		}
	}
	
	public void create(Local local) {
		locales.add(local); 
	}
}
