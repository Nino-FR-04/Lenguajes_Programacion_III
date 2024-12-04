package actividades;

import java.awt.*;
import javax.swing.*;

public class TestGrid extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public TestGrid() {
		//Configuracion del frame - Extiende de JFrame
		
		setTitle("Test Grid Layout"); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
		
		//Asignación del Panel y Layout
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2)); //(Filas,Columnas)
		
		//(Filas,Columnas, espacio, espacio)
		
		//Agregar elementos al panel
		JButton b1 = new JButton("Boton 1");
		JButton b2 = new JButton("Boton 2");
		
		JLabel l1 = new JLabel("Label1");
		JLabel l2 = new JLabel("Label2");
		
		panel.add(b1);
		panel.add(b2);
		panel.add(l1);
		panel.add(l2);
		
		/*
		JButton b3 = new JButton("Boton 3");
		panel.add(b3);
		*/
		
		add(panel);
		setVisible(true);
	}	
}
