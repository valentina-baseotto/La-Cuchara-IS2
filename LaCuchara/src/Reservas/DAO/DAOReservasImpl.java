package Reservas.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Reservas.Reserva;

/**
 * La clase DAOReservasImpl implementa la interfaz IDAOReserva y define los
 * métodos necesarios para la gestión de reservas en una base de datos.
 * 
 * La clase utiliza JDBC para interactuar con la base de datos MySQL
 * 'lacuchara'.
 */
public class DAOReservasImpl implements IDAOReserva {

	private Connection con;
	private Statement stmt;
	private String url = "jdbc:mySQL://localhost:3306/lacuchara";
	private String usuario = "LaCuchara";
	private String pass = "LaCuchara";

	/**
	 * Constructor por defecto de la clase DAOReservasImpl que establece la conexión
	 * con la base de datos.
	 * 
	 * @throws ClassNotFoundException si no se encuentra el controlador de la base
	 *                                de datos.
	 * @throws SQLException           si hay un error al establecer la conexión con
	 *                                la base de datos.
	 */
	public DAOReservasImpl() {
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
	 * Comprueba si una reserva con el id especificado existe en la base de datos.
	 * 
	 * @param id el id de la reserva a buscar.
	 * @return true si la reserva existe en la base de datos, false en caso
	 *         contrario.
	 */
	public boolean check(String id) {
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reservas where id = '" + id + "'");

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
	 * Modifica la reserva con el id especificado en la base de datos.
	 * 
	 * @param id el id de la reserva a modificar.
	 * @return create(reserva) si la reserva devuelve true en el delete
	 * @return false ya que el método no está implementado.
	 */
	public boolean modify(Reserva reserva) {
		if(check(reserva.getID())) {
			try {
				con = DriverManager.getConnection(url, this.usuario, pass);
				stmt = con.createStatement();
				
				stmt.execute("UPDATE reservas SET local = '" + reserva.getLocal() + "', comensales = '" + reserva.getComensales()
				+ "' WHERE id = '" +reserva.getID() +"';");

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
	 * Consulta la reserva con el id especificado en la base de datos.
	 * 
	 * @param id el id de la reserva a consultar.
	 * @return reserva si el id de la reserva se encuentra en la base de datos
	 * @return null en el caso contrario.
	 */
	public Reserva consult(String id) {
		Reserva reserva = null;
		if (check(id)) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM reservas where id = '" + id + "'");

				if (rs.next())
					reserva = new Reserva(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5).toString());
				con.close();
				return reserva;

			} catch (SQLException e) {
				System.out.println("SQLException : " + e.getMessage());
				System.out.println("SQLState : " + e.getSQLState());
				System.out.println("VendorError : " + e.getErrorCode());
			}
		}

		return null;
	}

	/**
	 * Elimina la reserva con el id especificado de la base de datos.
	 * 
	 * @param id el id de la reserva a eliminar.
	 * elimina el valor de la base de datos 
	 */
	public boolean delete(String id) {
		if (check(id)) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				stmt.execute("DELETE FROM reservas where id = '" + id + "'");
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
	 * Crea una nueva reserva en la base de datos.
	 * 
	 * @param r la reserva a crear.
	 * @return false ya que el método no está implementado.
	 */
	public boolean create(Reserva r) {
		if (!check(r.getID())) {
			try {
				con = DriverManager.getConnection(url, usuario, pass);
				stmt = con.createStatement();
				String id = r.getID();
				String local = r.getLocal();
				String usu = r.getUsuario();
				int comensales = r.getComensales();
				String fecha = r.getFecha();
				String nuevo = "('" + id + "', '" + local + "', '" + usu + "', '" + comensales + "', '" + fecha + "')";
				stmt.execute("INSERT INTO reservas (id, local, usuario, comensales, fecha) VALUES " + nuevo);
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
	 * Busca reservas en la base de datos según el criterio especificado
	 * 
	 * @param r la reserva a buscar.
	 * @return false ya que el método no está implementado.
	 */

	public List<Reserva> search(String r) {
		boolean ok= false;
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reservas where usuario LIKE '" + r + "%'");
			
			while(rs.next()) {
				Date fecha = rs.getDate(5);
				reservas.add(new Reserva(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), fecha.toString()));
				ok=true;
			}
			
			con.close();
			if (ok)
				return reservas;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		} 

		return null;
	}

	/**
	 * obtiene la lista de reservas en la base de datos según el criterio
	 * especificado
	 * 
	 * @return la lista de reservas.
	 */

	public List<Reserva> getList(int orden) {
		List<Reserva> lista = new ArrayList<Reserva>();
		boolean ok = false;
		try {
			con = DriverManager.getConnection(url, usuario, pass);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reservas");
			
			while(rs.next()) {
				lista.add(new Reserva(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5).toString()));
				ok=true;
			}

			con.close();
			if (ok)
				return lista;

		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
			System.out.println("VendorError : " + e.getErrorCode());
		}

		return null;
	}

}
