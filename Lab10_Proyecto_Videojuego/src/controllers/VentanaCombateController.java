package controllers;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.util.Timer;
import componentes.Audio;
import componentes.TimerLabel;
import models.Combate;
import models.Enemigo;
import models.Personaje;
import models.Sesion;
import models.VentanaCombateModelo;
import views.VentanaCombate;

public class VentanaCombateController {
	
	private VentanaCombateModelo modelo;
	private VentanaCombate vista;
	private MainController mainController;
	private Personaje personaje;
	private Enemigo enemigo;
	private TimerLabel timer;
	private boolean turnoJugador;
	
	//Constructor
	public VentanaCombateController(VentanaCombateModelo modelo) {
		this.modelo = modelo;
		this.turnoJugador = false;
	}
	
	//Logica combate
	private void iniciarCombate() {
	    this.timer.iniciar();
	    TimerTask verificarEstado = new TimerTask() {
	        @Override
	        public void run() {
	        	if (verificarEstadoCombate()) {
                    cambiarTurno();
                } else {
                    detenerCombate();
                    this.cancel(); // Detiene el temporizador
                }
	        }
	    };
	    new Timer().schedule(verificarEstado, 0, 10000);
	}
	
	//Veridica los turnos
	private void cambiarTurno() {
        turnoJugador = !turnoJugador; // Alterna el turno

        if (turnoJugador) {
            cambiarEstadoBotones(true); // Habilita los botones para el jugador
            timer.reiniciar(10); // Reinicia el contador para el turno del jugador
            timer.iniciar(); // Inicia el temporizador
        } else {
            cambiarEstadoBotones(false); // Deshabilita los botones para el turno enemigo
            ejecutarTurnoEnemigo();
            timer.reiniciar(10); // Reinicia el contador para el turno del enemigo
            timer.iniciar(); // Inicia el temporizador
        }
    }
	
	//Ataques predeterminados
	private void ejecutarTurnoEnemigo() {
	    if (personaje.getVida() > 80) {
	        Combate.ataqueFisico(enemigo, personaje);
	        Audio.playAudioBoton2();
	    } else if (personaje.getVida() > 50 && personaje.getVida() <= 80) {
	        Combate.ataqueMagico(enemigo, personaje);
	        Audio.playAudioBoton2();
	    } else if (enemigo.getVida() > 30) {
	        // Si el enemigo tiene más de 30% de vida, puede seguir atacando
	        Combate.ataqueFisico(enemigo, personaje);
	        Audio.playAudioBoton2();
	    } else {
	        // Si el enemigo tiene menos de 30% de vida, se cura
	    	Audio.playAudioBoton3();
	        Combate.curarse(enemigo);
	    }
	}
	
	//Valida el estado del combate 
	private boolean verificarEstadoCombate() {
        if (personaje.getVida() <= 0) {
        	Audio.playAudioBoton2();
        	this.vista.mensaje("PERDISTE", "RESULTADO", JOptionPane.PLAIN_MESSAGE);
        	this.mainController.mostrarVentanaJugar_Combate();
            return false;
            
        } else if (enemigo.getVida() <= 0) {
        	
        	Audio.playAudioBoton3();
        	this.vista.mensaje("GANASTE", "RESULTADO", JOptionPane.PLAIN_MESSAGE);
        	this.mainController.mostrarVentanaJugar_Combate();
            return false;
        }
        return true;
    }
	
    private void detenerCombate() {
        cambiarEstadoBotones(false); // Deshabilita los botones
        timer.detener(); // Detiene el temporizador
    }
	
	public void realizarAtaqueFisico() {
        Combate.ataqueFisico(personaje, enemigo);
        procesarTurnoEnemigo();
        cambiarEstadoBotones(false);
    }
	
	public void realizarAtaqueMagico() {
		Combate.ataqueMagico(personaje, enemigo);
        procesarTurnoEnemigo();
        cambiarEstadoBotones(false);
    }

    public void curarPersonaje() {
    	if(this.personaje.getVida() < 30) {
    		Combate.curarse(personaje);
            procesarTurnoEnemigo();
            Audio.playAudioBoton2();
            cambiarEstadoBotones(false);
    	}
    	this.vista.getBotonCurarse().setEnabled(false);
    	Audio.playAudioBoton3();
    }

    private void procesarTurnoEnemigo() {
        verificarEstadoCombate();
    }
    
    private void cambiarEstadoBotones(boolean estado) {
        vista.getBotonMagico().setEnabled(estado);
        vista.getBotonFisico().setEnabled(estado);
        vista.getBotonCurarse().setEnabled(estado);
    }

	//--------------------ParteVisual
	private void cargarEntidades() {
		
		String nombre = Sesion.getinstancia().getUsuario().getNombreUsuario();
		
		try {
			this.personaje = modelo.cargarPersonaje(nombre);
			this.enemigo = this.modelo.cargarEnemigo();
			
			if (personaje != null) {
			    // Crear la vista usando el personaje cargado
			    this.vista = new VentanaCombate(this.personaje,this.enemigo);
			    this.vista.setControlador(this);
			    this.timer = this.vista.getTimerLabel();
			    
			} else {
			    // Mensaje de error si el personaje es nulo - testing
			    System.err.println("Error: El personaje es nulo.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Metodos
	private void cargarObservadores() {
		//Cargar observadores para Personaje
		this.personaje.agregarObservador(this.vista.getBarraVidaPersonaje());
		
		//Cargar observadores para Enemigo
		this.enemigo.agregarObservador(this.vista.getBarraVidaEnemigo());
	}
	
	//CargarAcciones botones - vista
	private void cargarBotonesListener() {
		this.vista.getBotonFisico().addActionListener(e -> {
			Audio.playAudioBoton1();
			this.realizarAtaqueFisico();
		});
		this.vista.getBotonMagico().addActionListener(e -> {
			Audio.playAudioBoton1();
			this.realizarAtaqueMagico();
		});
		this.vista.getBotonCurarse().addActionListener(e -> this.curarPersonaje());
	}
	
	
	//Metodos encargados de mostrar y ocultar la ventana
	public void iniciar() {
		cargarEntidades();
		cargarObservadores();
		cargarBotonesListener();
		this.iniciarCombate();
		Audio.playAudioEnBucle();
        this.vista.setVisible(true);
	}
		
	public void detener() {
		Audio.stopAudioFondo();
		this.vista.dispose();
	}
		
	//Getters y setters
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
		
	public MainController getMainController() {
		return this.mainController;
	}
	
}
