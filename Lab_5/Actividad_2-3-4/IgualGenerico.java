package Actividad2;

public class IgualGenerico {
	//Metodo generico
	
	public static <E> boolean esIgualA(E obj1, E obj2) {
		//Si ambos son null devuelve "true"
		if(obj1 == null && obj2 == null) return true;
		
		//Si uno de ellos es null devuelve "false"
		if(obj1 == null || obj2 == null) return false;
		
		return obj1.equals(obj2);
	}
}
