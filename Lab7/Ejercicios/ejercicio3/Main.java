package ejercicio3;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		EmpleadoModelo modelo = new EmpleadoModelo();
		EmpleadoVista vista = new EmpleadoVista();
		EmpleadoControlador controlador = new EmpleadoControlador(vista,modelo);
		
		controlador.start();
	}
}
