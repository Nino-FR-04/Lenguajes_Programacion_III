package Actividad1_2;

import java.util.ArrayList;

public class PedidoControlador {
	private PedidoModelo modelo;
	private PedidoVista vista;
	 
	//-----------------------Constructor
	public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	 
	//----------------Methods
	
	public void agregarPedido(String nombrePlato,String tipo) {
		if (!nombrePlato.isEmpty()) {
			this.modelo.add_pedido(new Pedido(nombrePlato,tipo));
			this.vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
		} else {
			this.vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
		}
	}
	
	public void mostrarPedidos() {
		ArrayList<Pedido> pedidos = this.modelo.get_ListaPedidos();
		this.vista.mostrarPedidos(pedidos);
	}
	
	public void eliminarPedido(int id) {
		if(this.modelo.get_ListaIDs().contains(id)) {
			String nombre = this.modelo.deletePedido(id);
			this.vista.mostrarMensaje("Producto eliminado - " + nombre );
		}else {
			this.vista.mostrarMensaje("Error: ID no encontrado");
		}
		
	}
	
	public void actualizarPedido(int id) {
		if(this.modelo.get_ListaIDs().contains(id)) {
			String nombre = this.vista.solicitar_Nombre();
			this.modelo.updatePedido(id, nombre);
			this.vista.mostrarMensaje("\nProducto Actualizado: " + nombre);
		}else {
			this.vista.mostrarMensaje("Error: ID no encontrado");
		}
	}
	
	public void buscarPedido(String atributo) {
		this.vista.mostrarPedidos(this.modelo.searchPedido(atributo));
	}
	
	public void contadorPedidosTipo(String tipo) {
		this.vista.mostrarMensaje("Pedidos " + tipo + " en total: " 
									+ this.modelo.contadorPedidos(tipo));
		
	}
	
	public void iniciar() {
		String opcion;
		
		do {
			this.vista.mostrarMenu();
			opcion = this.vista.solicitarOpcion();
			
			switch (opcion) {
				case "1":
					String nombrePlato = this.vista.solicitar_Nombre();
					String tipoPlato = this.vista.solicitar_Tipo();
					this.agregarPedido(nombrePlato,tipoPlato);
					break;
					
				case "2":
					mostrarPedidos();
					break;
					
				case "3":
					int id = this.vista.solicitarID();
					this.eliminarPedido(id);
					break;
					
				case "4":
					int id1 = this.vista.solicitarID();
					this.actualizarPedido(id1);
					break;
					
				case "5":
					String atributo = this.vista.solicitarAtributo();
					this.buscarPedido(atributo);
					break;
				
				case "6":
					this.vista.mostrarMensaje("Pedido en total: " + this.modelo.contadorPedidos());
					break;
					
				case "7":
					String tipo = this.vista.solicitar_Tipo();
					this.contadorPedidosTipo(tipo);
					break;
				
				case "8":
					this.vista.mostrarMensaje("------------Saliendo------------");
					break;
					
				default:
					this.vista.mostrarMensaje("\nOpción no válida. Inténtalo de nuevo.");
			}
		}while(!opcion.equals("8"));
		
		this.vista.cerrarScanner();
	}
}

