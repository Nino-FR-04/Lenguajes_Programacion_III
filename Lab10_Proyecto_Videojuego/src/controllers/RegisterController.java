package controllers;

import javax.swing.JOptionPane;

import componentes.Audio;
import models.RegisterModelo;
import views.RegisterView;
import excepciones.UsuarioExistenteException;

public class RegisterController {
	
	//Atributos
	private RegisterModelo modelo;
	private RegisterView vista;
	private MainController mainController;
	
	//Constructor
	public RegisterController(RegisterModelo modelo,RegisterView vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
	}
	
	//Metodo encargado del ingreso de datos
	public void IngresarDatos() {
		try {
			if(this.modelo.insertarDatos(this.vista.getUsernameValue(),this.vista.getPasswordValue())) {
				Audio.playAudioBoton1();
				this.vista.mensaje("REGISTRO EXITOSO", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
				this.mainController.mostrarLoginDesdeRegistro();
			}else {
				Audio.playAudioBoton3();
				this.vista.mensaje("Credenciales Incorrectas", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			this.vista.mensaje("ERROR: Clase no Encontrada", "ERROR", JOptionPane.WARNING_MESSAGE);
		} catch (UsuarioExistenteException e) {
			Audio.playAudioBoton3();
			this.vista.mensaje("ERROR: Usuario Existente", "ERROR", JOptionPane.WARNING_MESSAGE);
		} catch (IllegalArgumentException e) {
			Audio.playAudioBoton3();
			this.vista.mensaje("ERROR: Campos Vacios", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//Metodos encargados de mostrar y ocultar la ventana
	public void iniciar() {
		this.vista.setVisible(true);
	}	
	
	public void detener() {
		this.vista.dispose();
	}
	
	//setter y getter
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public MainController getMainController() {
		return this.mainController;
	}
	
}
