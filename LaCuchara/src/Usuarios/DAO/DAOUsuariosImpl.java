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
	
	private String url = "jdbc:mySQL://localhost:3306/lacuchara";
	private String usuario = "LaCuchara";
	private String pass = "LaCuchara";
	private Connection con;
	private Statement stmt;

/**
 * Constructor de la clase que registra el driver JDBC necesario para establecer la conexión con la BBDD.
 */
public DAOUsuariosImpl() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Clase no encontrada: " + e.getMessage());
	}
}

/**
 * Comprueba si existe un usuario en la base de datos con el ID especificado.
 * @param id el ID del usuario a comprobar.
 * @return true si existe un usuario en la base de datos con el ID especificado, false en caso contrario.
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
 * Consulta un usuario existente en la base de datos con el ID especificado.
 * @param id el ID del usuario a consultar.
 * @return un objeto Usuario con los datos del usuario consultado, o null si no se encontró ningún usuario con el ID especificado.
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
 * @param user el objeto Usuario que contiene los datos del usuario a crear.
 * @return true si el usuario fue creado exitosamente, false si ya existe un usuario en la base de datos con el mismo ID.
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
Método que permite autenticar a un usuario en la base de datos.
@param id Identificador del usuario.
@param pass Contraseña del usuario.
@return true si el usuario ha sido autenticado correctamente, false en caso contrario.
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
	Método que permite eliminar un usuario de la base de datos.
@param id Identificador del usuario a eliminar.
@return true si el usuario ha sido eliminado correctamente, false en caso contrario.
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
Método que permite modificar un usuario de la base de datos.
@param usuario Objeto Usuario con los datos actualizados del usuario a modificar.
@return true si el usuario ha sido modificado correctamente, false en caso contrario.
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

Método que permite buscar usuarios en la base de datos por su nombre.
@param name Nombre de usuario a buscar.
@return Lista de objetos Usuario que coinciden con el nombre proporcionado, o null si no se encontraron usuarios.
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
	Retrieves a list of users from the database.
	@param orden an integer representing the desired order of the results
	@return a List of Usuario objects containing the results of the query, or null if an error occurs
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
