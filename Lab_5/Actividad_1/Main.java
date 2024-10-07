package Actividad1;

public class Main {
	
	//------------------Method 1
	public static <E> void imprimirArreglo(E[] arregloEntrada) {
	    // Iterar a través del arreglo y mostrar cada elemento
	    for (E elemento : arregloEntrada) {
	        System.out.print(elemento + " ");  
	    }
	    System.out.println();  
	}

	//------------------Method 2 - Sobrecarga
	public static <E> int imprimirArreglo(E[] arregloEntrada, int inferior, int superior) {
	    // Validar los índices
	    if (inferior < 0 || superior >= arregloEntrada.length || inferior >= superior) {
	        throw new InvalidSubscriptException("Índice no válido");
	    }

	    int cantidad_elementos = 0;
	    
	    for (int i = inferior; i <= superior; i++) {
	        System.out.print(arregloEntrada[i] + " ");
	        cantidad_elementos++;
	    }
	    System.out.println();

	    return cantidad_elementos;
	}
	

	
	
	public static void main(String[] args) {
			// crea arreglos de objetos Integer, Double y Character
			Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
			Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
			Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };
			
			int cant = imprimirArreglo(arregloInteger,0,1);
			System.out.println("Cantidad de elementos impresos: " + cant);
			
			cant = imprimirArreglo(arregloDouble,3,arregloDouble.length - 1);
			System.out.println("Cantidad de elementos impresos: " + cant);
			
			try {
				cant = imprimirArreglo(arregloCharacter,0,4);
				System.out.println("Cantidad de elementos impresos: " + cant);
			}catch(InvalidSubscriptException e) {
				System.out.println(e.getMessage());
			}	
			
	}
	
}
