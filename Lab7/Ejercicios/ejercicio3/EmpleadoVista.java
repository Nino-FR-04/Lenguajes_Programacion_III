package ejercicio3;
import java.util.Scanner;
import java.util.ArrayList;

public class EmpleadoVista {
	private Scanner sc;
	
	//----------------------------------
	public EmpleadoVista() {
		sc = new Scanner(System.in);
	}
	
	//-----------Metodos
	public void menu() {
		System.out.println("--------------------Menu--------------------");
		System.out.println("1) Listar Empleados");
		System.out.println("2) Agregar Empleado");
		System.out.println("3) Buscar Empleado(Numero)");
		System.out.println("4) Eliminar Empleado(Numero)");
		System.out.println("5) Salir del programa");
		System.out.println("--------------------------------------------");
	}
	
	public void mostrarEmpleados(ArrayList<Empleado> empleados) {
		System.out.println("------------------Empleados------------------");
		for(Empleado e : empleados) {
			System.out.println(e);
		}
		System.out.println("---------------------------------------------");
	}
	
	
	public String solicitarOpcion() {
		System.out.print("Ingrese la opcion: ");
		return this.sc.nextLine();
	}
	
	public int solicitarNumero() {
		System.out.print("Ingrese el numero del empleado: ");
		int numero = sc.nextInt();
		this.sc.nextLine();
		return numero;
		
	}
	
	public String solicitarNombre() {
		System.out.print("Ingrese el nombre del empleado: ");
		return this.sc.nextLine();
	}
	
	public double solicitarSaldo() {
		System.out.print("Ingrese el saldo del empleado: ");
		double saldo = this.sc.nextDouble();
		this.sc.nextLine();
		return saldo;
	}
	
	public <E> void mostrar(E obj) {
		System.out.println(obj);
	}
	
	public void closeScanner() {
		this.sc.close();
	}
	
}
