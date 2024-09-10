package Lab2;

public class Persona {
	//Atributos
	private int id;
	private String nombre;
	private String apellido;
	private Cuenta cuenta;
	
	//Constructor
	public Persona(int id,String nombre, String apellido,int numero) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuenta = new Cuenta(numero);
	}
	
	//setters y getters
	
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Cuenta getCuenta() {
		return this.cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	//metodo
	public String toString() {
		return "ID: " + id + ", Nombre: " + nombre + " " + apellido + ", " + cuenta.toString();
	}
	
}
