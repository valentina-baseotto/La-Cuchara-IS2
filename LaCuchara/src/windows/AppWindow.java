package windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Cuchara.Controller;

/**
 * Esta clase representa la interfaz grafica de la aplicacion principal
 */

public class AppWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * controller de Controller
	 */
	Controller controller;
	/**
	 * rightPanelProfile de JPanel
	 */
	JPanel rightPanelProfile;
	/**
	 * dropdown de JComboBox
	 */
	JComboBox<String> dropdown;
	/**
	 * ofertasShown tipo boolean
	 */
	private boolean ofertasShown;
	/**
	 * borrado tipo boolean
	 */
	private boolean borrado;

	/**
	 * 
	 * Constructor una nueva AppWindow object.
	 * 
	 * @param controller El Controller se usa para manejar la informacion entre la BBDD
	 *             y los Inputs
	 */

	public AppWindow(Controller controller) {
		super("La Cuchara");
		ofertasShown = true;
		borrado = false;
		this.controller = controller;
		initGUI();
	}

	/**
	 * inicializa la gui creando todo lo necesario.
	 */

	private void initGUI() {


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel rightPanel;
		rightPanel = new JPanel(new CardLayout());
		JPanel rightPanelOfertas;
		JPanel rightPanelLocales;
		rightPanelProfile = new GUIPerfil(controller);
		JPanel leftPanel, upperPanel;
		JSplitPane updownSplit;
		JSplitPane splitPane;
		JPanel usuarios;

		setTitle("LocalesOfertas");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		rightPanelOfertas = new JPanel();
		rightPanelOfertas.setBackground(new Color(158, 173, 175));

		rightPanelLocales = new JPanel();
		rightPanelLocales.setBackground(new Color(158, 173, 175));

		JPanel ofertasPanel = new ListaOfertasPanel(controller, controller.getListOfertas(0));
		JPanel localesPanel = new ListaLocalesPanel(controller);

		rightPanelOfertas.add(ofertasPanel);
		rightPanelLocales.add(localesPanel);

		rightPanel.add(rightPanelOfertas, "rightPanelOfertas");
		rightPanel.add(rightPanelLocales, "rightPanelLocales");
		rightPanel.add(rightPanelProfile, "rightPanelProfile");

		upperPanel = new JPanel(new BorderLayout());
		JButton switchButton = new JButton("Locales");
		JButton usuarioButton = new JButton("Usuario");

		JPanel logo = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon image = new ImageIcon("src/Cuchara/logo.png");
				g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		logo.setBackground(new Color(18, 79, 85));

		upperPanel.add(logo, BorderLayout.CENTER);
		upperPanel.add(switchButton, BorderLayout.WEST);
		upperPanel.add(usuarioButton, BorderLayout.EAST);
		upperPanel.setBackground(new Color(18, 79, 85));
		switchButton.setFont(new Font("Serif", Font.BOLD, 20));

		leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		JLabel ordenarLabel = new JLabel("Ordenar");
		ordenarLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		ordenarLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		leftPanel.add(ordenarLabel);

		String[] items = { "nombre", "direccion" };

		dropdown = new JComboBox<>(items);

		dropdown.setSelectedIndex(0);
		dropdown.setMaximumSize(new Dimension(150, 30));
		dropdown.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		dropdown.addItemListener((e) -> {
			if (ofertasShown) {
				rightPanelOfertas.removeAll();
				rightPanelOfertas.revalidate();
				rightPanelOfertas.repaint();
				rightPanelOfertas
						.add(new ListaOfertasPanel(controller, controller.getListOfertas(dropdown.getSelectedIndex())));
			} else {
				rightPanelLocales.removeAll();
				rightPanelLocales.revalidate();
				rightPanelLocales.repaint();
				rightPanelLocales.add(new ListaLocalesPanel(controller));
			}
		});

		leftPanel.add(dropdown);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		splitPane.setOneTouchExpandable(false);
		splitPane.setDividerLocation(200);
		splitPane.setEnabled(false);

		updownSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upperPanel, splitPane);
		updownSplit.setDividerLocation(70);
		updownSplit.setBorder(BorderFactory.createEmptyBorder());
		updownSplit.setEnabled(false);

		add(updownSplit, BorderLayout.CENTER);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				leftPanel.setVisible(true);
				splitPane.setDividerLocation(200);
				switchButton.setFont(new Font("Serif", Font.BOLD, 20));
				borrado = false;

				if(switchButton.getText().equals("")){
					usuarioButton.setText("Usuario");
				}

				if (ofertasShown) {
					switchButton.setText("Ofertas");
					((CardLayout) rightPanel.getLayout()).show(rightPanel, "rightPanelLocales");
					ofertasShown = false;
				} else {
					switchButton.setText("Locales");
					((CardLayout) rightPanel.getLayout()).show(rightPanel, "rightPanelOfertas");
					ofertasShown = true;
				}
			}
		});

		usuarioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				rightPanelProfile = new GUIPerfil(controller);
				leftPanel.setVisible(false);
				((CardLayout) rightPanel.getLayout()).show(rightPanel, "rightPanelProfile");
				switchButton.setText("");
				usuarioButton.setText("Borrar");
				switchButton.setFont(new Font("Serif", Font.BOLD, 40));
				if (borrado) {
					int confirm = JOptionPane.showConfirmDialog(null, "Estas seguro que desea eliminar su cuenta?",
							"ELIMINAR CUENTA", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						controller.delete(controller.getUser());
						dispose();
						usuarioButton.setText("Usuario");
					} else if (confirm == JOptionPane.NO_OPTION) {
						// lo que tenga que hacer con el no
					}
				}
				borrado = true;
				ofertasShown = !ofertasShown;

			}
		});

		setVisible(true);
	}
}
