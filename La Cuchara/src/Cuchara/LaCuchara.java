package Cuchara;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import windows.LoginWindow;

public class LaCuchara {
	
	public final static String in_out = "src/Cuchara/database.json";
	
	
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream(in_out);
			Controller controller = new Controller();
			controller.loadData(in);
			LoginWindow login = new LoginWindow(controller);
			//GUIPerfil perfil = new GUIPerfil(new Usuario("admin","admin", "admin", 123456789, "1234"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
