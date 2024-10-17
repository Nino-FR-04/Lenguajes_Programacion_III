package Actividad1_2;

public class Pedido {
	//Atributos
	private static int cont = 0;
	private int ID;
	private String nombre_Plato;
	private String tipo;
	//Atributo extra para saber el estado del pedido
	private boolean estado; //false si no esta completado y true si lo esta 
	
	//---------------Constructor
	public Pedido(String nombre,String tipo) {
		this.nombre_Plato = nombre;
		this.tipo = tipo;
		this.ID = Pedido.cont++;
		this.estado = false; // se asigna flase
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
	
	//--------------Actividad-Nro 3
	public boolean get_Estado() {return this.estado;}
	public void set_Estado(boolean estado) {
		this.estado = estado;
	}
	
	//---------------------------------------------
	
	@Override
	public String toString() {
		return ("- ID: " + this.ID + 
				", Nombre: " + this.nombre_Plato + 
				", Tipo: " + this.tipo + 
				", Estado: " + ((this.estado)?"Completado":"No completado"));
	}
	
}

