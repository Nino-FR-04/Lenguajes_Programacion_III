package Ejercicio3;

import java.util.ArrayList;

public class InventarioModel {
	//Atributo
	private ArrayList<Item> items;
	
	//------------Constructor
	public InventarioModel() {
		this.items = new ArrayList<>();
	}
	
	//Methods
	//---------------------------------------------------
	public void AgregarItem(Item item) {
		this.items.add(item);
	}
	
	//---------------------------------------------------
	public void EliminarItem(Item item) {
		this.items.remove(item);
	}
	
	//---------------------------------------------------
	public ArrayList<Item> ObtenerItems(){
		return this.items;
	}
	
	//---------------------------------------------------
	public Item BuscarItem(String nombre) {
		for(Item elemento : this.items) {
			if(elemento.getNombre().equals(nombre)) {
				return elemento;
			}
		}
		return null;
	}
}
