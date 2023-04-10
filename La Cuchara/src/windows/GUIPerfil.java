package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.Border;

import Usuarios.Usuario;

public class GUIPerfil extends JFrame{

	private JLabel nombre, usuario, contrasena, email;
	private JPanel namePanel, userPanel, passPanel, emailPanel, middlePanel;
	private JTextField nameText, userText, passText, emailText ;
	private JButton confirmName, confirmUser, confirmPass, confirmEmail;
	
	public GUIPerfil() {
		
	}
	
	public JPanel profilePanel(Usuario u)
	{
		JPanel _profilePanel = new JPanel();
		_profilePanel.setLayout(new BoxLayout(_profilePanel, BoxLayout.Y_AXIS));

		JPanel[] panels = new JPanel[5];
		JLabel[] labels = new JLabel[5];
		JTextField[] textFields = new JTextField[5];
		JButton[] confirmButtons = new JButton[5];
		
		labels[0] = new JLabel("Nombre: ");
		Font font = labels[0].getFont();
        labels[0].setFont(new Font("Serif", Font.PLAIN, 28));
        labels[0].setMinimumSize(new Dimension(500, 500));

		labels[1] = new JLabel("Usuario: ");
		font = labels[1].getFont();
        labels[1].setFont(new Font("Serif", Font.PLAIN, 28));
        
		labels[2] = new JLabel("Contrasena: ");
		font = labels[2].getFont();
        labels[2].setFont(new Font("Serif", Font.PLAIN, 28));
        
		labels[3] = new JLabel("Email: ");
		font = labels[3].getFont();
        labels[3].setFont(new Font("Serif", Font.PLAIN, 28));
        
		labels[4] = new JLabel("Telefono: ");
		font = labels[4].getFont();
        labels[4].setFont(new Font("Serif", Font.PLAIN, 28));
        
		labels[0].setSize(new Dimension(200, 200));
		
		textFields[0] = new JTextField(u.getName());
		textFields[0].setFont(new Font("Arial", Font.PLAIN, 20));
		
		textFields[1] = new JTextField(u.getID());
		textFields[1].setFont(new Font("Arial", Font.PLAIN, 20));
		
		textFields[2] = new JTextField(u.getPass());
		textFields[2].setFont(new Font("Arial", Font.PLAIN, 20));
		
		textFields[3] = new JTextField(u.getMail());
		textFields[3].setFont(new Font("Arial", Font.PLAIN, 20));
		
		textFields[4] = new JTextField(Integer.toString(u.getPhone()));
		textFields[4].setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel(new GridLayout(2, 2));
			panels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			panels[i].setMinimumSize(new Dimension(500, 500));
			confirmButtons[i] = new JButton("Confirmar");
		}
		
		confirmButtons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				u.setName(textFields[0].getText());
				
			}
	    	
	    });
		
		confirmButtons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				u.setID(textFields[1].getText());
				
			}
	    	
	    });
		
		confirmButtons[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				u.setPass(textFields[2].getText());
				
			}
	    	
	    });
		
		confirmButtons[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				u.setMail(textFields[3].getText());
				
			}
	    	
	    });
		
		confirmButtons[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				u.setPhone(Integer.parseInt(textFields[4].getText()));
				}catch(NumberFormatException f) {
					JOptionPane.showMessageDialog(_profilePanel, "Formato del numero de telefono incorrecto");
					textFields[4].setText(Integer.toString(u.getPhone()));
				}
				
			}
	    	
	    });
		
		 middlePanel = new JPanel(new GridLayout(panels.length,1));

			for (int i = 0; i < panels.length; i++) {
			    panels[i].add(labels[i]);
			    JPanel blue = new JPanel();
			    blue.setOpaque(false);
			    panels[i].add(blue);
			    panels[i].add(textFields[i]);
			    panels[i].add(confirmButtons[i]);
			    
			}

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
		
		_profilePanel.setBackground(new Color(158, 173, 175));
		
		return _profilePanel;

	}
}
