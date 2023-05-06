package Usuarios;

/**
 * Esta clase es la interfaz del Usuario
 *
 */
public interface Usuario_Interface {
	/**Poner el name como el nombre del usuario
	* @param name el nombre
	*/
	public void setName(String name);
	
	/**Devulve el nombre del usuario
		@param _nombre 
	*/
	public String getName();
	
	/**Pone ese mail se pone como el mail del ususario
		* @param mail el mail
	*/
	public void setMail(String mail);
	
	/**Devuelve el mail del usuario
	 * @param _mail 
	
	*/
	public String getMail();
	
	/**Pone el ID como el ID del usuario
		* @param ID 
	*/
	public void setID(String ID);
	
	/**Devuelve el _id del usuario
	 * @param _id
	*/
	public String getID();
	
	/**Pone el phone como el telefono del usuario
		* @param phone el telefono 
	*/
	public void setPhone(int phone);
	
	/**Devuelve el telefono del usuario. 
	 * @return _phone
	*/
	public int getPhone();
	
	/**Asigna la contraseña al usuario.
		* @param pass la contrasenia
	*/
	public void setPass(String pass);
	
	/**Devuelve la contraseña del usuario
	 * @return la contraseña del usuario
	*/
	public String getPass();

}
