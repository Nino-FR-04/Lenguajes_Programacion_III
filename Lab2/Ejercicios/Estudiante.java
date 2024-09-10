package Ejercicio;

public class Estudiante extends Persona{
	
	//Atributos
	private static int total_est = 0;
	private final int cod_est;
	
	public Estudiante(String n,String a,int dni,int cod) {
		super(n,a,dni);
		this.cod_est = cod;
		Estudiante.total_est ++;
	}
	
	//Metodo implementado
	@Override
	public void mostrarInfo() {
		System.out.println("Nombre: "+this.nombre + 
				"\nApellido: " + this.apellido +
				"\n Dni: " + this.Dni + 
				"\n Codigo de estudiante: " + this.cod_est);
	}
	
	//Metodos
	public static int getEstudiantes() {return Estudiante.total_est;}
	
	
	
}
