package Ofertas.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ofertas.Oferta;

/**
 * Clase DAO (Data Access Object) para manejar la información de las ofertas en
 * la base de datos.
 */
public class DAOOfertaImpl implements IDAOOferta {

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
	 * Una conexión a la base de datos
	 */
	private Connection con;
	/**
	 * Un objeto de declaracion SQL utilizada para ejecutar consultas en la base de datos. 
	 */
	private Statement stmt;

	/**
	 * Constructor por defecto que se encarga de inicializar la conexión con la base
	 * de datos.
	 * 
	 * 
	 */
	public DAOOfertaImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		}
	}

	/**
	 * Verifica si una oferta con el id proporcionado ya existe en la base de datos.
	 * 
	 * @param id el id de la oferta a verificar
	 * @return true si la oferta existe en la base de datos, false en caso contrario
	 */
	public boolean check(String id) {
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ofertas where id = '" + id + "'");

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
	 * Consulta una oferta con el id proporcionado en la base de datos.
	 * 
	 * @param id el id de la oferta a consultar
	 * @return la oferta consultada, null si no se encuentra la oferta
	 */
	public Oferta consult(String id) {
		Oferta oferta = null;
		if (check(id)) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM ofertas where id = '" + id + "'");

				if (rs.next())
					oferta = new Oferta(rs.getString(1), rs.getString(2), rs.getString(3));

				con.close();
				return oferta;

			} catch (SQLException e) {
				System.out.println("SQLException : " + e.getMessage());
				System.out.println("SQLState : " + e.getSQLState());
				System.out.println("VendorError : " + e.getErrorCode());
			}
		}

		return null;
	}

	/**
	 * Crea una nueva oferta en la base de datos.
	 * 
	 * @param Oferta la oferta a crear
	 * @return true si la oferta se crea correctamente, false si ya existe una
	 *         oferta con el mismo id
	 */
	public boolean create(Oferta Oferta) {
		if (!check(Oferta.getID())) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				String id = Oferta.getID();
				String name = Oferta.getNombre();
				String desc = Oferta.getDescripcion();
				String nuevo;
				nuevo = "('" + id + "', '" + name + "', '" + desc + "');";
				stmt.execute("INSERT INTO ofertas (id, nombrelocal, descripcion) VALUES " + nuevo);

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
	 * 
	 * Elimina una oferta en la base de datos.
	 * 
	 * @param id El identificador de la oferta a eliminar.
	 * @return true si la oferta se eliminó correctamente, false si no se pudo
	 *         eliminar o no se encontró.
	 */
	public boolean delete(String id) {
		if (check(id)) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				stmt.execute("DELETE FROM ofertas where id = '" + id + "'");

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
	 * 
	 * Modifica una oferta en la base de datos.
	 * 
	 * @param oferta La oferta a modificar.
	 * 
	 * @return true si la oferta se modificó correctamente, false si no se pudo
	 *         modificar.
	 */
	public boolean modify(Oferta oferta) {
		if(check(oferta.getID())) {
			try {
				con = DriverManager.getConnection(url, this.usuario, pass);
				stmt = con.createStatement();
				
				stmt.execute("UPDATE ofertas SET descripcion = '" + oferta.getDescripcion() + "', nombrelocal = '" 
   				+ oferta.getNombre() + "' WHERE id = '" + oferta.getID() + "';");

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
	 * 
	 * Obtiene una lista de todas las ofertas en la base de datos.
	 * 
	 * @param orden El orden en el que se ordenarán las ofertas (1 = ordenar por ID, 2 = ordenar por local).
	 * 
	 * @return Una lista de todas las ofertas en la base de datos, ordenadas según
	 *         el orden especificado.
	 */
	public List<Oferta> getList(int orden) {
		boolean ok = false;
		List<Oferta> ofertas = new ArrayList<Oferta>();
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			String query = "SELECT * FROM ofertas ORDER BY ";
			ResultSet rs;

			switch(orden){
				default: 
					rs = stmt.executeQuery(query + "id");
					break;
				case 2:
					rs = stmt.executeQuery(query + "nombrelocal");
					break;
			}

			while (rs.next()) {
				ofertas.add(new Oferta(rs.getString(1), rs.getString(2), rs.getString(3)));
				ok = true;
			}

			con.close();
			if (ok)
				return ofertas;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		}

		return null;
	}

	/**
	 * 
	 * Busca ofertas en la base de datos que corresponden a un local específico.
	 * 
	 * @param local El local al que pertenecen las ofertas buscadas.
	 * 
	 * @return Una lista de ofertas que corresponden al local especificado.
	 */
	@Override
	public List<Oferta> searchLocal(String local) {
		boolean ok = false;
		List<Oferta> ofertas = new ArrayList<Oferta>();
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ofertas where local = '" + local + "'");

			while (rs.next()) {
				ofertas.add(new Oferta(rs.getString(1), rs.getString(2), rs.getString(3)));
				ok = true;
			}

			con.close();
			if (ok)
				return ofertas;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		}

		return null;
	}
	/**
	 * 
	 * Busca ofertas en la base de datos cuyo local empiece por localStrt.
	 *
	 * @param localStrt string que sirve para hacer la busqueda.
	 * 
	 * @return Una lista de ofertas que empiecen por localStrt.
	 */
	@Override
	public List<Oferta> searchLocalLike(String localStrt){
		boolean ok = false;
		List<Oferta> ofertas = new ArrayList<Oferta>();
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ofertas where nombrelocal LIKE '" + localStrt + "%'");

			while (rs.next()) {
				ofertas.add(new Oferta(rs.getString(1), rs.getString(2), rs.getString(3)));
				ok = true;
			}

			con.close();
			if (ok)
				return ofertas;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		}

		return null;
	}
}
