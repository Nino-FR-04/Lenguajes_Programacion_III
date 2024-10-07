package Ejercicios;

public class Par <F,S> {
	//Atributos
	private F first;
	private S second;
	
	//Constructor
	public Par(F first, S second) {
		this.first = first;
		this.second = second;
	}
	
	//Methods
	public F getPrimero() {return this.first;}
	public S getSecond() {return this.second;}
	
	public void setPrimero(F first) {this.first = first;}
	public void setSegundo(S second) {this.second = second;}
	
	//-------------------Override
	@Override
	public String toString() {
		return "(Primero: " + this.first 
				+ ", Segundo: " + this.second + ")";
	}
	
	public boolean esIgual(Par<F,S> par) {
		return (this.first == par.first && 
				this.second == par.second);
	}
	
}
