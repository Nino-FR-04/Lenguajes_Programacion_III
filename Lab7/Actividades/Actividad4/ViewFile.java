package Actividad4;

import javax.swing.*;

public class ViewFile extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextArea areaTexto;
	
	public ViewFile(String s) {
		super("Mostrando el contenido de un archivo");
		areaTexto = new JTextArea(s,5,40);
		add(areaTexto);
	}
}
