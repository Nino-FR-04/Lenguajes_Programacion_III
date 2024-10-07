package Actividad2;

public class Pila <E>{
	//Atributos
	private int size;
	private int superior;
	private E[] elementos;
	
	//Constructor
	//---------------------------N1
	public Pila() {
		this(10);
	}
	
	//---------------------------N2
	@SuppressWarnings("unchecked")
	public Pila(int size) {
		this.size = (size > 0) ? size : 10;
		this.superior = -1; 
		this.elementos = ( E[] ) new Object[size];
	}
	
	public void push( E valorAMeter ) throws ExcepcionPilaLlena {
		if ( this.superior == this.size - 1 ) { 
			throw new ExcepcionPilaLlena( String.format(
					"La Pila esta llena, no se puede meter %s", valorAMeter));
		}
		this.elementos[ ++superior ] = valorAMeter; // mete valorAMeter enPila
	} 
	
	public E pop() throws ExcepcionPilaVacia{
		if ( superior == -1 )
			throw new ExcepcionPilaVacia( "Pila vacia, no se puede sacar");
		return elementos[ superior-- ];
		
	}
	
	public boolean contains(E obj) {
		/*Necesario sobrescribir el metodo equals si se crea
		una clase propia. Ejm: estudiante.*/
		
		for(int i=0;i<this.superior;i++) {
			if(this.elementos[i].equals(obj)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean esIgual(Pila<E> otraPila) {
		//Compara el tamaño de ambas pilas
		if(this.superior != otraPila.superior) {
			return false;
		}
		
		for(int i=0;i<this.superior;i++) {
			if(!this.elementos[i].equals(otraPila.elementos[i])) {
				return false;
			}
		}
		return true;
		
	}
	
	public void mostrarPila() {
		for( E elemento : this.elementos) {
			System.out.println(elemento);
		}
	}
	
	
}
