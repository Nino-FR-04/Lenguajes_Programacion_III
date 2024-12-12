package controllers;

import models.*;
import views.VentanaInicio;

public class VentanaInicioController {

	private VentanaInicioModelo modelo;
	private VentanaInicio vista;
	private MainController mainController;
	
	//Constructor
	public VentanaInicioController(VentanaInicioModelo modelo) {
		this.modelo = modelo;
	}
	
	//Carga el personaje
	private void cargarPersonaje() {
		try {
			Personaje personaje = modelo.cargarPersonaje(Sesion.getinstancia().getUsuario().getNombreUsuario());
			if (personaje != null) {
			    // Crear la vista usando el personaje cargado
			    this.vista = new VentanaInicio(personaje);
			    this.vista.setControlador(this);
			} else {
			    // Mensaje de error si el personaje es nulo - testing
			    System.err.println("Error: El personaje es nulo.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Metodos encargados de mostrar y ocultar la ventana
	public void iniciar() {
        cargarPersonaje();
        this.vista.setVisible(true);
    }
	
	public void detener() {
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
