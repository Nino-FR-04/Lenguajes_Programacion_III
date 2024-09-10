package Ejercicio;

import java.util.ArrayList;

public class SistemaGestion {
	
	//Lista general de los objetos
	private ArrayList<Curso> cursos;
	private ArrayList<Estudiante> estudiantes;
	private ArrayList<Profesor> profesores;
	
	//Constructor
	public SistemaGestion() {
		this.cursos = new ArrayList<>();
		this.estudiantes = new ArrayList<>();
		this.profesores = new ArrayList<>();
	}
	
	//Metodos:
	
	public void add_estudiante(Estudiante est) {
		estudiantes.add(est);
	}
	public void add_profesor(Profesor prof) {
		profesores.add(prof);
	}
	public void add_curso(Curso curso) {
		cursos.add(curso);
	}
	
	public void add_est_curso(Estudiante est,Curso curso) {
		if(curso.getDisponibilidad()) {
			curso.getEstudiantes().add(est);
		}else {
			System.out.println("Curso no Disponible");
		}
	}	
}
