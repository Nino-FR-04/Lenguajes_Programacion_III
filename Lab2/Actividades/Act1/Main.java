package Lab2;

public class Main {
	public static void main(String[] args) {
		
		//Objetos
		Coche cocheDeportivo = new Coche();
		Coche CocheTodoTerreno = new Coche("Marca","Modelo",2009,1200);
	
		//Interaccion
		
		cocheDeportivo.encender();
		cocheDeportivo.acelerar();
		cocheDeportivo.frenar();
		
		CocheTodoTerreno.aplicarDescuento();
		CocheTodoTerreno.acelerar();
		
	}
}
