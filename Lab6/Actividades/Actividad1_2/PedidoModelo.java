package Actividad1_2;

import java.util.ArrayList;

public class PedidoModelo {
	//Atributo - Representa la lista de pedidos
	private ArrayList<Pedido> lista_pedidos;
	private ArrayList<Integer> ids;
	
	//Constructor
	public PedidoModelo() {
		this.lista_pedidos = new ArrayList<>();
		this.ids = new ArrayList<>();
	}
	
	//--------------Methods
	public void add_pedido(Pedido ped) {
		this.lista_pedidos.add(ped);
		this.ids.add(ped.getID());
	}
	
	public String deletePedido(int id) {
		//Remueve un elemento de acuerdo a un ID dado
		String nombre;
		Integer idEliminar = id;
		
		for(Pedido pedido : this.lista_pedidos) {
			if(pedido.getID() == id) {
				nombre = pedido.get_NombrePlato();
				this.lista_pedidos.remove(pedido);
				this.ids.remove(idEliminar);
				return nombre;
			}
		}
		return null;
	}
	
	public void updatePedido(int id, String nombre) {
		for(Pedido pedido : this.lista_pedidos) {
			if(pedido.getID() == id) {
				pedido.set_NombrePlato(nombre);
				break;
			}
		}
	}
	
	public ArrayList<Pedido> searchPedido(String atributo) {
		
		//Lista de pedidos con atributos similares
		ArrayList<Pedido> list_aux = new ArrayList<>();
		
		for(Pedido pedido : this.lista_pedidos) {
			if(pedido.get_NombrePlato().equals(atributo) || pedido.get_TipoPlato().equals(atributo)) {
				list_aux.add(pedido);
			}
		}
		
		//retorna la lista con atributos similares
		return list_aux;
	}
	
	public int contadorPedidos() {
		return this.lista_pedidos.size();
	}
	
	public int contadorPedidos(String tipo) {
		
		int cont = 0;
		
		for(Pedido pedido : this.lista_pedidos) {
			if(pedido.get_TipoPlato().equals(tipo)) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public ArrayList<Pedido> get_ListaPedidos(){
		return this.lista_pedidos;
	}
	
	public ArrayList<Integer> get_ListaIDs(){
		return this.ids;
	}
	
}