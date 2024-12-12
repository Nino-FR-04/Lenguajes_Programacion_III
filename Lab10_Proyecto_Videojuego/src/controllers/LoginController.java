package controllers;

import javax.swing.JOptionPane;

import componentes.Audio;
import models.LoginModelo;
import models.Sesion;
import views.LoginView;

public class LoginController {
	
	private LoginModelo modelo;
	private LoginView vista;
	private MainController mainController;
	
	//Contructor
	public LoginController(LoginModelo modelo,LoginView vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
	}
	
	// Retorna el objeto Usuarios si el login es exitoso, de lo contrario devuelve null
	public void validarDatos() {
		// Obtener las credenciales de la vista
		String usuario = this.vista.getUsernameValue();
		String contrasenia = this.vista.getPasswordValue();
		
		try {
			// Validar las credenciales
			if (this.modelo.validarDatos(usuario, contrasenia)) {
				// Credenciales correctas, se muestra mensaje de éxito
				Audio.playAudioBoton1();
				this.vista.mensaje("INICIO DE SESIÓN EXITOSO", "SESION", JOptionPane.INFORMATION_MESSAGE);
				Sesion.getinstancia().setUsuario(this.modelo.getDatosUsuario(usuario));
				this.mainController.mostrarVentanaInicio_Login();
			
			} else {
				// Credenciales incorrectas
				Audio.playAudioBoton3();
				this.vista.mensaje("Credenciales Incorrectas", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			// Error al cargar la clase JDBC
			e.printStackTrace();
			this.vista.mensaje("ERROR: Clase no Encontrada", "ERROR", JOptionPane.WARNING_MESSAGE);
		} catch (IllegalArgumentException e) {
			Audio.playAudioBoton3();
			this.vista.mensaje("ERROR: Campos Vacios", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	//Metodo encargados de mostrar y ocultar la ventana
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
