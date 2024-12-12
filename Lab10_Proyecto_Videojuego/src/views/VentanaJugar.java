package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Colores.InterfazColores;
import Fuente.FuentePersonalizada;
import componentes.Audio;
import controllers.VentanaJugarController;
import models.Personaje;

public class VentanaJugar extends JFrame{

    private static final long serialVersionUID = 1L;
    private VentanaJugarController controlador;
    
    //Constructor------------
	public VentanaJugar(Personaje personaje) {
		super("VENTANA-JUGAR");
		setSize(1000,620);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(InterfazColores.BACKGROUND_WINDOWS);
        
        panelPrincipal.add(crearBotonesList(), BorderLayout.NORTH);
        panelPrincipal.add(crearPanelGrid(personaje), BorderLayout.CENTER);
        
        //Añadir al JFrame el panel principal
        add(panelPrincipal);
	}
	
	//Panel que es agregado al principal
	private JPanel crearPanelGrid(Personaje personaje) {
        JPanel panelGrid = new JPanel(new GridLayout(1, 2,20,0));
        panelGrid.setBackground(null);
        panelGrid.setBorder(new EmptyBorder(30,30,30,30));

        panelGrid.add(crearImagen(personaje));
        panelGrid.add(crearPanelJuego());
        
        return panelGrid;
    }
	
	//Creacion del panel secundario
	private JPanel crearPanelJuego() {
		JPanel juegoP = new JPanel(new GridLayout(3,1));
		juegoP.setBorder(new EmptyBorder(30,30,30,30));
		juegoP.setBackground(InterfazColores.BACKGROUND_WINDOWS_COMPONENTS_COLOR);
		
		juegoP.add(crearDificultadPanel());
		juegoP.add(crearLabel("NIVEL 1"));
		juegoP.add(crearBotonIniciar());
		
		return juegoP;
		
	}
	
	//Cargar el gif e insertarlo en un JLabel
	private JPanel crearImagen(Personaje personaje) {
		//Creacion de un nuevo panel para centrar la imagen
		JPanel panelIMG = new JPanel(new BorderLayout());
		panelIMG.setBackground(InterfazColores.BACKGROUND_WINDOWS_COMPONENTS_COLOR);
		
		//Creacion de una imagen - gif del personaje
		ImageIcon imagen = new ImageIcon(personaje.getMovRuta());
		JLabel labelimg = new JLabel(imagen);
		
		//Agregar la imagen al centro del layout
		panelIMG.add(labelimg,BorderLayout.CENTER);
		
		return panelIMG;
    }
	
	//Creacion de componente JLabel
	private JLabel crearLabel(String text) {
        JLabel label = new JLabel(text);
        //Fuente de letra
        label.setFont(FuentePersonalizada.cargarFuente(25));
        label.setForeground(InterfazColores.FONT_LIGHT);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
	
	//Panel de opciones - DECORATIVO
    private JPanel crearDificultadPanel() {
        
    	JPanel panelTitulo = new JPanel(new BorderLayout());
    	panelTitulo.setBackground(null);
    	
    	// Crear un JPanel con un diseño de cuadrícula (1 fila, 3 columnas)
        JPanel panelDif = new JPanel(new GridLayout(1, 3));
        panelDif.setBackground(null);
        
        // Crear botones de radio
        JRadioButton facil = crearRadioButton("Fácil", false);
        JRadioButton medio = crearRadioButton("Medio", true);
        JRadioButton dificil = crearRadioButton("Difícil", false);

        // Agrupar los botones de radio para que sean mutuamente excluyentes
        ButtonGroup group = new ButtonGroup();
        group.add(facil);
        group.add(medio);
        group.add(dificil);

        // Agregar los botones al panel
        panelDif.add(facil);
        panelDif.add(medio);
        panelDif.add(dificil);
        
        //Agregar al panel Border
        
        panelTitulo.add(crearLabel("DIFICULTAD"),BorderLayout.NORTH);
        panelTitulo.add(panelDif,BorderLayout.CENTER);

        return panelTitulo;
    }
    
    //Creacion de las opciones mediante JRadioButton
    //Estados por defecto "false" 
    private JRadioButton crearRadioButton(String texto, boolean estado) {
        // Crear un JRadioButton con el texto dado
        JRadioButton Rboton = new JRadioButton(texto);
        
        // Configurar estilo
        Rboton.setFont(FuentePersonalizada.cargarFuente(12));
        Rboton.setForeground(InterfazColores.FONT_LIGHT); // Cambia según InterfazColores.FONT_LIGHT
        Rboton.setBackground(null);
        
        // Configurar estado inicial
        Rboton.setSelected(estado);
        Rboton.setEnabled(estado); // Por el momento solo una dificultad
        Rboton.setHorizontalAlignment(SwingConstants.CENTER);
        
        return Rboton;
    }
	
	//-------------------------METODOS_PARTE PRINCIPAL
    //--------Metodos de la ventana principal
	private JPanel crearBotonesList() {
        JPanel panel = new JPanel(new GridLayout(1,3));
        panel.setBackground(InterfazColores.BACKGROUND_PRIMARY);
        
        JButton botonPlay = crearBoton("JUGAR");
        botonPlay.addActionListener(e -> Audio.playAudioBoton3());
        
        JButton botonHome = crearBoton("INICIO");
        botonHome.addActionListener(e -> {
        	this.controlador.getMainController().mostrarVentanaInicio_Jugar();
        	Audio.playAudioBoton2();
        	});
        
        JButton botonColeccion = crearBoton("PERSONAJES");
        botonColeccion.addActionListener(e -> {
        	this.controlador.getMainController().mostrarVentanaPersonajes_Jugar();
        	Audio.playAudioBoton2();
        });
        
        panel.add(botonHome);
        panel.add(botonPlay);
        panel.add(botonColeccion);
        
        return panel;
    }
	
	//Crear Boton para la lista de opciones de la ventana
	private JButton crearBoton(String text) {
        JButton button = new JButton(text);
        button.setFont(FuentePersonalizada.cargarFuente(20));
        button.setForeground(InterfazColores.FONT_LIGHT);
        button.setBackground(null);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBorder(new EmptyBorder(15,0,15,0));
        button.setFocusPainted(false);
        return button;
    }
	
	//Creacion del boton para direccionar a la ventana de combate
	private JButton crearBotonIniciar() {
        JButton button = new JButton("INICIAR");
        button.setFont(FuentePersonalizada.cargarFuente(20));
        button.setForeground(InterfazColores.FONT_LIGHT);
        button.setBackground(InterfazColores.BACKGROUND_SECONDARY);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFocusPainted(false);
        
        //Añadir actionListener
        button.addActionListener(e -> {
        	this.controlador.getMainController().mostrarVentanaCombate_Jugar();
        	Audio.playAudioBoton1();
        });
        
        return button;
    }
	
	//Setters - Controlador
	public void setControlador(VentanaJugarController controlador) {
        this.controlador = controlador;
    }

}