package Usuarios;

import org.json.JSONObject;

public interface IFachadaSAUsuario {

	public boolean modify(String id);
	
	public Usuario consult(String id);
	
	public boolean delete(String id);
	
	public boolean create(Usuario usuario);
	
	public boolean login(String id, String pass);
	
	public boolean add(Usuario usuario);

	public JSONObject getUsuarios();
}
