package Actividad1_2;

import java.util.Scanner;
import java.util.ArrayList;

public class PedidoVista {
	//Atributo - permite la captura de datos
	private Scanner sc;
	
	//----------Constructor
	public PedidoVista() {
		this.sc = new Scanner(System.in);
	}
	
	//Methods
	//----------------------
	public String solicitar_Nombre() {
		System.out.print("Ingrese el nombre del plato: ");
		return this.sc.nextLine();
	}
	
	public String solicitar_Tipo() {
		System.out.print("Ingrese el tipo del plato: ");
		return this.sc.nextLine();
	}
	
	//------------------------------------
	public void mostrarPedidos(ArrayList<Pedido> pedidos) {
		if (pedidos.isEmpty()) {
			System.out.println("No hay pedidos en la lista.");
		} else {
			System.out.println("Lista de Pedidos:");
			for (Pedido pedido : pedidos) {
				System.out.println(pedido);
			}
		}
	}
	
	//-----------------------------------------------------
	public void mostrarMenu() {
		 System.out.println("\nOpciones:");
		 System.out.println("1. Agregar Pedido");
		 System.out.println("2. Mostrar Pedidos");
		 System.out.println("3. Eliminar Pedido(ID)");
		 System.out.println("4. Actualizar Pedido(ID)");
		 System.out.println("5. Buscar Pedido(Nombre o Tipo)");
		 System.out.println("6. Contar Pedidos");
		 System.out.println("7. Contar Pedidos(Tipo)");
		 System.out.println("8. Salir");
	}
	
	//------------------------------------------------------
	public String solicitarOpcion() {
		System.out.print("Selecciona una opción: ");
		return sc.nextLine();
	}
	
	public String solicitarAtributo() {
		System.out.print("Ingrese el nombre o tipo del plato: ");
		return sc.nextLine();
	}
	
	public String solicitarTipo() {
		System.out.print("Ingrese el tipo: ");
		return sc.nextLine();
	}
	
	public int solicitarID() {
		System.out.print("Ingrese el ID: ");
		return sc.nextInt();
	}
	
	//------------------------------------------------------
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	//------------------------------------------------------
	public void cerrarScanner() {
		sc.close();
	}
}

