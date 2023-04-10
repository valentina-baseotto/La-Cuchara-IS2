package Usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class SAUsuarioImpl implements ISAUsuario {

	private List<Usuario> usuarios;
	
	public SAUsuarioImpl() {
		usuarios = new ArrayList<Usuario>();
	}

	public boolean modify(String id) {
		int index = -1, opcion = 0;
		Scanner get = new Scanner(System.in);
		String valor;
		boolean modified = false;

		index = existe(id);
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
					usuarios.get(index).setName(valor);
					modified = true;
				}
				break;

			case 2:
				System.out.print("Indique nueva ID(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					usuarios.get(index).setID(valor);
					modified = true;
				}
				break;

			case 3:
				System.out.print("Indique nuevo email(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					usuarios.get(index).setMail(valor);
					modified = true;
				}
				break;
			case 4:
				System.out.print("Indique nuevo email(-1 para cancelar operacion): ");
				valor = get.next();
				if (valor != "-1") {
					usuarios.get(index).setPass(valor);
					modified = true;
				}
				break;
			case 5:
				System.out.print("Indique nuevo email(-1 para cancelar operacion): ");
				int phone = get.nextInt();
				if (phone != -1) {
					usuarios.get(index).setPhone(phone);
					modified = true;
				}
				break;
			}
		}

		get.close();

		return modified;
	}

	private int existe(String id) {
		int existe = -1, index = -1;

		for (Usuario i : usuarios) {
			index++;
			if (id.equalsIgnoreCase(i.getID()))
				existe = index;

		}

		return existe;
	}

	public Usuario consult(String id) {
		Usuario usu = null;
		int index = existe(id);
		if (index != -1) {
			usu = usuarios.get(index);
			System.out.println("Nombre: " + usu.getName());
			System.out.println("ID: " + usu.getID());
			System.out.println("Descripcion: " + usu.getMail());
			System.out.println("Telefono: " + usu.getPhone());
			System.out.println("Contraseña: " + usu.getPass());
		} else
			System.out.println("No existe el id.");

		return usu;
	}

	public boolean delete(String id) {
		boolean ok = false;
		int index = existe(id);

		if (index != -1) {
			ok = true;
			usuarios.remove(index);
		}

		return ok;
	}

	public boolean create(Usuario id) {
		boolean ok = false;
		int index = existe(id.getID());
		if (index == -1) {
			usuarios.add(id);
			ok = true;
		}

		return ok;
	}

	@Override
	public boolean login(String nombre, String pass) {
		int index = existe(nombre);
		if(index != -1)
			if(usuarios.get(index).getPass().equals(pass))
				return true;
		
		return false;
	}

	@Override
	public boolean add(Usuario usuario) {
		for(Usuario u: usuarios) {
			if(u.getID().equals(usuario.getID()))
				return false;
		}
		
		usuarios.add(usuario);
		return true;
	}

	@Override
	public JSONObject getUsuarios() {
		JSONObject u = new JSONObject();
		JSONArray users = new JSONArray();
		
		for(Usuario user : usuarios) {
			users.put(user.getUsuario());
		}
		u.put("usuarios", users);
		
		return u;
	}

}
