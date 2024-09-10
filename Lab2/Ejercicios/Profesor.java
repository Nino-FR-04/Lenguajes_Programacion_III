package Ejercicio;

import java.util.ArrayList;

public class Profesor extends Persona {
	//Atributos
	private int cod;
	private ArrayList<Curso> cursos_aso;
	
	//Constructor
	
	public Profesor(String n,String a,int dni,int cod) {
		super(n, a, dni);
		this.cod = cod;
		this.cursos_aso = new ArrayList<>();
	}
	
	//Metodos

	public int getCodigo() {return this.cod;}
	public void setCodigo(int codigo) {this.cod = codigo;}
	public ArrayList<Curso> getCursos_aso(){
		return this.cursos_aso;
	}
	
	
	@Override
	public void mostrarInfo() {
		System.out.println("Nombre: "+this.nombre + 
				"\nApellido: " + this.apellido +
				"\n Dni: " + this.Dni + 
				"\n Codigo de estudiante: " + this.cod);
		
		System.out.println("Cursos: ");
		
		for(Curso elemento : this.cursos_aso) {
			elemento.getNombre();
		}
		
	}
	
	
	
}
