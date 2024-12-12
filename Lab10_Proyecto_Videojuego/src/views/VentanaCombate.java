package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Colores.InterfazColores;
import Fuente.FuentePersonalizada;
import componentes.BarraVida;
import componentes.TimerLabel;
import controllers.VentanaCombateController;
import models.Enemigo;
import models.Entidad;
import models.Personaje;

public class VentanaCombate extends JFrame {

    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private VentanaCombateController controlador;
    private BarraVida barraVidaPersonaje;
    private BarraVida barravidaEnemigo;
    private TimerLabel timerLabel;
    
    //Botones
    private JButton botonFisico;
    private JButton botonMagico;
    private JButton botonCurarse;
    
    //Constructor
    public VentanaCombate(Personaje personaje, Enemigo enemigo) {
        super("VENTANA-COMBATE");
        setSize(1000, 620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        
        this.add(panelFondo(personaje,enemigo),BorderLayout.CENTER);
        this.add(crearBotonesList(), BorderLayout.SOUTH);
        
    }
    
    /*
    Metodo encargado de crear una subclase de JPanel mediante una clase anonima
    , la cual se encarga de dibujar el gif de fondo.
    */
    private JPanel panelFondo(Personaje p, Enemigo e) {
    	JPanel panelP = new JPanel(new BorderLayout()) {
    		
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar y dibujar el fondo con un GIF
                ImageIcon gifFondo = new ImageIcon("Recursos\\FondoNiveles\\FondoNivel.gif");
                g.drawImage(gifFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
    	};
    	
    	//Añadir elementos al JPanel
    	panelP.add(panelSecundario(p,e),BorderLayout.CENTER);
    	
    	return panelP;
    	
    }

    //-----PanelSecundario - Contenedor
    private JPanel panelSecundario(Personaje p,Enemigo e) {
		JPanel secundario = new JPanel(new BorderLayout());
		
		secundario.setOpaque(false);
		secundario.add(crearPanelatributosEntidades(p,e),BorderLayout.NORTH);
		secundario.add(panelCentral(p,e));
	
    	return secundario;
	
    	
    }
    
    //--Panel que contiene los gif de las entidades
    private JPanel panelCentral(Personaje p, Enemigo e) {
    	JPanel entidades = new JPanel(new GridLayout(1,2));
    	entidades.setOpaque(false);
    	
    	entidades.add(crearImagen(p));
    	entidades.add(crearImagen(e));
    	
    	return entidades;
    	
    }
    
    //Metodo que inserta los gif de los personajes en JLabel
    private JPanel crearImagen(Entidad e) {

    	JPanel panelImg = new JPanel();
    	panelImg.setOpaque(false);
    	
    	panelImg.setBorder(new EmptyBorder(66,100,100,100));
    	
		ImageIcon imagen = new ImageIcon(e.getMovRuta());
		JLabel labelimg = new JLabel(imagen);
		labelimg.setPreferredSize(new Dimension(288,(620-imagen.getIconHeight())));
		
		panelImg.add(labelimg);
		
		return panelImg;
    }
    
    
    //---Panel que contiene las barras de vida y nombres de las entidades 
    private JPanel crearPanelatributosEntidades(Personaje p, Enemigo e) {
    	//Panel donde estan las vidas y nombres
    	JPanel panelAtributosEntidades = new JPanel(new GridLayout(2,1,0,5));
    	
    	panelAtributosEntidades.setOpaque(false);
    	panelAtributosEntidades.setBorder(new EmptyBorder(10,10,10,10));
    	
    	panelAtributosEntidades.add(panelBarrasVida(p,e));
    	panelAtributosEntidades.add(panelNombres_Timer(p.getNombre(),e.getNombre()));
    	
    	return panelAtributosEntidades;
    	
    }
    
    //Panel que contiene las barras de vida de las entidades
    private JPanel panelBarrasVida(Personaje p,Enemigo e) {
    	JPanel barrasVidas = new JPanel(new GridLayout(1,2,20,0));
    	barrasVidas.setOpaque(false);
    	
    	this.barraVidaPersonaje = crearBarraVida(p);
    	this.barravidaEnemigo = crearBarraVida(e);
    	
    	//Se agrega las barras de vida
    	barrasVidas.add(this.barraVidaPersonaje);
    	barrasVidas.add(this.barravidaEnemigo);
    	
    	return barrasVidas;
    	
    }
    
    //Panel que contiene todos los botones
    private JPanel crearBotonesList() {
        JPanel panel = new JPanel(new GridLayout(1,4,20,0));
        panel.setBorder(new EmptyBorder(30,10,30,10));
        panel.setBackground(Color.BLACK);
        
        this.botonFisico = crearBoton("ATAQUE FISICO");
        this.botonMagico = crearBoton("ATAQUE MAGICO");
        this.botonCurarse = crearBoton("CURARSE");

        panel.add(botonFisico);
        panel.add(botonMagico);
        panel.add(botonCurarse);
        
        return panel;
    }
    
    //Metodo para crear los botones con los que interactua el usuario
    private JButton crearBoton(String nombre) {
    	JButton boton = new JButton(nombre);
    	boton.setFont(FuentePersonalizada.cargarFuente(20));
    	boton.setForeground(InterfazColores.FONT_LIGHT);
    	boton.setBackground(null);
    	boton.setHorizontalAlignment(SwingConstants.CENTER);
    	boton.setFocusPainted(false);
    	return boton;
    }
    
    //----Panel que contiene los nombres y el timer
    private JPanel panelNombres_Timer(String nombreJugador, String nombreEnemigo) {
    	JPanel panelNombres = new JPanel(new GridLayout(1,3));
    	
    	//Timer
    	this.timerLabel = new TimerLabel(10);
    	
    	panelNombres.add(crearNombre(nombreJugador));
    	panelNombres.add(this.timerLabel);
    	panelNombres.add(crearNombre(nombreEnemigo));
    	panelNombres.setOpaque(false);;
    	
    	return panelNombres;
    	
    }
    
    //---------Crear los nombres de las entidades
    private JLabel crearNombre(String nombreEntidad) {
        JLabel nombre = new JLabel(nombreEntidad);
        nombre.setFont(FuentePersonalizada.cargarFuente(15));
        nombre.setForeground(new Color(36, 36, 36));
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        return nombre;
    }
    
    //----Metodo que usa la clase derivada de JProgressBar
    //Representa la vida de las entidades
    private BarraVida crearBarraVida(Entidad e) {
    	BarraVida barraVida = new BarraVida(e); 
    	barraVida.setOpaque(false);
    	barraVida.setPreferredSize(new Dimension(barraVida.getWidth(),30));
    	barraVida.setBorder(new LineBorder(InterfazColores.FONT_LIGHT,1));
    	
    	return barraVida;
    	
    }
    
	//Setter del controlador
	public void setControlador(VentanaCombateController controlador) {
        this.controlador = controlador;
    }
	
	//Getters - Componentes
	public BarraVida getBarraVidaPersonaje() {return this.barraVidaPersonaje;}
	public BarraVida getBarraVidaEnemigo() {return this.barravidaEnemigo;}
	public TimerLabel getTimerLabel() {return this.timerLabel;}
	public JButton getBotonFisico() {return this.botonFisico;}
	public JButton getBotonMagico() {return this.botonMagico;}
	public JButton getBotonCurarse() {return this.botonCurarse;}
	
	//Encargado de mostrar una ventana emergente con algun tipo de mensaje
    public void mensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
    }
	
}
