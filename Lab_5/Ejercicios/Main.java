package Ejercicios;

public class Main {
	
	//Generic Method
	public static <F,S> void imprimirPar(Par<F,S> par) {
		//----------System.out.println(par.toString());
		System.out.println(par);
	}
	
	public static void main(String[] args) {
		//----------------Test
		Par<String,Boolean> par = new Par<>("Hola",true);
		imprimirPar(par);
		
		Par<PersonaPrueba,Integer> par1 = new Par<>(new PersonaPrueba("Nino","Flores"),19);
		imprimirPar(par1);
		
		imprimirPar(new Par<>("Hola2",12));
		
		
		//----------------------------------------------------------------------------
		Contenedor<String,Integer> cont = new Contenedor<>();
		cont.agregarPar("Palabra1", 1);
		cont.agregarPar("Palabra2", 2);
		cont.agregarPar("Palabra3", 3);
		
		cont.mostrarPares();
		cont.obtenerPar(50);
		
		cont.obtenerPar(3);
		
		System.out.println(cont.obtenerPar(0).esIgual(cont.obtenerPar(1)));
		
		
	}
}
