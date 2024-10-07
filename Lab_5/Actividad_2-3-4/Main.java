package Actividad2;

public class Main {
	public static void main(String[] args) {
		Pila<Integer> StackEnteros = new Pila<>();
		Pila<Integer> StackEnteros2 = new Pila<>();
		
		try {
			for(int i=0;i<10;i++) {
				StackEnteros.push(i);
				StackEnteros2.push(i);
			}
			
			System.out.println("Stack 1 contiene 10: " + StackEnteros.contains(10));
			System.out.println("Stack 2 contiene 0: " + StackEnteros.contains(0));
		} catch (ExcepcionPilaLlena e) {
			e.printStackTrace();
		}
		
		//------------------Prueba IgualGenerico-------------------------
		
		Object o1 = new String ("Hola");
		Object o2 = "Hola";
		
		System.out.println("Son iguales: " + IgualGenerico.esIgualA(o1,o2));
		
		//------------------Metodo esIgual-------------------------
		
		System.out.println("Son iguales: " + StackEnteros.esIgual(StackEnteros2));
		
		try {
			System.out.println("El elemento eliminado es: " + StackEnteros.pop());
			System.out.println("Son iguales: " + StackEnteros.esIgual(StackEnteros2));
		} catch (ExcepcionPilaVacia e) {
			e.printStackTrace();
		}
		
		//Pruebas con Stack de Strings
		
		Pila<String> StringsPila = new Pila<>();
		Pila<String> StringsPila2 = new Pila<>(3);
		
		
		try {
			
			StringsPila.push("Hola");
			StringsPila.push("soy");
			StringsPila.push("nombre");
			
			StringsPila2.push("Hola");
			StringsPila2.push("soy");
			StringsPila2.push("nombre");
			
			System.out.println("Stack(String) 1 contiene soy: " + StringsPila.contains("soy"));
			System.out.println("Stack()String 2 contiene Hola: " + StringsPila.contains("Hola"));
			
			System.out.println("El elemento eliminado es: " + StringsPila.pop());
			
			System.out.println("Son iguales: " + StringsPila.esIgual(StringsPila2));
			
		} catch (ExcepcionPilaLlena e) {
			e.printStackTrace();
		}catch (ExcepcionPilaVacia e) {
			e.printStackTrace();
		}
		
	}
}
