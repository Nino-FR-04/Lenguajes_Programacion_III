package controllers;

import javax.swing.JOptionPane;
import models.Sesion;
import models.VentanaPersonajesModelo;
import views.VentanaPersonajes;

public class VentanaPersonajesController {
	
	private MainController mainController;
	private VentanaPersonajesModelo modelo;
	private VentanaPersonajes vista;
	
	public VentanaPersonajesController(VentanaPersonajesModelo modelo) {
		this.modelo = modelo;
		this.vista = new VentanaPersonajes(modelo.getPersonajes());
		this.vista.setControlador(this);
	}
	
	public void actualizarPersonaje(int idPersonajeNuevo) {
		
		String nombre = Sesion.getinstancia().getUsuario().getNombreUsuario();
		
		try {
			if(this.modelo.actualizarPersonaje(idPersonajeNuevo, nombre)) {
				this.vista.mensaje("PERSONAJE SELECCIONADO CON EXITO","AVISO",JOptionPane.INFORMATION_MESSAGE);
				Sesion.getinstancia().getUsuario().setIDPersonaje(idPersonajeNuevo);
			}else {
				this.vista.mensaje("Error: Personaje no seleccionable","Error",JOptionPane.WARNING_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			this.vista.mensaje("Error: Clase no encontrada","Error",JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	//Metodos para mostrar y ocultar la ventana
	public void iniciar() {
		this.vista.setVisible(true);
	}
	
	public void detener() {
		this.vista.dispose();
	}
	
	//setters y getters
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public MainController getMainController() {
		return this.mainController;
	}
	
}
