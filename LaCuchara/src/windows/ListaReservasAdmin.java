package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Cuchara.Controller;
import Exceptions.NullException;
import Ofertas.Oferta;

import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import Reservas.Reserva;

/**
 * Esta clase genera una interfaz gráfica para mostrar la Lista de Reservas
 *
 */
public class ListaReservasAdmin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * table de JTable
	 */
	private JTable table;
	/**
	 * row tipo integer
	 */
	private int row = 0;
	/**
	 * col tipo integer
	 */
	private int col = 0;
	/**
	 * _c de Controller
	 */
	private Controller _c;

	
	/**
	 * Constructor de la clase. Crea el panel, nuestra una lista de reservas.
	 * @param controller
	 */
	public ListaReservasAdmin(Controller controller) {
		_c = controller;
		List<Reserva> ofertas = _c.getListReservas(0);
		setBackground(new Color(158, 173, 175));

		JPanel panelsito = new JPanel();
		JTextField searchField = new JTextField();
		searchField.setLayout(new BorderLayout());

		ImageIcon icon = new ImageIcon("src/Cuchara/search.png");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		JButton searchIconLabel = new JButton(scaledIcon);
		searchIconLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					//TODO usar serchField
					actualizarTabla(_c.searchReservaLike(searchField.getText()));
			}
	    	
	    });
		searchIconLabel.setMinimumSize(new Dimension(20, 20));
		searchIconLabel.setMaximumSize(new Dimension(20, 20));
		searchIconLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		GroupLayout gl_panelsito = new GroupLayout(panelsito);
		gl_panelsito.setHorizontalGroup(gl_panelsito.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelsito.createSequentialGroup()
						.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(searchIconLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGap(585)));
		gl_panelsito.setVerticalGroup(gl_panelsito.createParallelGroup(Alignment.LEADING).addGroup(gl_panelsito
				.createSequentialGroup()
				.addGroup(gl_panelsito.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(searchIconLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(searchField, Alignment.LEADING))
				.addContainerGap(641, Short.MAX_VALUE)));
		panelsito.setLayout(gl_panelsito);
		this.add(panelsito);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("Reservas");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				f.setMinimumSize(new Dimension(500, 300));
				JPanel mainPanel = new JPanel();
				JLabel[] labels = new JLabel[5];
				JTextField[] textFields = new JTextField[5];
				JButton AddButton;
				JComboBox<String> comboBox, comboBox_1, comboBox_2;

				comboBox = new JComboBox<>();
				comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2023", "2024", "2025", "2026"}));
					
				comboBox_2 = new JComboBox<>();
				comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
						
				comboBox_1 = new JComboBox<>();
				comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

				labels[0] = new JLabel("Comensales: ");
				labels[1] = new JLabel("ID: ");
				labels[2] = new JLabel("Local: ");
				labels[4] = new JLabel("Fecha: ");
				labels[3] = new JLabel("Usuario: ");
				AddButton = new JButton("Crear Reserva: ");
				AddButton.setBackground(new Color(22, 146, 138));

				JPanel registerPanel = new JPanel(new GridLayout(4, 1));
				registerPanel.setBackground(new Color(224, 232, 232));
				JPanel[] panels = new JPanel[5];
				int i = 0;
				for (JPanel p : panels) {
					p = new JPanel();
					p.setBackground(new Color(224, 232, 232));
					p.setLayout(new GridLayout(1, 6));
					p.add(labels[i]);
					p.setBorder(BorderFactory.createBevelBorder(1));
					if(i != 4){
						textFields[i] = new JTextField();
						p.add(textFields[i]);
						i++;
					}
					else {
						JPanel y = new JPanel();
						y.setLayout(new BoxLayout(y, BoxLayout.X_AXIS));
						y.add(comboBox_1);
						y.add(comboBox_2);
						y.add(comboBox);
						
						p.add(y);
					}
					registerPanel.add(p);
				}

				registerPanel.add(AddButton);

				AddButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {

							if (textFields[2].getText().equalsIgnoreCase("")
									|| textFields[0].getText().equalsIgnoreCase("")
									|| textFields[1].getText().equalsIgnoreCase("")
									|| textFields[3].getText().equalsIgnoreCase("")) {
								throw new NullException();
							}
								//"Comensales", "Fecha", "Local" ,"Usuario",  "Id"
							try{
							Reserva u = new Reserva(textFields[1].getText(), textFields[2].getText(), textFields[3].getText(),
							Integer.parseInt(textFields[0].getText()), comboBox.getSelectedItem() + "-" + comboBox_2.getSelectedItem() + "-" + comboBox_1.getSelectedItem());
							if (controller.createreser(u)) {
								JOptionPane.showMessageDialog(registerPanel, "Nuevo reserva creada con exito");
								f.dispose();
								actualizarTabla();
							} else {
								JOptionPane.showMessageDialog(registerPanel, "Nombre de reserva ya existente");
							}
							}
							catch(NumberFormatException exc){
								JOptionPane.showMessageDialog(registerPanel, "Los comensales deben ser un entero");
							}
							

						} catch (NullException h) {
							JOptionPane.showMessageDialog(registerPanel, "Campos vacios");
						}
					};
				});

				registerPanel.setAlignmentY(Component.TOP_ALIGNMENT);
				registerPanel.setAlignmentX(CENTER_ALIGNMENT);
				registerPanel.setMaximumSize(new Dimension(200, 600));

				mainPanel.add(registerPanel);
				mainPanel.add(Box.createGlue());

				f.getContentPane().add(mainPanel);
				f.setMaximumSize(new Dimension(600,200));
				f.setMaximumSize(new Dimension(600, 200));
				f.setVisible(true);

			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reserva of;
				try{
				of = new Reserva(String.valueOf(table.getValueAt(row, 4)), String.valueOf(table.getValueAt(row, 2)), String.valueOf(table.getValueAt(row, 3)),
				Integer.parseInt(String.valueOf(table.getValueAt(row, 0))), String.valueOf(table.getValueAt(row, 1)));

				controller.modifyReserva(of);
				actualizarTabla();
				}
				catch(NumberFormatException exc){
					JOptionPane.showMessageDialog(new JPanel(), "Los comensales deben ser un numero");
				}
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reserva of = new Reserva(String.valueOf(table.getValueAt(row, 4)), String.valueOf(table.getValueAt(row, 2)), String.valueOf(table.getValueAt(row, 3)),
				Integer.parseInt(String.valueOf(table.getValueAt(row, 0))), String.valueOf(table.getValueAt(row, 1)));
				controller.delete(of);
				actualizarTabla();
				table.revalidate();
			}
		});

		DefaultTableModel dft = new DefaultTableModel(new String[] { "Comensales", "Fecha", "Local" ,"Usuario",  "Id" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
                return column != 4;
            }
		};
		table = new JTable(dft);
		table.setBackground(new Color(255, 255, 255));
		table.setShowVerticalLines(false);
		table.setFont(new Font("Serif", Font.PLAIN, 15));
		actualizarTabla();

		// Agrega un oyente de eventos para detectar cuando se hace clic en una celda
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				col = table.getSelectedColumn();
			}
		});

		scrollPane.setViewportView(table);
		this.add(scrollPane);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelsito, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(142)
								.addComponent(btnAadir, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 216,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(10, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(20).addComponent(panelsito,
								GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE).addGap(10)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAadir, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))));
		setLayout(groupLayout);

	}

	/**
	 * Actualiza la tabla.
	 */
	void actualizarTabla() {
		List<Reserva> _ofertas = _c.getListReservas(0);
		actualizarTabla(_ofertas);
	}

	/**
	 * Actualiza la tabla con los datos.
	 * @param _ofertas lista de reservas a mostrar
	 */
	void actualizarTabla(List<Reserva> _ofertas){
		DefaultTableModel dft = (DefaultTableModel) table.getModel();

		if (_ofertas != null) {
			int row = 0;
			for (Reserva oferta : _ofertas) {
				//"Comensales", "Fecha", "Local" ,"Usuario",  "Id"
				Object[] fila = {String.valueOf(oferta.getComensales()) , oferta.getFecha(), oferta.getLocal(), oferta.getUsuario(),oferta.getID()};

				if (dft.getRowCount() > row)
					for (int i = 0; i < fila.length; i++)
						dft.setValueAt(fila[i], row, i);
				else
					dft.addRow(fila);
				row++;
			}
			dft.setRowCount(row);
		}
		dft.fireTableDataChanged();
	}
}
