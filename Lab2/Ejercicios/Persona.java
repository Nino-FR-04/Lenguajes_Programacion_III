package Ejercicio;

public abstract class Persona {
	
	//Atributos
	
	protected String nombre;
	protected String apellido;
	protected int Dni;
	
	//Constructor
	public Persona(String n,String a,int dni) {
		this.nombre = n;
		this.apellido = a;
		this.Dni = dni;
	}
	
	//Metodos
	//--------------get y sets
	
	public String getNombre() {return this.nombre;}
	public String getApellido() {return this.apellido;}
	public int getDNI() {return this.Dni;}
	
	public void setNombre(String n) {this.nombre = n;}
	public void setApellido(String a) {this.apellido = a;}
	public void setDNI(int dni) {this.Dni = dni;}
	
	//----------------Metodo abstracto
	
	public abstract void mostrarInfo();
	
}
