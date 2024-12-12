package ejercicios;

public class ProductoModelo {
	//--------Atributos
	private String nombre;
	private double precio;
	private int stock;
	//Se puede manejar las categorias con clases
	private String categoria;
	
	//--Constructor
	public ProductoModelo(String nombre,double precio,int stock,String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}
	
	//Constructor por defecto
	public ProductoModelo() {
		this.nombre = "Nombre por Defecto";
		this.precio = 0.0;
		this.stock = 0;
		this.categoria = "Por defecto";
	}
	
	//Setters y getters
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setPrecio(double precio) {this.precio = precio;}
	public void setStock(int stock) {this.stock = stock;}
	public void setCategoria(String categoria) {this.categoria = categoria;}
	
	public String getNombre() {return this.nombre;}
	public double getPrecio() {return this.precio;}
	public int getStock() {return this.stock;}
	public String getCategoria() {return this.categoria;}
	
	//Mostrar Actualizacion del modelo en consola
	@Override
	public String toString() {
		return (
				"\nNombre: " + this.nombre +
				"\nPrecio: " + this.precio +
				"\nStock: " + this.stock +
				"\nCategoria: " + this.categoria
				);
	}
}
