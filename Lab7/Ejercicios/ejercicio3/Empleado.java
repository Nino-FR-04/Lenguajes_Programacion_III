package ejercicio3;

public class Empleado {
	//-------------------
	private int numero;
	private String nombre;
	private double saldo;
	
	//-------Constructor
	public Empleado(int numero,String nombre,double saldo) {
		setNumero(numero);
		setNombre(nombre);
		setSaldo(saldo);
	}
	
	//---------Getters y setters
	public int getNumero() {return this.numero;}
	public String getNombre() {return this.nombre;}
	public double getSaldo() {return this.saldo;}
	
	public void setNumero(int numero) {
		if(numero < 0) {
			throw new IllegalArgumentException();
		}
		this.numero = numero;
	}
	public void setNombre(String nombre) {
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.nombre = nombre;
	}
	
	public void setSaldo(double saldo) {
		if(saldo < 0) {
			throw new IllegalArgumentException();
		}		
		this.saldo = saldo;
	}
	
	//------ToString
	@Override
	public String toString() {
		return ("Empleado[Numero: " + this.numero +
				", Nombre: " + this.nombre + 
				", Saldo: " + this.saldo + "]");
	}
}
