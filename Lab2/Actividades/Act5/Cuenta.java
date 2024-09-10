package Lab2_1;

public class Cuenta {
	//Atributos
	protected double saldo;
	
	//Constructor
	protected Cuenta(double saldo) {
		this.saldo = saldo;
	}
	
	//metodos
	public void depositar(double monto) {
		this.saldo += monto;
	}
	
	public void retirar(double monto) {
		if(monto > this.saldo) {
			System.out.println("Operación no valida");
		}else {
			this.saldo -= monto;
		}
	}
	
	public void consultar() {
		System.out.println("Saldo: " + this.saldo);
	}
	
	public double getSaldo() {return this.saldo;}
	
}
