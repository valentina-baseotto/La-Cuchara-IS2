package Cuchara;

import windows.LoginWindow;


/**
 * LaCuchara es la clase principal de la aplicaion de gestion de reservas (con posibilidad de aplicar ofertas) de restaurantes que estan
 * inscritos en la base de datos de La Cuchara.
 * Abre la ventana de inicio de sesion.
 *	
 */
public class LaCuchara {


	/**
	 * El método main en el punto de entrada de la aplicacion. Crea un objeto de la clase SAOfertaImpl y un objeto de la clase Controller,
	 * y abre la ventana de inicio de sesion de la aplicacion. 
	 * @param args
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		LoginWindow login = new LoginWindow(controller);
	}
}
