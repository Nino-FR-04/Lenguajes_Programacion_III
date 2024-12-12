package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Colores.InterfazColores;
import Fuente.FuentePersonalizada;
import componentes.Audio;
import controllers.VentanaPersonajesController;
import models.Personaje;
import java.util.ArrayList;

public class VentanaPersonajes extends JFrame {

	private static final long serialVersionUID = 1L;
    private VentanaPersonajesController controlador;
	
	
	//Constructor------------
		public VentanaPersonajes(ArrayList<Personaje> personajes) {
			super("VENTANA-PERSONAJES");
			setSize(1000,620);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// Panel principal
	        JPanel panelPrincipal = new JPanel(new BorderLayout());
	        panelPrincipal.setBackground(InterfazColores.BACKGROUND_WINDOWS);
	        
	        panelPrincipal.add(crearBotonesList(), BorderLayout.NORTH);
	        panelPrincipal.add(panelPersonajes(personajes),BorderLayout.CENTER);
	        
	        //Añadir al JFrame el panel principal
	        add(panelPrincipal);
		}
		
		//---------Creacion del panel de personajes (titulo y scrollbar)
		
		private JPanel panelPersonajes(ArrayList<Personaje> personajes) {
			
			JPanel panelPersonajes = new JPanel(new BorderLayout());
			panelPersonajes.setBorder(new EmptyBorder(30,150,30,150));
			panelPersonajes.setBackground(null);
			
			panelPersonajes.add(crearTitulo(),BorderLayout.NORTH);
			panelPersonajes.add(crearIconosPersonajes(personajes),BorderLayout.CENTER);
			
			return panelPersonajes;
			
		}

		private JScrollPane crearIconosPersonajes(ArrayList<Personaje> personajes) {
			
			JPanel iconos = new JPanel(new GridLayout(4,2));
			iconos.setBackground(InterfazColores.BACKGROUND_PRIMARY);
			
			for (Personaje p : personajes) {
			    // Crear la descripción con HTML
			    String descripcion = "<html>" + 
			                         "<font face='Monospaced' color='black' size='4'>" + "Nombre: " + p.getNombre() + "</font><br>" +
			                         "<font face='Monospaced' color='black' size='4'> Descripcion: " + p.getDescripcion() + "</font><br>" +
			                         "<font face='Monospaced' color='black' size='4'><b>Daño:</b> " + p.getDanio() + "</font>" +
			                         "</html>";
			    
			    // Agregar el botón con el icono y el tooltip formateado
			    iconos.add(crearIconoPersonaje(p.getIconoRuta(), descripcion,p.getId()));
			}

			JScrollPane scroll = new JScrollPane(iconos);
			scroll.setBackground(InterfazColores.BACKGROUND_SECONDARY);
			scroll.setBorder(new EmptyBorder(10,10,10,10));
			
			return scroll;
			
		}
		
		private JButton crearIconoPersonaje(String ruta,String descripcion,int id) {
			JButton personajeBoton = new JButton(crearImagen(ruta));
			personajeBoton.setBackground(InterfazColores.BACKGROUND_COMPONENTES_COLOR);
			personajeBoton.setToolTipText(descripcion);
			personajeBoton.setFocusPainted(false);
			
			personajeBoton.addActionListener(e -> {
				Audio.playAudioBoton1();
				controlador.actualizarPersonaje(id);
			});
			
			return personajeBoton;
		}
		
		private ImageIcon crearImagen(String ruta) {
	    	ImageIcon imagen = new ImageIcon(new ImageIcon(ruta)
	                .getImage().getScaledInstance(180,180, Image.SCALE_SMOOTH));
	  
			return imagen;
	    }
		
		private JLabel crearTitulo() {
	        JLabel titulo = new JLabel("ESCOGE A TU PERSONAJE");
	        titulo.setFont(FuentePersonalizada.cargarFuente(30));
	        titulo.setForeground(InterfazColores.FONT_LIGHT);
	        titulo.setHorizontalAlignment(SwingConstants.CENTER);
	        return titulo;
	    }
		
		//-------------------------METODOS_PARTE PRINCIPAL
		private JPanel crearBotonesList() {
	        JPanel panel = new JPanel(new GridLayout(1,3));
	        panel.setBackground(InterfazColores.BACKGROUND_PRIMARY);

	        JButton botonPlay = crearBoton("JUGAR");
	        botonPlay.addActionListener(e -> {
	        	this.controlador.getMainController().mostrarVentanaJugar_Personajes();
	        	Audio.playAudioBoton2();
	        });
	        
	        JButton botonHome = crearBoton("INICIO");
	        botonHome.addActionListener(e -> {
	        	this.controlador.getMainController().mostrarVentanaInicio_Personajes();
	        	Audio.playAudioBoton2();
	        });
	        
	        JButton botonColeccion = crearBoton("PERSONAJES");
	        botonColeccion.addActionListener(e -> Audio.playAudioBoton3());
	        
	        panel.add(botonHome);
	        panel.add(botonPlay);
	        panel.add(botonColeccion);
	        
	        return panel;
	    }
		
		private JButton crearBoton(String text) {
	        JButton button = new JButton(text);
	        button.setFont(FuentePersonalizada.cargarFuente(20));
	        button.setForeground(InterfazColores.FONT_LIGHT);
	        button.setBackground(null);
	        button.setBorder(new EmptyBorder(15,0,15,0));
	        button.setFocusPainted(false);
	        return button;
	    }
		
		//Encargado de mostrar una ventana emergente con algun tipo de mensaje
	    public void mensaje(String mensaje, String titulo, int tipo) {
	        JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
	    }
		
		//Setter
		public void setControlador(VentanaPersonajesController controlador) {
	        this.controlador = controlador;
	    }
}
