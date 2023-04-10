package Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;


public class RoundedButton extends JButton {

	Color color;
	
	public RoundedButton(String label, Color color) {
        super(label);
        this.color = color;
        setContentAreaFilled(false);
        setFocusPainted(false); 
        setPreferredSize(new Dimension(50, 50));
        setMaximumSize(new Dimension(50,50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) { // Si el botón está presionado
            g.setColor(Color.gray);
        } else {
            g.setColor(color);
        }

        // Dibujar el botón como un óvalo
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
    }
}
