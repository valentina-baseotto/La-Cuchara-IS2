package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Cuchara.Controller;
import Exceptions.NullException;
import Locales.Local;
import Ofertas.Oferta;

import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;

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

/**
 * En esta clase se implementa la interfaz grafica que muestra una lista de locales, este panel solo esta disponible para el Administrador
 * 
 *
 */
public class ListaLocalesAdmin extends JPanel {
	private JTable table;
	private int row = 0;
	private int col = 0;
	private Controller _c;

	/**
	 * Create the panel.
	 */
	public ListaLocalesAdmin(Controller controller) {
		_c = controller;
		List<Local> locales = _c.getListLocales(0);
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
					actualizarTabla(_c.searchLocalLike(searchField.getText()));
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

		JLabel lblNewLabel = new JLabel("Locales");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				f.setMinimumSize(new Dimension(500, 200));
				JPanel mainPanel = new JPanel();
				JLabel[] labels = new JLabel[5];
				JTextField[] textFields = new JTextField[5];
				JButton AddButton;

				labels[0] = new JLabel("Nombre: ");
				labels[1] = new JLabel("Direccion: ");
				labels[2] = new JLabel("Carta: ");
				labels[3] = new JLabel("Telefono: ");
				labels[4] = new JLabel("Descripcion: ");
				AddButton = new JButton("Crear Reserva");
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
					textFields[i] = new JTextField();
					p.add(textFields[i]);
					i++;
					registerPanel.add(p);
				}

				registerPanel.add(AddButton);

				AddButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {

							if (textFields[2].getText().equalsIgnoreCase("")
									|| textFields[0].getText().equalsIgnoreCase("")
									|| textFields[1].getText().equalsIgnoreCase("")) {
								throw new NullException();
							}
							Local u = new Local(textFields[0].getText(), textFields[1].getText(),
									textFields[2].getText(), Integer.parseInt(textFields[3].getText()), textFields[4].getText());
							controller.create(u);
							actualizarTabla();
							f.dispose();
						} catch (NullException h) {
							JOptionPane.showMessageDialog(registerPanel, "Campos vacios");
						}catch(NumberFormatException f) {
							
						}
					};
				});

				registerPanel.setAlignmentY(Component.TOP_ALIGNMENT);
				registerPanel.setAlignmentX(CENTER_ALIGNMENT);
				registerPanel.setMaximumSize(new Dimension(200, 600));

				mainPanel.add(registerPanel);
				mainPanel.add(Box.createGlue());

				f.getContentPane().add(mainPanel);
				f.setVisible(true);
			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Local of = locales.get(row);
				of.setNombre(String.valueOf(table.getValueAt(row, 0)));
				of.setDireccion(String.valueOf(table.getValueAt(row, 1)));
				of.setCarta(String.valueOf(table.getValueAt(row, 2)));
				of.setTelefono(String.valueOf(table.getValueAt(row, 3)));
				of.setDescripcion(String.valueOf(table.getValueAt(row, 4)));
				controller.modifyLocal(of);
				actualizarTabla();
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Local of = new Local(String.valueOf(table.getValueAt(row, 0)), String.valueOf(table.getValueAt(row, 1)), String.valueOf(table.getValueAt(row, 2)), Integer.parseInt(String.valueOf(table.getValueAt(row, 3))),String.valueOf(table.getValueAt(row, 4)));
				controller.delete(of);
				actualizarTabla();
				table.revalidate();
			}
		});

		DefaultTableModel dft = new DefaultTableModel(new String[] { "Nombre", "Direccion", "Carta", "Telefono", "Descripcion" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
                return column != 0;
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
	 * Mantiene actualizada la tabla 
	 */
	void actualizarTabla() {
		List<Local> _Local = _c.getListLocales(0);
		actualizarTabla(_Local);
	}
	
	/**
	 * Actualiza la informacion de la tabla
	 * @param _Local se ponen los datos de esta lista en la tabla
	 */
	void actualizarTabla(List<Local> _Local){
		DefaultTableModel dft = (DefaultTableModel) table.getModel();

		if (_Local != null) {
			int row = 0;
			for (Local local : _Local) {
				Object[] fila = { local.getNombre(), local.getDireccion(), local.getCarta(), String.valueOf(local.getTelefono()), local.getDescripcion()};

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
