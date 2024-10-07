package Ejercicios;

public class PersonaPrueba {
	//Atributos
	private String nombre;
	private String apellido;
	
	//-------Constructor
	public PersonaPrueba(String nombre,String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	//----------Methods
	@Override
	public String toString() {
		return ("Nombre(" + this.nombre + 
				") - Apellido(" + this.apellido + ")");
	}
	
}
