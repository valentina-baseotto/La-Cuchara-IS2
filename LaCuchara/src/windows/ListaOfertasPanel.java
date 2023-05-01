package windows;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import Cuchara.Controller;
import Exceptions.NullException;
import Ofertas.Oferta;

import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;



/**

Clase que define un panel que muestra una lista de locales y permite abrir la ventana de un local seleccionado.
*/

public class ListaOfertasPanel extends JPanel {
	private JTable table;
	private int row = 0;
	private int col = 0;
	Controller _c;

	/**
	Crea un panel con una tabla que muestra la lista de ofertas recibida como parámetro y un botón para abrir la ventana de una oferta seleccionado.
	@param c el controlador del programa.
	@param ofertas la lista de ofertas a mostrar en la tabla.
	*/
	public ListaOfertasPanel(Controller c, List<Oferta> ofertas) {
		setBackground(new Color(158, 173, 175));
		List<Oferta> _ofertas = ofertas;
		_c = c;

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("OFERTAS");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 478,
										Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
						.addContainerGap()));

		DefaultTableModel dft = new DefaultTableModel(new String[] { "Nombre", "Descripción", "id" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		if (_ofertas != null)
			for (Oferta oferta : _ofertas) {
				Object[] fila = { oferta.getNombre(), oferta.getDescripcion(), String.valueOf(oferta.getID()) };
				dft.addRow(fila);
			}
		table = new JTable(dft);
		table.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 18));
		table.setBackground(new Color(255, 255, 255));
		table.setShowVerticalLines(false);
		table.setFont(new Font("Serif", Font.PLAIN, 18));

		// Agrega un oyente de eventos para detectar cuando se hace clic en una celda
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				col = table.getSelectedColumn();
			}
		});


		JButton NewOffer = new JButton("Crear");
		this.add(NewOffer);
		NewOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JFrame f = new JFrame();
					JPanel mainPanel = new JPanel();
					JLabel[] labels = new JLabel[3];
					JTextField[] textFields = new JTextField[3];
					JButton AddButton;

					labels[0] = new JLabel("Descripcion:");
					labels[1] = new JLabel("Nombre Local:");
					labels[2] = new JLabel("ID:");
					AddButton = new JButton("Crear Oferta");
					AddButton.setBackground(new Color(22, 146, 138));

					JPanel registerPanel = new JPanel(new GridLayout(4, 1));
					registerPanel.setBackground(new Color(224, 232, 232));
					JPanel[] panels = new JPanel[3];
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

					registerPanel.add(AddButton);

					AddButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {

								if(textFields[2].getText().equalsIgnoreCase("") || textFields[0].getText().equalsIgnoreCase("") || textFields[1].getText().equalsIgnoreCase("")) {
									throw new NullException();
								}
								Oferta u = new Oferta(textFields[0].getText(), textFields[1].getText(), textFields[2].getText());
								if (c.createofer(u)) {
									JOptionPane.showMessageDialog(registerPanel, "Nuevo oferta creada con exito");
									f.dispose();
								}
								else {
									JOptionPane.showMessageDialog(registerPanel, "Nombre de oferta ya existente");
								}

							} catch(NullException h) {
								JOptionPane.showMessageDialog(registerPanel, "Campos vacios");
							}
						};
					});

					registerPanel.setAlignmentY(Component.TOP_ALIGNMENT);
					registerPanel.setAlignmentX(CENTER_ALIGNMENT);
					registerPanel.setMaximumSize(new Dimension(200, 600));
					
					mainPanel.add(registerPanel);
					mainPanel.add(Box.createGlue());

					f.add(mainPanel);
					f.setVisible(true);


			}
		});

		JButton DelOffer = new JButton("Eliminar");
		DelOffer.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Oferta of = ofertas.get(row);
				c.delete(of);
			}
		});

		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		this.add(scrollPane);

	}
}
