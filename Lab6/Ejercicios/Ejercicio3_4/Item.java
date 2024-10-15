package Ejercicio3;

public class Item {
	//Atributo
	private String nombre;
	private int cantidad;
	private String tipo; //Mejorar - Agregar clases????????
	private String descripcion;
	
	//---------------------Constructor
	public Item(String nombre,int cantidad,
			String tipo,String descripcion) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	//Methods
	//------------------------------------------------------
	
    public void usarItem() {
        if (this.cantidad > 0) {
            this.cantidad--;  
        }
    }
	
	//------------------------------------------------------
	public String getNombre() {return this.nombre;}
	public int getCantidad() {return this.cantidad;}
	public String getTipo() {return this.tipo;}
	public String getDescripcion() {return this.descripcion;}
	
}
