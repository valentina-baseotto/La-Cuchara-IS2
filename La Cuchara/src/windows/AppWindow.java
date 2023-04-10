package windows;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Cuchara.Controller;

public class AppWindow extends JFrame{

	Controller controller;
	GUIPerfil profile;
	
	public AppWindow() {
		super("La Cuchara");
	}
	
	public AppWindow(Controller controller) {
		super("La Cuchara");
		this.controller = controller;
		profile = new GUIPerfil();
		initGUI();
	}
	
	public void initGUI() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
               	controller.save();
            }
		});
		
		JPanel profilePanel = profile.profilePanel(controller.getUser());
		
		add(profilePanel);
		this.setVisible(true);
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
