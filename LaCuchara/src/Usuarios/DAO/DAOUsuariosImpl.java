package Usuarios.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Usuarios.Usuario;

/**
 * La clase DAOUsuariosImpl implementa la interfaz IDAOUsuario y define los métodos necesarios para la gestión de Usuarios en una base de datos.
 * 
 * La clase utiliza JDBC para interactuar con la base de datos MySQL 'lacuchara'.
 */

public class DAOUsuariosImpl implements IDAOUsuario {
	
	/**
	 * La URL de conexión a la base de datos MySQL.
	 */
	private String url = "jdbc:mySQL://localhost:3306/lacuchara";
	/**
	* El nombre de usuario utilizado para conectarse a la base de datos.
	*/
	private String usuario = "LaCuchara";
	/**
	 * La contraseña utilizada para conectarse a la base de datos.
	 */
	private String pass = "LaCuchara";
	/**
	 * Una conexión a la base de datos.
	 */
	private Connection con;
	/**
	* Un objeto de declaración SQL utilizado para ejecutar consultas en la base de datos.
	*/
	private Statement stmt;

/**
 * Constructor de la clase que registra el driver JDBC necesario para establecer la conexión con la BBDD.
 * 
 */
public DAOUsuariosImpl() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Clase no encontrada: " + e.getMessage());
	}
}

/**
 * devuelve el usuario que se ha querido comprobar
 * @param id la id del usuario a comprobar
 * @return true, si el id coincide con un usuario de la base de datos. False, en caso contrario.
*/
public boolean check(String id) {
	try {
		con = DriverManager.getConnection(url, usuario, pass);
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios where id = '" + id + "'");
		
		if (rs.next()) {
			con.close();
			return true;
		}

	} catch (SQLException e) {
		System.out.println("SQLException : " + e.getMessage());
		System.out.println("SQLState : " + e.getSQLState());
		System.out.println("VendorError : " + e.getErrorCode());
	} 
	
	return false;
}

/**
 * Hace una consulta en la base de datos para un solo usuario. 
 * @param id la id del usuario a consultar.
 * @return el usuario con toda su informacion
 */
public Usuario consult(String id) {
	Usuario usu = null;
	if (check(id)) {
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios where id = '" + id + "'");
			
			if (rs.next())
				usu = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5));
			con.close();
			
			return usu;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		} 
	}
	
	return null;
}

/**
 * Crea un nuevo usuario en la base de datos. 
 * @param usuario el objeto que se quiere introducir en la base de datos. 
 * @return True si se han introducido los datos. False, en caso contrario. 
 */
public boolean create(Usuario user) {
	if(!check(user.getID())) {
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			String id = user.getID();
			String name = user.getName();
			String mail = user.getMail();
			int phone = user.getPhone();
			String password = user.getPass();
			String nuevo;
			nuevo = "('" + id + "', '" + name + "', '" + mail + "', " + phone + ", '" + password + "')";
			stmt.execute("INSERT INTO usuarios (id, name, mail, phone , pass) VALUES " + nuevo);
				
			con.close();
			return true;

			} catch (SQLException e) {
				System.out.println("SQLException : " + e.getMessage());
				System.out.println("SQLState : " + e.getSQLState());
				System.out.println("VendorError : " + e.getErrorCode());
			}
		}
		return false;
	}

/**
*	Inicia sesion en la aplicaion. 
*	@param id La id del nuevo usuario
*   @param pass la contraseña del nuevo usuario
*   @return true si el id y el pass es del mismo usuario existen en la base de datos. False, en caso contrario. 
*/

	public boolean login(String id, String pass) {
		if(check(id)) {
			try {
				con = DriverManager.getConnection(url, usuario, this.pass);
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios where pass = '" + pass + "' AND id = '" + id + "'");
				
				
				if (rs.next()) {
					con.close();
					return true;
				}

			} catch (SQLException e) {
				System.out.println("SQLException : " + e.getMessage());
				System.out.println("SQLState : " + e.getSQLState());
				System.out.println("VendorError : " + e.getErrorCode());
			} 
		}
		return false;
	}

	/**
     *	Elimina un usuario de la base de datos
	 * @param id la id del usuario a eliminar.
	 * @return true, si se ha eliminado el usuario. False, en el caso contrario. 
     */

	public boolean delete(String id) {
		if(check(id)) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				stmt.execute("DELETE FROM usuarios where id = '" + id + "'");
				con.close();
				
				return true;


			} catch (SQLException e) {
				System.out.println("SQLException : " + e.getMessage());
				System.out.println("SQLState : " + e.getSQLState());
				System.out.println("VendorError : " + e.getErrorCode());
			}
		}
		return false;
	}

	/**
     * Modifica un usuario en la base de datos. 
	 * @param usuario el usuario a modificar con la nueva informacion.
	 * @return true, si se han introducido los nuevos datos. False, en el caso contrario. 
     */	

	public boolean modify(Usuario usuario) {
		if(check(usuario.getID())) {
			try {
				con = DriverManager.getConnection(url, this.usuario, pass);
				stmt = con.createStatement();
				stmt.execute("UPDATE usuarios SET name = '"+ usuario.getName() + "', mail = '" + usuario.getMail() + "', phone = '" 
				+ usuario.getPhone() + "', pass = '" + usuario.getPass() + "' WHERE id = '" + usuario.getID() + "'");
				con.close();
				
				return true;


			} catch (SQLException e) {
				System.out.println("SQLException : " + e.getMessage());
				System.out.println("SQLState : " + e.getSQLState());
				System.out.println("VendorError : " + e.getErrorCode());
			}
		}
		return false;
	}

	/**
     * Devuelve una lista de Usuarios que cumplen con los filtros. 
	 * @param name
	 * @return La lista de usuarios que cumplen con los filtros.
     */	

	public List<Usuario> search(String name) {
		boolean ok= false;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios where name LIKE '" + name + "%'");
			
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
				ok=true;
			}
			
			con.close();
			if (ok)
				return usuarios;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		} 

		return null;
	}

	/**
     * Devuelve la lista de usuario ordenados. 
	 * @param orden el criterio para ordenar
	 * @return la lista ordenada.
     */

	
	public List<Usuario> getList(int orden) {
		boolean ok= false;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
			
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
				ok=true;
			}

			con.close();
			if (ok)
				return usuarios;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		}

		return null;
	}
	

}
