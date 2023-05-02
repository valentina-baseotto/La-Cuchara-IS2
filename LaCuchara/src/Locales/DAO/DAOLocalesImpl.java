package Locales.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Locales.Local;
/**
 * La clase DAOLocalesImpl implementa la interfaz IDAOLocales y define los métodos necesarios para la gestión de locales en una base de datos.
 * 
 * La clase utiliza JDBC para interactuar con la base de datos MySQL 'lacuchara'.
 */
public class DAOLocalesImpl implements IDAOLocales {
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
	 * Crea una nueva instancia de DAOLocalesImpl.
	 * 
	 */
	public DAOLocalesImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada: " + e.getMessage());
		}
	}

	/**
	 * Verifica si un local con el ID proporcionado existe en la base de datos.
	 * @param id El ID del local a verificar.
	 * @return true si el local existe en la base de datos, de lo contrario false.
	 */
	public boolean check(String id) {
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM locales where nombre = '" + id + "'");
			
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
	 * Obtiene un objeto Local desde la base de datos que coincida con el ID proporcionado.
	 * @param id El ID del local a buscar en la base de datos.
	 * @return Un objeto Local si se encuentra en la base de datos, de lo contrario null.
	 */
	public Local consult(String id) {
		Local local = null;
		if (check(id)) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM locales where nombre = '" + id + "'");
				
				if (rs.next())
					local = new Local(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5));
				
				con.close();
				return local;

			} catch (SQLException e) {
				System.out.println("SQLException : " + e.getMessage());
				System.out.println("SQLState : " + e.getSQLState());
				System.out.println("VendorError : " + e.getErrorCode());
			}
		}
		
		return null;
	}

	/**
	 * Crea un nuevo local en la base de datos.
	 * @param Local El local a crear en la base de datos.
	 * @return true si el local se crea correctamente, de lo contrario false.
	 */
	public boolean create(Local Local) {
		if(!check(Local.getNombre())) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				
				String name = Local.getNombre();
				String direccion = Local.getDireccion();
				String carta = Local.getCarta();
				int phone = Local.getTelefono();
				String descripcion = Local.getDescripcion();
				String nuevo;
				nuevo = "('" + name + "', '" + direccion + "', '" + carta + "', " + phone + ", '" + descripcion + "')";
				stmt.execute("INSERT INTO locales (nombre, dir, carta, phone , descripcion) VALUES " + nuevo);
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
 	* Elimina un local con el ID proporcionado de la base de datos.
 	* @param id El ID del local a eliminar de la base de datos.
 	* @return true si el local se elimina correctamente, de lo contrario false.
 	*/
	public boolean delete(String id) {
		if(check(id)) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				stmt.execute("DELETE FROM locales where nombre = '" + id + "'");
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
	* Modifica un objeto de tipo Local en la base de datos. Si el objeto no existe, devuelve false.
	*
	* @param local el objeto Local a modificar
	* @return true si el objeto se modificó correctamente, false en caso contrario
	*/
	public boolean modify(Local local) {
		if(check(local.getNombre())) {
			try {
				con = DriverManager.getConnection(url, this.usuario, pass);
				stmt = con.createStatement();
				
				stmt.execute("UPDATE locales SET dir = '" + local.getDireccion() + "', carta = '" + local.getCarta() 
				+ "', phone = '" + local.getTelefono() + "', descripcion = '" + local.getDescripcion() + "' WHERE nombre = '"
				+ local.getNombre() + "';");

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
	* Busca todos los objetos de tipo Local en la base de datos que empiecen por name.
	*
	* @param name el nombre a buscar
	* @return una lista de objetos Local que coinciden con el nombre dado, o null si no se encontró ninguno
	*/
	public List<Local> search(String name) {
		boolean ok= false;
		List<Local> locales = new ArrayList<Local>();
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM locales where nombre LIKE '" + name + "%'");
			
			while(rs.next()) {
				locales.add(new Local(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
				ok=true;
			}
			con.close();
			
			if (ok)
				return locales;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		}
		
		return null;
	}
	
	/**
	* Obtiene una lista de todos los objetos de tipo Local en la base de datos.
	*
	* @param orden el orden en que se deben devolver los objetos (sin uso en esta implementación)
	* @return una lista de todos los objetos Local en la base de datos, o null si no se encontró ninguno
	*/
	public List<Local> getList(int orden) {

		boolean ok = false;
		List<Local> locales = new ArrayList<Local>();
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs;
			switch(orden) {
			case 1:
				rs = stmt.executeQuery("SELECT * FROM locales ORDER BY dir");
				break;
			default:
				rs = stmt.executeQuery("SELECT * FROM locales ORDER BY nombre");
				break;
			}
			while(rs.next()) {
				locales.add(new Local(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
				ok=true;
			}

			con.close();
			if (ok)
				return locales;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		}

		return null;
	}
}
