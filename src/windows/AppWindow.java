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
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Cuchara.Controller;

public class AppWindow extends JFrame{

	Controller controller;
	GUIPerfil profile;
	private boolean ofertasShown;
	
	public AppWindow(Controller controller) {
		super("La Cuchara");
		ofertasShown = true;
		this.controller = controller;
		profile = new GUIPerfil();
		initGUI();
	}
    


    private void initGUI(){

    	JPanel rightPanel;
        rightPanel = new JPanel(new CardLayout());
        JPanel rightPanelOfertas;
        JPanel rightPanelLocales;
        JPanel rightPanelProfile = profile.profilePanel(controller.getUser());
        JPanel leftPanel,upperPanel;
        JSplitPane updownSplit;
        JSplitPane splitPane;
        JPanel usuarios;
        
        addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
               	controller.save();
            }
		});

        setTitle("LocalesOfertas");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		rightPanelOfertas = new JPanel();
		rightPanelOfertas.setBackground(new Color(158, 173, 175));
		
		rightPanelLocales = new JPanel();
		rightPanelLocales.setBackground(new Color(158, 173, 175));
		
		JLabel ofertas = new JLabel("Ofertas");
		JLabel locales = new JLabel("Locales");
		
		ofertas.setFont(new Font("Serif", Font.BOLD, 40));
		locales.setFont(new Font("Serif", Font.BOLD, 40));
		
        rightPanelOfertas.add(ofertas);
        rightPanelLocales.add(locales);

        rightPanel.add(rightPanelOfertas, "rightPanelOfertas");
        rightPanel.add(rightPanelLocales, "rightPanelLocales");
        rightPanel.add(rightPanelProfile, "rightPanelProfile");

        upperPanel = new JPanel(new BorderLayout());
        JButton switchButton = new JButton("Ofertas");
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

        String[] items = {"alfabetico", "precio", "distancia"};

        JComboBox<String> dropdown = new JComboBox<>(items);

        dropdown.setSelectedIndex(0);
        dropdown.setMaximumSize(new Dimension(150,30));
        dropdown.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
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
		
		switchButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                leftPanel.setVisible(true);
                splitPane.setDividerLocation(200);
                switchButton.setFont(new Font("Serif", Font.BOLD, 20));
                
                if (ofertasShown) {
                    switchButton.setText("Locales");
                    ((CardLayout) rightPanel.getLayout()).show(rightPanel, "rightPanelLocales");
                    ofertasShown = false;
                } else {
                    switchButton.setText("Ofertas");
                    ((CardLayout) rightPanel.getLayout()).show(rightPanel, "rightPanelOfertas");
                    ofertasShown = true;
                }
            }
            });
		
		usuarioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 leftPanel.setVisible(false);
				 ((CardLayout) rightPanel.getLayout()).show(rightPanel, "rightPanelProfile");
				 switchButton.setText("←");
				 switchButton.setFont(new Font("Serif", Font.BOLD, 40));
				 
				 ofertasShown = !ofertasShown;
				 
			}
		});
		
		setVisible(true);
    }
}
