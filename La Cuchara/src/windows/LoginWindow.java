package windows;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BorderFactory;
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
import Usuarios.Usuario;
import Utils.RoundedButton;

public class LoginWindow extends JFrame {

	private Controller controller;
	private JPanel window;

	public LoginWindow() {
		super("La Cuchara");
		initGUI();
	}

	public LoginWindow(Controller controller) {
		super("La Cuchara");
		this.controller = controller;
		window = new JPanel();
		initGUI();
	}

	private void initGUI() {
		// Configuración de la ventana
		setTitle("Iniciar sesión");
		setSize(650, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel login = initLogin();
		JPanel register = initRegister();
		window.setLayout(new CardLayout());
		window.add(login, "Login");
		window.add(register, "Register");

		// Agregar panel a la ventana
		add(window);
		CardLayout cardLayout = (CardLayout) window.getLayout();
		cardLayout.show(window, "Login");
		this.setBackground(new Color(70, 198, 226));

		// Hacer visible la ventana
		setVisible(true);
	}

	private JPanel initRegister() {
		JLabel[] labels = new JLabel[5];
		JTextField[] textFields = new JTextField[5];
		RoundedButton registerButton;

		JPanel mainPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon image = new ImageIcon("src/Cuchara/fondo.png"); // Ruta de la imagen
				g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		// Creación de componentes

		labels[0] = new JLabel("Usuario:");
		labels[1] = new JLabel("Contraseña:");
		labels[2] = new JLabel("Nombre:");
		labels[3] = new JLabel("Mail:");
		labels[4] = new JLabel("Telefono:");
		registerButton = new RoundedButton("Crear Cuenta", new Color(22, 146, 138));

		// Añadir componentes al panel
		JPanel registerPanel = new JPanel(new GridLayout(6, 1));
		JPanel[] panels = new JPanel[5];
		int i = 0;
		for (JPanel p : panels) {
			p = new JPanel();
			p.setLayout(new GridLayout(1, 2));
			p.add(labels[i]);
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
					Usuario u = new Usuario(textFields[2].getText(), textFields[3].getText(), textFields[0].getText(),
							Integer.parseInt(textFields[4].getText()), textFields[1].getText());

					if (controller.addUser(u)) {
						dispose();
						controller.openApp(u.getID());
					}

				} catch (NumberFormatException f) {
					JOptionPane.showMessageDialog(registerPanel, "Formato del numero de telefono incorrecto");
				}
			};
		});

		registerPanel.setAlignmentX(CENTER_ALIGNMENT);
		registerPanel.setMaximumSize(new Dimension(200, 600));
		
		mainPanel.add(registerPanel);

		

		return mainPanel;
	}

	// INICIA EL LOGIN DE LA APLICACION
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
				ImageIcon image = new ImageIcon("src/Cuchara/fondo.png"); // Ruta de la imagen
				g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		// Creación de componentes
		userLabel = new JLabel("Usuario:");
		passwordLabel = new JLabel("Contraseña:");
		userTextField = new JTextField();
		passwordField = new JPasswordField();
		loginButton = new RoundedButton("Ingresar", Color.GREEN);
		cancelButton = new RoundedButton("Cancelar", Color.RED);
		registerButton = new RoundedButton("Crear Cuenta", new Color(22, 146, 138));

		// Añadir componentes al panel
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

		// Agregar eventos a los botones
		loginButton.addActionListener(new ActionListener() {

			String user = userTextField.getText();
			String password = new String(passwordField.getPassword());

			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.login(userTextField.getText(), new String(passwordField.getPassword()))) {
					controller.openApp(userTextField.getText());
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
		return mainPanel;
	}

}
