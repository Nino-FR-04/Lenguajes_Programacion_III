package Ejercicio3;

import java.util.ArrayList;

public class InventarioView {
	//Methods
	//------------------------------------------------------------
	public void MostrarInventario(ArrayList<Item> items) {
		if(items.isEmpty()) {
			System.out.println("No hay items en el inventario");
		}else {
			System.out.println("------------------Inventario------------------");
			for(Item item : items) {
				System.out.println("- " + item.getNombre());
			}
		}
	}
	//------------------------------------------------------------
	public void MostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	
	
	//------------------------------------------------------------
	public void MostrarDetallesItem(Item item) {
		System.out.println("------------------Item------------------");
		System.out.println("Nombre: " + item.getNombre() + 
							"\nCantidad: " + item.getCantidad() +
							"\nTipo: " + item.getTipo() + 
							"\nDescripcion: " + item.getDescripcion()				
						);
		System.out.println("----------------------------------------");
	}
}
