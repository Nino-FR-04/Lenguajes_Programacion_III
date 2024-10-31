package ejercicio3;

import java.io.IOException;

public class EmpleadoControlador {
	//--------------------------
	private EmpleadoVista vista;
	private EmpleadoModelo modelo;
	
	//-----------Constructor
	public EmpleadoControlador(EmpleadoVista vista,EmpleadoModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	//Metodos
	
	public void agregarEmpleado(int numero,String nombre,double saldo) {
		try {
			
			if(!this.modelo.contains(numero)) {
				this.modelo.AgregarEmpleado(new Empleado(numero,nombre,saldo));
				this.vista.mostrar("Empleado Agregado con exito");
			}else {
				this.vista.mostrar("Error: Numero de empleado duplicado");
			}
		}catch(IllegalArgumentException e) {
			this.vista.mostrar("Error: Argumentos no validos");
		}catch(IOException e) {
			this.vista.mostrar("Error: Archivo Erroneo");
		}
	}
	
	public void mostrarPedidos() {
		this.vista.mostrarEmpleados(this.modelo.getEmpleados());
	}
	
	public void eliminarEmpleados(int numero) {
		if(this.modelo.contains(numero)) {
			try {
				String nombre = this.modelo.EliminarEmpleado(numero);
				this.vista.mostrar("Empleado eliminado: " + nombre);
			} catch (IOException e) {
				this.vista.mostrar("Error: Archivo erroneo");
			}
		}else {
			this.vista.mostrar("Error: Empleado no encontrado");
		}
	}
	
	public void buscarEmpleado(int numero) {
		if(this.modelo.contains(numero)) {
			this.vista.mostrar("-------------Empleado-------------");
			this.vista.mostrar(this.modelo.BuscarEmpleado(numero));
		}else {
			this.vista.mostrar("Error: Empleado no encontrado");
		}
	}
	
	//---------------------------------------------------------
	public void start() {
		String opc;
		
		do {
			
			this.vista.menu();
			opc = this.vista.solicitarOpcion();
			
			switch(opc) {
				case "1":
					mostrarPedidos();
					break;
				
				case "2":
					int numero = this.vista.solicitarNumero();
					String nombre = this.vista.solicitarNombre();
					double saldo = this.vista.solicitarSaldo();
					
					agregarEmpleado(numero, nombre, saldo);
					break;
					
				case "3":
					int num = this.vista.solicitarNumero();
					buscarEmpleado(num);
					break;
				
				case "4":
					int num1 = this.vista.solicitarNumero();
					eliminarEmpleados(num1);
					break;
				
				case "5":
					this.vista.mostrar("Saliendo...");
					break;
				
				default:
					this.vista.mostrar("--------Opcion no valida-------");
			}
			
			
		}while(!opc.equals("5"));
		
		this.vista.closeScanner();
	}
	
}
