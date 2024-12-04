package actividades;

import java.awt.BorderLayout;
import javax.swing.*;

public class TestBorder extends JFrame{

	private static final long serialVersionUID = 1L;

	public TestBorder() {
		//--Configuracion inicial
		setTitle("Test Border Layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		
		//Creacion panel y layout
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		//Componentes
		panel.add(new JButton("Boton_Norte"),BorderLayout.NORTH);
		panel.add(new JButton("Boton_Sur"),BorderLayout.SOUTH);
		panel.add(new JButton("Boton_Este"),BorderLayout.EAST);
		panel.add(new JButton("Boton_Oeste"),BorderLayout.WEST);
		panel.add(new JButton("Boton_Centro"),BorderLayout.CENTER);
		
		add(panel);
		setVisible(true);
		
	}
}
