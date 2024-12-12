package controllers;

import models.Personaje;
import models.Sesion;
import models.VentanaJugarModelo;
import views.VentanaJugar;

public class VentanaJugarController {
	
	//Atributos
	private VentanaJugarModelo modelo;
	private VentanaJugar vista;
	private MainController mainController;
	
	//Constructor
	public VentanaJugarController(VentanaJugarModelo modelo) {
		this.modelo = modelo;
	}
	
	private void cargarPersonaje() {
        try {
            // Intentar cargar el personaje desde el modelo
            Personaje personaje = modelo.cargarPersonaje(Sesion.getinstancia().getUsuario().getNombreUsuario());

            if (personaje != null) {
                // Crear la vista usando el personaje cargado
                this.vista = new VentanaJugar(personaje);
                this.vista.setControlador(this);
            } else {
            	//Mensaje - Test
            	System.err.println("Error personaje nulo");
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
