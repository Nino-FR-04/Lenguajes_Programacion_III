package main;

import views.*;
import controllers.*;
import models.*;

public class Main {
    
	public static void main(String[] args) throws ClassNotFoundException {

		LoginController login = new LoginController(new LoginModelo(),new LoginView());
		RegisterController register = new RegisterController(new RegisterModelo(),new RegisterView());
		VentanaInicioController viController = new VentanaInicioController(new VentanaInicioModelo());
		VentanaJugarController vjController = new VentanaJugarController(new VentanaJugarModelo());
		VentanaPersonajesController vpController = new VentanaPersonajesController(new VentanaPersonajesModelo());
		VentanaCombateController combController = new VentanaCombateController(new VentanaCombateModelo());

		//Instancia principal
    	new MainController(login, register, viController, vpController, vjController,combController).iniciar();;
    	
    }
}


