package Usuarios;

/**
 * Esta clase representa una interfaz Usuario_Interface
 * 
 *
 */

public interface Usuario_Interface {
	/**Sets the user's name.
	* @param name el nombre
	*/
	public void setName(String name);
	
	/**gets the user's name.
	*
	*/
	public String getName();
	
	/**Sets the user's mail.
	* @param mail el mail
	*/
	public void setMail(String mail);
	
	/**gets the user's mail.
	*
	*/
	public String getMail();
	
	/**Sets the user's ID.
	* @param id la id
	*/
	public void setID(String ID);
	
	/**gets the user's ID.
	*
	*/
	public String getID();
	
	/**Sets the user's phone.
	* @param phone  el telefono
	*/
	public void setPhone(int phone);
	
	/**gets the user's phone.
	*
	*/
	public int getPhone();
	
	/**Sets the user's pass.
	* @param pass la contrasenia
	*/
	public void setPass(String pass);
	
	/**gets the user's pass.
	* 
	*/
	public String getPass();

}
