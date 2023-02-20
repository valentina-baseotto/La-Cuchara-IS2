package Cuchara;

public class Usuario implements usuario_interface{
	private String _nombre;
	private String _mail;
	private String _ID;
	private int _movil;
	private String _contraseña;
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
		_contraseña = pass;
		
	}
	@Override
	public String getPass() {
		return _contraseña;
	}

}
