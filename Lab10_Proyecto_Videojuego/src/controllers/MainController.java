package controllers;

import componentes.Audio;

public class MainController {

    private LoginController loginController;
    private RegisterController registerController;
    private VentanaInicioController inicioController;
    private VentanaPersonajesController personajesController;
    private VentanaJugarController jugarController;
    private VentanaCombateController combateController;
    
    //----------Constructor
    public MainController(LoginController loginController,RegisterController registerController,
    		VentanaInicioController inicioController,VentanaPersonajesController personajesController,
    		VentanaJugarController jugarController,VentanaCombateController combateController) {
    	
    	//-------------------
    	this.loginController = loginController;
    	this.registerController = registerController;
    	this.inicioController = inicioController;
    	this.personajesController = personajesController;
    	this.jugarController = jugarController;
    	this.combateController = combateController;
    	this.setControlador();
    }
    
    private void setControlador() {
    	this.loginController.setMainController(this);
    	this.registerController.setMainController(this);
    	this.inicioController.setMainController(this);
    	this.jugarController.setMainController(this);
    	this.personajesController.setMainController(this);
    	this.combateController.setMainController(this);
    }
    
    //Acciones  desde la ventana de Login
    public void mostrarRegistroDesdeLogin() {
    	this.loginController.detener();
    	this.registerController.iniciar();
    }
    
    public void mostrarVentanaInicio_Login() {
    	this.loginController.detener();
    	this.inicioController.iniciar();
    }
    
  //Acciones  desde la ventana de Registro
    public void mostrarLoginDesdeRegistro() {
    	this.registerController.detener();
    	this.loginController.iniciar();
    }
    
    //Acciones desde ventana de inicio
    public void mostrarVentanaJugar_Inicio() {
    	this.inicioController.detener();
    	this.jugarController.iniciar();
    }
    
    public void mostrarVentanaPersonajes_Inicio() {
    	this.inicioController.detener();
    	this.personajesController.iniciar();
    }
    
    //Acciones desde ventana de jugar
    public void mostrarVentanaInicio_Jugar() {
    	this.jugarController.detener();
    	this.inicioController.iniciar();
    }
    
    public void mostrarVentanaPersonajes_Jugar() {
    	this.jugarController.detener();
    	this.personajesController.iniciar();
    }
    
    public void mostrarVentanaCombate_Jugar() {
    	this.jugarController.detener();
    	Audio.stopAudioFondo();
    	this.combateController.iniciar();
    	Audio.playAudioBoton1();
    }
    
    //Acciones desde ventana de Personajes
    public void mostrarVentanaInicio_Personajes() {
    	this.personajesController.detener();
    	this.inicioController.iniciar();
    }
    
    public void mostrarVentanaJugar_Personajes() {
    	this.personajesController.detener();
    	this.jugarController.iniciar();
    }
    
    //Acciones desde ventana de Combate
    public void mostrarVentanaJugar_Combate() {
    	this.combateController.detener();
    	Audio.playAudioEnBucle();
    	this.jugarController.iniciar();
    }
    
    //Inicia el programa
    public void iniciar() {
    	this.loginController.iniciar();
    	Audio.playAudioEnBucle();
    }
    
}

