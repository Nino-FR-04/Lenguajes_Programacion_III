package actividades;

import java.awt.*;
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Ejemplo CardLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        CardLayout cardLayout = new CardLayout();
        JPanel panel = new JPanel(cardLayout);

        panel.add(new JLabel("Página 1"), "1");
        panel.add(new JLabel("Página 2"), "2");
        panel.add(new JLabel("Página 3"), "3");

        JButton botonSiguiente = new JButton("Siguiente");
        botonSiguiente.addActionListener(e -> cardLayout.next(panel));

        frame.add(panel, BorderLayout.CENTER);
        frame.add(botonSiguiente, BorderLayout.SOUTH);
        frame.setVisible(true);
		
		
		
		//new TestGrid();
		//new TestFlow();
		//new TestBorder();
	}
}
