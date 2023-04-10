package Usuarios;

import org.json.JSONObject;

public class FachadaSAUsuarioImp implements IFachadaSAUsuario {
	private ISAUsuario SAUsuario;
	
	public FachadaSAUsuarioImp() {
		SAUsuario = new SAUsuarioImpl();
	}

	public boolean modify(String id) {
		return SAUsuario.modify(id);
	}

	public Usuario consult(String id) {
		return SAUsuario.consult(id);
	}

	public boolean delete(String id) {
		return SAUsuario.delete(id);
	}

	public boolean create(Usuario usuario) {
		return SAUsuario.create(usuario);
	}

	public boolean login(String id, String pass) {
		return SAUsuario.login(id, pass);
	}
	
	public boolean add(Usuario usuario) {
		return SAUsuario.add(usuario);
	}

	@Override
	public JSONObject getUsuarios() {
		return SAUsuario.getUsuarios();
	}

}
