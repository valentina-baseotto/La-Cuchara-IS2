package Cuchara;

import windows.LoginWindow;

/**

LaCuchara es la clase principal de la aplicación de gestión de ofertas de restaurantes La Cuchara.

Esta clase instancia un objeto de la clase SAOfertaImpl y un objeto de la clase Controller,

y abre la ventana de inicio de sesión de la aplicación.
*/
public class LaCuchara {

/**
El método main es el punto de entrada de la aplicación.
Crea un objeto de la clase SAOfertaImpl y un objeto de la clase Controller,
y abre la ventana de inicio de sesión de la aplicación.
@param args Los argumentos de la línea de comandos (no se usan en esta aplicación).
*/

	public static void main(String[] args) {
		Controller controller = new Controller();
		LoginWindow login = new LoginWindow(controller);
	}
}
