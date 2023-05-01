package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Cuchara.Controller;
import Ofertas.Oferta;
import Reservas.Reserva;
import Usuarios.Usuario;


public class GUIPerfil extends JPanel{

	private JLabel nombre, usuario, contrasena, email;
	private JPanel namePanel, userPanel, passPanel, emailPanel, middlePanel;
	private JTextField nameText, userText, passText, emailText ;
	private JButton confirmName, confirmUser, confirmPass, confirmEmail;
	private Controller ctrl;
	JTable reservas;
	private int row = 0;
	private int col = 0;

	/**
	* Crea un objeto GUIPerfil.
	* @param ctrl un objeto Controller que contiene información del usuario actual.
	*/

	public GUIPerfil(Controller ctrl) {
		this.ctrl = ctrl;
		initGUI();
	}
	
	/**
	 * Crea un JPanel que contiene los campos de información del usuario y un botón de confirmación de cambios.
 	* @return un JPanel que muestra los campos de información del usuario.
 	*/

	public void initGUI()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel _profilePanel = new JPanel();
		_profilePanel.setLayout(new BoxLayout(_profilePanel, BoxLayout.Y_AXIS));

		JPanel[] panels = new JPanel[6];
		JLabel[] labels = new JLabel[5];
		JTextField[] textFields = new JTextField[5];
		
		labels[0] = new JLabel("Usuario: ");
		Font font = labels[0].getFont();
        labels[0].setFont(new Font("Serif", Font.PLAIN, 28));
        labels[0].setMinimumSize(new Dimension(500, 500));

		labels[1] = new JLabel("Nombre: ");
		font = labels[1].getFont();
        labels[1].setFont(new Font("Serif", Font.PLAIN, 28));
        
		labels[2] = new JLabel("Mail: ");
		font = labels[2].getFont();
        labels[2].setFont(new Font("Serif", Font.PLAIN, 28));
        
		labels[3] = new JLabel("Telefono: ");
		font = labels[3].getFont();
        labels[3].setFont(new Font("Serif", Font.PLAIN, 28));
        
		labels[4] = new JLabel("Contraseña: ");
		font = labels[4].getFont();
        labels[4].setFont(new Font("Serif", Font.PLAIN, 28));
        
		labels[0].setSize(new Dimension(200, 200));
		
		textFields[0] = new JTextField(ctrl.getUser().getID());
		textFields[0].setFont(new Font("Arial", Font.PLAIN, 20));
		textFields[0].setEditable(false);
		
		textFields[1] = new JTextField(ctrl.getUser().getName());
		textFields[1].setFont(new Font("Arial", Font.PLAIN, 20));
		
		textFields[2] = new JTextField(ctrl.getUser().getMail());
		textFields[2].setFont(new Font("Arial", Font.PLAIN, 20));
		
		textFields[3] = new JTextField(Integer.toString(ctrl.getUser().getPhone()));
		textFields[3].setFont(new Font("Arial", Font.PLAIN, 20));
		
		textFields[4] = new JTextField(ctrl.getUser().getPass());
		textFields[4].setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel(new GridLayout(1, 2));
			panels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			panels[i].setMinimumSize(new Dimension(500, 500));
		}
		
		 middlePanel = new JPanel();
		 middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

			for (int i = 0; i < 5; i++) {
			    panels[i].add(labels[i]);
			    panels[i].add(textFields[i]);
			    
			}
			
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				ctrl.modifyUser(new Usuario(textFields[1].getText(), textFields[0].getText(), textFields[3].getText(), Integer.parseInt(textFields[4].getText()), textFields[2].getText()));
				}catch(NumberFormatException f) {
					JOptionPane.showMessageDialog(_profilePanel, "Formato del numero de telefono incorrecto");
				}
			}
			
		});
		panels[5] = new JPanel(new GridLayout(1, 1));
		panels[5].add(confirmButton);

		for (JPanel panel : panels) {
		    middlePanel.add(panel);
		}

		middlePanel.setAlignmentX(CENTER_ALIGNMENT);
		middlePanel.setMaximumSize(new Dimension(500, 1000));

		
		JScrollPane scroll = new JScrollPane(middlePanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		scroll.setAlignmentX(CENTER_ALIGNMENT);
		scroll.setMaximumSize(new Dimension(500, 1000));

		
		_profilePanel.add(scroll);
		
		this.setBackground(new Color(158, 173, 175));
		
		List<Reserva> listReservas = ctrl.searchReserva(ctrl.getUser().getID());
		
		DefaultTableModel dft = new DefaultTableModel(new String[] { "ID", "Local", "Comensales", "Fecha" }, 0);
		
		if (listReservas != null)
			for (Reserva reserva : listReservas) {
				Object[] fila = { reserva.getID(), reserva.getLocal(), reserva.getComensales(), reserva.getFecha() };
				dft.addRow(fila);
			}
		reservas = new JTable(dft);
		JScrollPane pane = new JScrollPane(reservas);
		JButton cancell = new JButton("Cancelar Reserva");
		reservas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = reservas.getSelectedRow();
				col = reservas.getSelectedColumn();
			}
		});
		
		cancell.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.deleteReserva((String)reservas.getValueAt(row, 0));
				DefaultTableModel aux = (DefaultTableModel) reservas.getModel();
				
				for(int i = dft.getRowCount(); i> 0; i--) {
					dft.removeRow(i - 1);
				}
				for (Reserva reserva : ctrl.searchReserva(ctrl.getUser().getID())) {
					Object[] fila = { reserva.getID(), reserva.getLocal(), reserva.getComensales(), reserva.getFecha() };
					aux.addRow(fila);
				}
				reservas.setModel(aux);
				
				dft.fireTableStructureChanged();
				
			}
			
		});
		
		cancell.setMinimumSize(new Dimension(500, 200));
		cancell.setMaximumSize(new Dimension(500, 200));
		
		pane.setMinimumSize(new Dimension(500, 800));
		pane.setMaximumSize(new Dimension(500, 800));
		JPanel r = new JPanel();
		r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
		r.add(pane);
		r.add(cancell);
		
		
		this.add(r);
		this.add(Box.createGlue());
		this.add(_profilePanel);
		this.add(Box.createGlue());
		

	}
}
