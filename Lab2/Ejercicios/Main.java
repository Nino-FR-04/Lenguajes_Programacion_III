package Ejercicio;

public class Main {
	public static void main(String[] args) {
		SistemaGestion sg = new SistemaGestion();
		
		//Alumnos
		Estudiante e1 = new Estudiante("Nino","Flores",1234,2023222281);
		Estudiante e2 = new Estudiante("Sofia","Diaz",4321,2023222291);
		Estudiante e3 = new Estudiante("Juan","Perez",1111,2023222271);
		
		//Profesores
		Profesor p1 = new Profesor("Nombre1","Apellido1",2222,4444);
		Profesor p2 = new Profesor("Nombre2","Apellido2",3333,5555);
		
		//Cursos
		Curso c1 = new Curso("Calculo Diferencial","123456789",p1);
		Curso c2 = new Curso("Calculo Integral","987654321",p1);
		Curso c3 = new Curso("Lenguajes de Programacion II","1122334455",p2);
		
		//Añadir curso
		sg.add_curso(c1);
		sg.add_curso(c2);
		sg.add_curso(c3);
		
		//Añadir Estudiante
		sg.add_estudiante(e1);
		sg.add_estudiante(e2);
		sg.add_estudiante(e3);
		
		//Añadir profesores
		sg.add_profesor(p1);
		sg.add_profesor(p2);
		
		//Añadir estudiante a un curso
		sg.add_est_curso(e2, c3);
		sg.add_est_curso(e1, c3);
		sg.add_est_curso(e3, c2);
		sg.add_est_curso(e3, c1);
		
		//Mostrar informacion - CURSO3
		System.out.println("Curso: " + c3.getNombre());
		for (int i=0;i<c3.getEstudiantes().size();i++) {
			c3.getEstudiantes().get(i).mostrarInfo();
		}
		
	}
}
