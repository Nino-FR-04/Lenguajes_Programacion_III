package ejercicios;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProductoVista extends JFrame{

	private static final long serialVersionUID = 1L;
	
	//----------Campos de texto
	private JTextField nombreField;
    private JTextField precioField;
    private JTextField stockField;
    private JTextField categoriaField;
	
	public ProductoVista(ProductoModelo modelo) {
		super("Vista Producto");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JPanel());
		
		//Se agrega el layout al contenedor principal
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		//Construccion de paneles
		add(titulo());
		add(panelDatos(modelo));
		add(boton(modelo));
	}
	
	private JLabel titulo() {
		JLabel title = new JLabel("PRODUCTO");
		title.setBorder(new EmptyBorder(0,0,30,0));
		title.setFont(new Font("Times New Roman",Font.BOLD,30));
		
		return title;
	}
	
	private JPanel panelDatos(ProductoModelo modelo) {
		JPanel datos = new JPanel(new GridLayout(4,2));
		datos.setBorder(new EmptyBorder(0,10,0,10));
		
		datos.add(new JLabel("Nombre"));
        nombreField = new JTextField(modelo.getNombre(), 20);
        datos.add(nombreField);
        
        datos.add(new JLabel("Precio"));
        precioField = new JTextField(String.valueOf(modelo.getPrecio()), 15);
        datos.add(precioField);

        datos.add(new JLabel("Stock"));
        stockField = new JTextField(String.valueOf(modelo.getStock()), 10);
        datos.add(stockField);
        
        datos.add(new JLabel("Categoría"));
        categoriaField = new JTextField(modelo.getCategoria(), 20);
        datos.add(categoriaField);
		
		return datos;
	}
	
	private JPanel boton(ProductoModelo modelo) {
		JPanel button_Panel = new JPanel(new FlowLayout());
		button_Panel.setBorder(new EmptyBorder(50,0,0,0));
		
		JButton boton = new JButton("Actualizar producto");
		
		//----------------------------
		boton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.setNombre(nombreField.getText());
				
				//Validar entrada de datos
				try {
					double precio = Double.parseDouble(precioField.getText());
					int stock = Integer.parseInt(stockField.getText());
					
					modelo.setPrecio(precio);
					modelo.setStock(stock);
					
				}catch(NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(null,"Ingrese los valores correctos","Error",JOptionPane.WARNING_MESSAGE);
				}
				
				modelo.setCategoria(categoriaField.getText());
				
				//Mostrar modelo actualizado por GUI - JOptionPane
				JOptionPane.showMessageDialog(null,modelo,"Producto",JOptionPane.INFORMATION_MESSAGE);
				
				//Mostrar modelo actualizado por consola
				System.out.println(modelo);
				
			}
		});
		
		button_Panel.add(boton);
		
		return button_Panel;
		
	}
}
