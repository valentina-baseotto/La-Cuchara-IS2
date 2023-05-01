package windows;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Cuchara.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.Dimension;

/**
 * 
 * Esta clase implementa el Panel que le sale al Usuario tipo Administrador una vez que inicia sesion
 *
 */
public class AdminPanel extends JPanel {

	Controller ctrl;
	JPanel intercambio;
	/**
	 * Create the panel.
	 * @param contoller El Controller se usa para manejar la informacion entre la BBDD
	 *             y los Inputs
	 */
	public AdminPanel(Controller controller) {
		ctrl = controller;
		intercambio = new JPanel();
		JFrame Fr = new JFrame();
		JButton btnNewButton = new JButton("Locales");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) intercambio.getLayout()).show(intercambio, "Locales");
			}
		});
		
		JButton btnNewButton_1 = new JButton("Usuarios");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) intercambio.getLayout()).show(intercambio, "Usuarios");
			}
		});
		
		JButton btnNewButton_2 = new JButton("Reservas");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) intercambio.getLayout()).show(intercambio, "Reservas");
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Ofertas");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) intercambio.getLayout()).show(intercambio, "Ofertas");
				
			}
		});
		JPanel paneeeeeeel = new JPanel(new GridLayout()) {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon image = new ImageIcon("src/Cuchara/fondo.png");
				g.drawImage(image.getImage(), 0, 0, 300, 200, null);
			}
		};
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
							.addGap(3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(paneeeeeeel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
							.addGap(4)))
					.addGap(21)
					.addComponent(intercambio, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(211)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addComponent(paneeeeeeel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(intercambio, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)))
					.addContainerGap())
		);
		intercambio.setLayout(new CardLayout());
		intercambio.add(new ListaOfertasAdmin(controller), "Ofertas");
		intercambio.add(new ListaLocalesAdmin(controller), "Locales");
		intercambio.add(new ListaReservasAdmin(controller), "Reservas");
		intercambio.add(new ListaUsuariosAdmin(controller), "Usuarios");
		
		
		GroupLayout gl_paneeeeeeel = new GroupLayout(paneeeeeeel);
		gl_paneeeeeeel.setHorizontalGroup(
			gl_paneeeeeeel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 390, Short.MAX_VALUE)
		);
		gl_paneeeeeeel.setVerticalGroup(
			gl_paneeeeeeel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 247, Short.MAX_VALUE)
		);
		paneeeeeeel.setLayout(gl_paneeeeeeel);
		setLayout(groupLayout);
		
		Fr.getContentPane().add(this);
		Fr.setMinimumSize(new Dimension(1250, 700));
		Fr.setMaximumSize(new Dimension(1250, 700));
		Fr.setVisible(true);
		Fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
