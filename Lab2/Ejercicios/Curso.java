package Ejercicio;

import java.util.ArrayList;

public class Curso {
	
	//Atributos
	private String nombre;
	private String cod;
	private Profesor profesor_aso;
	private ArrayList<Estudiante> Estudiantes;
	private boolean disponibilidad;
	
	//Constructor:
	public Curso(String n,String c,Profesor p) {
		this.nombre = n;
		this.cod = c;
		this.profesor_aso = p;
		this.Estudiantes = new ArrayList<>();
		this.disponibilidad = true;
	}
	
	//Metodos
	public String getNombre() {return this.nombre;}
	public String getCodigo() {return this.cod;}
	public Profesor getProfesor() {return this.profesor_aso;}
	
	public void setNombre(String n) {this.nombre = n;}
	public void setCodigo(String c) {this.cod = c;}
	public void setProfesor(Profesor p) {this.profesor_aso = p;}
	
	public ArrayList<Estudiante> getEstudiantes(){
		return this.Estudiantes;
	}
	
	public void setDisponibilidad(boolean d) {this.disponibilidad = d;}
	public boolean getDisponibilidad() {return this.disponibilidad;}
}
