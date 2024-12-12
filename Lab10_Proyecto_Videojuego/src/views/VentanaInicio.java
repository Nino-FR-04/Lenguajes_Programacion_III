package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Colores.InterfazColores;
import Fuente.FuentePersonalizada;
import componentes.Audio;
import controllers.VentanaInicioController;
import models.Personaje;

public class VentanaInicio extends JFrame{

    private static final long serialVersionUID = 1L;
    private VentanaInicioController controlador;
	
    //Constructor------------
	public VentanaInicio(Personaje personaje) {
		super("VENTANA-INICIO");
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
        JPanel panelGrid = new JPanel(new GridLayout(1, 2,15,0));
        panelGrid.setBackground(null);
        panelGrid.setBorder(new EmptyBorder(30,30,30,30));

        panelGrid.add(crearImagen(personaje));
        panelGrid.add(crearEstadisticas(personaje));

        return panelGrid;
    }
	
	//Creacion del titulo
	private JLabel crearTitulo() {
        JLabel titulo = new JLabel("ESTADISTICAS");
        titulo.setFont(FuentePersonalizada.cargarFuente(29));
        titulo.setForeground(InterfazColores.FONT_LIGHT);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        return titulo;
    }
	
	//Creacion del panel de estadisticas del personaje
	private JPanel crearEstadisticas(Personaje personaje) {
		
		JPanel estadisticas = new JPanel(new BorderLayout());
		estadisticas.setBorder(new EmptyBorder(50,45,50,50));
		estadisticas.setBackground(null);
		
		//Añade titulo y el panel de atributos
		estadisticas.add(crearTitulo(),BorderLayout.NORTH);
		estadisticas.add(obtenerAtributos(personaje),BorderLayout.CENTER);
		
		return estadisticas;
		
	}
	
	//Obtiene los atributos de un personaje
	private JPanel obtenerAtributos(Personaje personaje) {
		
		JPanel panelAtributos = new JPanel(new GridLayout(4,2));
		//Agrega bordes vacios
		panelAtributos.setBorder(new EmptyBorder(10,10,10,10));
		panelAtributos.setBackground(InterfazColores.BACKGROUND_WINDOWS_COMPONENTS_COLOR);
		
		//Agregar los textos que representan los atributos del personaje
		panelAtributos.add(crearLabel("NOMBRE: "));
		panelAtributos.add(crearLabel(personaje.getNombre()));
		panelAtributos.add(crearLabel("VIDA: "));
		panelAtributos.add(crearLabel(String.valueOf(personaje.getVida())));
		panelAtributos.add(crearLabel("RESISTENCIA: "));
		panelAtributos.add(crearLabel(String.valueOf(personaje.getResistencia()) + "%"));
		panelAtributos.add(crearLabel("DAÑO: "));
		panelAtributos.add(crearLabel(String.valueOf(personaje.getDanio())));
		
		return panelAtributos;
		
	}
	
	//Creacion de componente JLabel
	private JLabel crearLabel(String text) {
        JLabel label = new JLabel(text);
        //Fuente de letra - personalizada
        label.setFont(FuentePersonalizada.cargarFuente(13));
        label.setForeground(InterfazColores.FONT_LIGHT);
        return label;
    }
	
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
	
	//-------------------------METODOS_PARTE PRINCIPAL
	//Crea la lista de botones de la parte principal
	private JPanel crearBotonesList() {
        JPanel panel = new JPanel(new GridLayout(1,3));
        panel.setBackground(InterfazColores.BACKGROUND_PRIMARY);
        
        JButton botonHome = crearBoton("INICIO");
        botonHome.addActionListener(e -> Audio.playAudioBoton3());
        
        JButton botonPlay = crearBoton("JUGAR");
        botonPlay.addActionListener(e -> {
        	this.controlador.getMainController().mostrarVentanaJugar_Inicio();
        	Audio.playAudioBoton2();
        });
        
        JButton botonColeccion = crearBoton("PERSONAJES");
        botonColeccion.addActionListener(e -> {
        	this.controlador.getMainController().mostrarVentanaPersonajes_Inicio();
        	Audio.playAudioBoton2();
        });
        
        //Añade los botones al panel
        panel.add(botonHome);
        panel.add(botonPlay);
        panel.add(botonColeccion);
        
        return panel;
    }
	
	//Encargado de crear los botones de la ventana
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

	//Setter del controlador
	public void setControlador(VentanaInicioController controlador) {
        this.controlador = controlador;
    }

}

