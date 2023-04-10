package Usuarios;

import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.JSONObject;

public class Usuario implements Usuario_Interface{
	private String _nombre;
	private String _mail;
	private String _ID;
	private int _movil;
	private String _pass;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String mail, String ID, int movil, String pass) {
		_nombre = nombre;
		_mail = mail;
		_ID = ID;
		_movil = movil;
		_pass = pass;
	}
	
	@Override
	public void setName(String name) {
		_nombre = name;
	}
	@Override
	public String getName() {
		return _nombre;
	}
	@Override
	public void setMail(String mail) {
		_mail = mail;
	}
	@Override
	public String getMail() {
		return _mail;
	}
	@Override
	public void setID(String ID) {
		_ID = ID;
	}
	@Override
	public String getID() {
		return _ID;
	}
	@Override
	public void setPhone(int phone) {
		_movil = phone;
	}
	@Override
	public int getPhone() {
		return _movil;
	}
	@Override
	public void setPass(String pass) {
		_pass = pass;
		
	}
	@Override
	public String getPass() {
		return _pass;
	}

	public JSONObject getUsuario() {
		JSONObject user = new JSONObject();
		
		user.put("name", this.getName());
		user.put("mail", this.getMail());
		user.put("ID", this.getID());
		user.put("phone", this.getPhone());
		user.put("pass", this.getPass());
		
		return user;
	}

}
