package actividades;

import java.awt.FlowLayout;
import javax.swing.*;

public class TestFlow extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public TestFlow() {
		
		// Configuración de la ventana
		/*---Llamado al constructor de la clase base
		asignando el titulo de la ventana*/
		super("Test Flow Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 150);
		
		//Asignación del Panel y Layout
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		/*
		----Alineacion
		Right
		Left
		Center
		LEADING (Lectura)
		TRAILNG (Lectura)
		*/
        
		// Componentes
		panel.add(new JButton("Botón 1"));
		panel.add(new JButton("Botón 2"));
		panel.add(new JButton("Botón 3"));
		
		add(panel);
		setVisible(true);
	}
}
