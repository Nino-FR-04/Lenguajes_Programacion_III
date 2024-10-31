package Actividad5;

public class Persona {
	protected String nombre;
	protected String telefono;
	protected String direccion;
	
	public Persona(String nombre,String telefono,String direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	public String getNombre() {return this.nombre;}
	
	@Override
	public String toString() {
		return("Nombre: " + this.nombre +
				"\ntelefono: " + this.telefono +
				"\nDireccion: " + this.direccion);
	}
}
