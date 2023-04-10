package Cuchara;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import Usuarios.FachadaSAUsuarioImp;
import Usuarios.IFachadaSAUsuario;
import Usuarios.Usuario;
import windows.AppWindow;
import windows.GUIPerfil;

public class Controller {
	
	private IFachadaSAUsuario usuarios;
	private AppWindow app;
	private Usuario user;
	
	public Controller() {
		usuarios = new FachadaSAUsuarioImp();
	}
	
	public void loadData(InputStream in) {

		JSONObject jsonInupt = new JSONObject(new JSONTokener(in));
		
			JSONArray usuarios = jsonInupt.getJSONArray("usuarios");
			
			for (int i = 0; i < usuarios.length(); i++) {
				JSONObject usuario = usuarios.getJSONObject(i);
				Usuario usu = new Usuario(usuario.getString("name"), usuario.getString("mail"), usuario.getString("ID"), usuario.getInt("phone"), usuario.getString("pass"));
				this.usuarios.add(usu);
			}
	}
	
	public boolean login(String ID, String pass) {
		return usuarios.login(ID, pass);
	}
	
	public void openApp(String u) {
		user = usuarios.consult(u);
		app = new AppWindow(this);	
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public boolean addUser(Usuario u) {
		return usuarios.add(u);
	}

	public void save() {
		try {
			OutputStream out = new FileOutputStream(LaCuchara.in_out);
			PrintStream p = new PrintStream(out);
			p.println(usuarios.getUsuarios());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
