package Actividad1_2;

public class Pedido {
	//Atributos
	private static int cont = 0;
	private int ID;
	private String nombre_Plato;
	private String tipo;
	
	//---------------Constructor
	public Pedido(String nombre,String tipo) {
		this.nombre_Plato = nombre;
		this.tipo = tipo;
		this.ID = Pedido.cont++;
	}
	
	//------------------Methods
	public String get_NombrePlato() {return this.nombre_Plato;}
	public String get_TipoPlato() {return this.tipo;}
	public int getID() {return this.ID;}
	
	public void set_NombrePlato(String nombre) {
		this.nombre_Plato = nombre;
	}
	
	public void set_TipoPlato(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return ("- ID: " + this.ID + 
				", Nombre: " + this.nombre_Plato + 
				", Tipo: " + this.tipo);
	}
	
}

