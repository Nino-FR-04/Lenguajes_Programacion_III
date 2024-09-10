package Lab2;

public class Cuenta {
	//Atributos
	private int numero;
	private double saldo;
	
	//Constructores
	public Cuenta(int numero,double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public Cuenta(int numero) {
		this(numero,0);
	}
	
	//setters y getters
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//Metodo
	public String toString() {
		return "Cuenta( " +
				"Numero: " + this.numero +
				" Saldo: " + this.saldo + ")";
	}
	
}
