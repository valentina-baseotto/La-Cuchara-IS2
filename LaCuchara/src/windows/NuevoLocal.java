package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;

/**
 * 
 * Esta clase implementa la interfaz gráfica para crear un local nuevo 
 *
 */
public class NuevoLocal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextPane txtpnDescripcion;
	private JTextPane textPane_6;
	private JTextPane txtpnUbicacion;
	private JTextPane txtpnTelef;
	
	/**
	 * Cnostructor de NuevoLocal
	 */
	public NuevoLocal(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.PLAIN, 16));
		textPane.setText("Nombre");	
		textPane.setBackground(null);
		textPane.setEditable(false);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Descripcion");
		textPane_1.setFont(new Font("Arial", Font.PLAIN, 16));
		textPane_1.setEditable(false);
		textPane_1.setBackground((Color) null);
		
		txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setText("Descripcion");
		txtpnDescripcion.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnDescripcion.setEditable(false);
		txtpnDescripcion.setBackground((Color) null);
		
		textPane_6 = new JTextPane();
		textPane_6.setText("Nombre");
		textPane_6.setFont(new Font("Arial", Font.PLAIN, 16));
		textPane_6.setEditable(false);
		textPane_6.setBackground((Color) null);
		
		txtpnUbicacion = new JTextPane();
		txtpnUbicacion.setText("Cuenta");
		txtpnUbicacion.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnUbicacion.setEditable(false);
		txtpnUbicacion.setBackground((Color) null);
		
		txtpnTelef = new JTextPane();
		txtpnTelef.setText("Telef");
		txtpnTelef.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnTelef.setEditable(false);
		txtpnTelef.setBackground((Color) null);
		
		JButton btnNewButton = new JButton("Crear Local");
		
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(109)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtpnUbicacion, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtpnDescripcion, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
											.addComponent(textPane_6, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtpnTelef, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(135)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane_6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnDescripcion, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnUbicacion, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnTelef, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		panel.setLayout(gl_panel);
	}
}