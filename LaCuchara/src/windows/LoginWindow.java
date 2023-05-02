package windows;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Cuchara.Controller;
import Exceptions.NullException;
import Usuarios.Usuario;

/**

This class represents the graphical user interface for Login.
*/

public class LoginWindow extends JFrame {

	private Controller controller;
	private JPanel window;
	
	/**
	 * Crea el Frame que mostrara la pestaña de login.
	 */

	public LoginWindow() {
		super("La Cuchara");
		initGUI();
	}
	/**
	 * Crea el panel para mostrar la informacion del local en cuestion.
	 * @param controller el controlador del programa.
	 */


	public LoginWindow(Controller controller) {
		super("La Cuchara");
		this.controller = controller;
		window = new JPanel();
		initGUI();
	}
	/**
	 * Inicializa las guis de inicio de sesion
	 * @param c el controlador del programa.
	 */


	private void initGUI() {
		setTitle("Iniciar sesión");
		setSize(650, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel login = initLogin();
		JPanel register = initRegister();
		window.setLayout(new CardLayout());
		window.add(login, "Login");
		window.add(register, "Register");

		add(window);
		CardLayout cardLayout = (CardLayout) window.getLayout();
		cardLayout.show(window, "Login");
		this.setBackground(new Color(70, 198, 226));

		setVisible(true);
	}
	
	/**
	* inicicializa el registro y comprueba la informacion 
	*/

	private JPanel initRegister() {
		JLabel[] labels = new JLabel[5];
		JTextField[] textFields = new JTextField[5];
		JButton registerButton;

		JPanel mainPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon image = new ImageIcon("src/Cuchara/fondo.png");
				g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		mainPanel.setBackground(new Color(224, 232, 232));

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));


		labels[0] = new JLabel("Usuario:");
		labels[1] = new JLabel("Contraseña:");
		labels[2] = new JLabel("Nombre:");
		labels[3] = new JLabel("Mail:");
		labels[4] = new JLabel("Telefono:");
		registerButton = new JButton("Crear Cuenta");
		registerButton.setBackground(new Color(22, 146, 138));

		JPanel registerPanel = new JPanel(new GridLayout(6, 1));
		registerPanel.setBackground(new Color(224, 232, 232));
		JPanel[] panels = new JPanel[5];
		int i = 0;
		for (JPanel p : panels) {
			p = new JPanel();
			p.setBackground(new Color(224, 232, 232));
			p.setLayout(new GridLayout(1, 2));
			p.add(labels[i]);
			p.setBorder(BorderFactory.createBevelBorder(1));
			textFields[i] = new JTextField();
			p.add(textFields[i]);
			i++;
			registerPanel.add(p);
		}

		registerPanel.add(registerButton);

		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					if(textFields[2].getText().equalsIgnoreCase("") || textFields[3].getText().equalsIgnoreCase("") || textFields[0].getText().equalsIgnoreCase("") || textFields[1].getText().equalsIgnoreCase("")) {
						throw new NullException();
					}
					Usuario u = new Usuario(textFields[0].getText(), textFields[2].getText(), textFields[3].getText(),
							Integer.parseInt(textFields[4].getText()), textFields[1].getText());
					if (controller.createUser(u)) {
						dispose();
						controller.setUsuario(u.getID());
							controller.openApp(u.getID());
					}
					else {
						JOptionPane.showMessageDialog(registerPanel, "Nombre de usuario ya existente");
					}

				} catch (NumberFormatException f) {
					JOptionPane.showMessageDialog(registerPanel, "Formato del numero de telefono incorrecto");
				} catch(NullException h) {
					JOptionPane.showMessageDialog(registerPanel, "Campos vacios");
				}
			};
		});

		JButton volver = new JButton("←");
		volver.setFont(new Font("Serif", Font.BOLD, 10));
		volver.setMaximumSize(new Dimension(50, 20));
		
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) window.getLayout();
				cardLayout.show(window, "Login");
			};
		});
		
		mainPanel.add(volver);
		mainPanel.add(Box.createGlue());
		
		registerPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		registerPanel.setAlignmentX(CENTER_ALIGNMENT);
		registerPanel.setMaximumSize(new Dimension(200, 600));
		
		mainPanel.add(registerPanel);
		mainPanel.add(Box.createGlue());

		

		return mainPanel;
	}

	/**
	* Inicializa el Frame y el Panel para el login
	*/
	
	public JPanel initLogin() {
		JLabel userLabel, passwordLabel;
		JTextField userTextField;
		JPasswordField passwordField;
		JButton loginButton, cancelButton, registerButton;
		JPanel loginPanel;

		JPanel mainPanel = new JPanel(new GridLayout(3, 3)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon image = new ImageIcon("src/Cuchara/fondo.png");
				g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};

		userLabel = new JLabel("Usuario:");
		passwordLabel = new JLabel("Contraseña:");
		userTextField = new JTextField();
		passwordField = new JPasswordField();
		loginButton = new JButton("Ingresar");
		loginButton.setBackground(new Color(68, 184, 28));
		cancelButton = new JButton("Cancelar");
		cancelButton.setBackground(new Color(193, 28, 28));
		registerButton = new JButton("Crear Cuenta");
		registerButton.setBackground(new Color(22, 146, 138));

		loginPanel = new JPanel(new GridLayout(4, 1));
		JPanel usuario = new JPanel(new GridLayout(1, 2));
		JPanel password = new JPanel(new GridLayout(1, 2));
		JPanel inicio = new JPanel(new GridLayout(1, 2));
		loginPanel = new JPanel(new GridLayout(4, 1));
		usuario.add(userLabel);
		usuario.add(userTextField);
		password.add(passwordLabel);
		password.add(passwordField);
		inicio.add(loginButton);
		inicio.add(cancelButton);
		loginPanel.add(usuario);
		loginPanel.add(password);
		loginPanel.add(inicio);
		loginPanel.add(registerButton);
		loginPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		loginButton.addActionListener(new ActionListener() {

			String user = userTextField.getText();
			String password = new String(passwordField.getPassword());

			@Override
			public void actionPerformed(ActionEvent e) {
				String usu = userTextField.getText();
				if (controller.login(usu, new String(passwordField.getPassword()))) {
					controller.setUsuario(usu);
					if(controller.isAdmin())
						controller.openAdmin();
					else
						controller.openApp(usu);
					dispose();
				} else {
					JOptionPane.showMessageDialog(new JPanel(), "Usuario o contraseña incorrectos ");
				}
			}

		});
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) window.getLayout();
				cardLayout.show(window, "Register");
			};
		});
		for (int i = 0; i < 9; i++) {
			if (i == 4)
				mainPanel.add(loginPanel);
			else {

				JPanel aux = new JPanel();
				aux.setOpaque(false);

				mainPanel.add(aux);
			}
		}
		mainPanel.setBackground(new Color(224, 232, 232));
		
		return mainPanel;
	}

}
