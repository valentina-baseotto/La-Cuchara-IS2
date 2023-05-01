package windows;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Cuchara.Controller;
import Locales.Local;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;



/**
*
*Clase que define un panel que muestra una lista de locales y permite abrir la ventana de un local seleccionado.
*/

public class ListaLocalesPanel extends JPanel {
	private JTable table;
	private int row = 0;
	private int col = 0;

	/**
	Crea un panel con una tabla que muestra la lista de locales recibida como parámetro y un botón para abrir la ventana de un local seleccionado.
	@param c el controlador del programa.
	@param locales la lista de locales a mostrar en la tabla.
	*/
	public ListaLocalesPanel(Controller c) {
		List<Local> _locales = c.getListLocales(0);
		setBackground(new Color(158, 173, 175));

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNewButton = new JButton("Abrir Local");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalWindow lW;
				if(_locales != null)
					lW = new LocalWindow(_locales.get(row), c);
			}
		});

		JLabel lblNewLabel = new JLabel("LOCALES");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 478,
										Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		DefaultTableModel dft = new DefaultTableModel(new String[] { "Nombre", "Descripción", "Telefono" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		if (_locales != null)
			for (Local local : _locales) {
				Object[] fila = { local.getNombre(), local.getDescripcion(), String.valueOf(local.getTelefono()) };
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

		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		this.add(scrollPane);

	}
}
