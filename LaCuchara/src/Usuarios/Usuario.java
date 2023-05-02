package Usuarios;

import org.json.JSONObject;

/**
 * Esta clase representa un usuario en un sistema. Un usuario tiene un nombre, correo electrónico, ID,
 * número de móvil y contraseña.
 */

public class Usuario implements Usuario_Interface{
	/**
	 * Nombre del usuario
	 */
	private String _nombre;
	/**
	 * el correo electronico del usuario
	 */
	private String _mail;
	/**
	 * Id que se le otorga al Usuario
	 */
	private String _ID;
	/**
	 * numero de movil del usuario
	 */
	private int _movil;
	/**
	 * Contraseña del usuario
	 */
	private String _pass;
	
	/**
     * Constructor por defecto para la clase Usuario.
     */
    public Usuario() {

    }

    /**
     * Crea una nueva instancia de Usuario con los datos proporcionados.
     *
     * @param ID     el ID del usuario.
     * @param nombre el nombre del usuario.
     * @param mail   el correo electrónico del usuario.
     * @param movil  el número de móvil del usuario.
     * @param pass   la contraseña del usuario.
     */
	public Usuario(String ID, String nombre, String mail, int movil, String pass) {
		_nombre = nombre;
		_mail = mail;
		_ID = ID;
		_movil = movil;
		_pass = pass;
	}
	
	@Override

	/**Sets the user's name.
	* @param name el nombre
	*/

	public void setName(String name) {
		_nombre = name;
	}

	/**gets the user's name.
	*/

	@Override
	public String getName() {
		return _nombre;
	}

	/**Sets the user's mail.
		* @param mail el mail
	*/

	@Override
	public void setMail(String mail) {
		_mail = mail;
	}

	/**gets the user's mail.	
	*/

	@Override
	public String getMail() {
		return _mail;
	}

	/**Sets the user's ID.
		* @param ID la id
	*/

	@Override
	public void setID(String ID) {
		_ID = ID;
	}

	/**gets the user's ID.
	*/

	@Override
	public String getID() {
		return _ID;
	}

	/**Sets the user's phone.
		* @param phone  el telefono
	*/

	@Override
	public void setPhone(int phone) {
		_movil = phone;
	}

	/**gets the user's phone.
	*/

	@Override
	public int getPhone() {
		return _movil;
	}

	/**Sets the user's pass.
		* @param pass la contrasenia
	*/

	@Override
	public void setPass(String pass) {
		_pass = pass;
		
	}

	/**gets the user's pass.
	*/

	@Override
	public String getPass() {
		return _pass;
	}

	/**gets the JSONObject geneated by the parameters
	 * @return user 
	*/

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
