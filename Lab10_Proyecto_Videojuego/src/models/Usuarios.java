package models;

public class Usuarios {
	
	private String nombreUsuario;
	private int id_personaje;
	
	public Usuarios(String nombreUsuario,int idPersonaje) {
		this.nombreUsuario = nombreUsuario;
		this.id_personaje = idPersonaje;
	}
	
	public String getNombreUsuario() {return this.nombreUsuario;}
	public int getIDPersonaje() {return this.id_personaje;}	
	
	public void setIDPersonaje(int id) {this.id_personaje = id;} 
	
}
