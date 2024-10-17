package Actividad1_2;

import java.util.ArrayList;

public class HistorialPedidos {
	//Atributos
	ArrayList<Pedido> HistorialPedidos_CoE;
	
	//---Constructor
	public HistorialPedidos() {
		this.HistorialPedidos_CoE = new ArrayList<>();
	}
	
	//Agregar Pedido eliminado o completado
	public void agregarPedidohistorial(Pedido ped) {
		this.HistorialPedidos_CoE.add(ped);
	}
	
	//Obtener historial
	public ArrayList<Pedido> get_Historial(){
		return this.HistorialPedidos_CoE;
	}
	
}
