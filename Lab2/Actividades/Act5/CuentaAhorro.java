package Lab2_1;

public class CuentaAhorro extends Cuenta{
	//Atributos
	private double tasaInteres;
	private double minSaldo;
	
	//Constructor
	public CuentaAhorro(double ms,double ti) {
		super(0);
		this.tasaInteres = ti;
		this.minSaldo = ms;
	}
	
	//Metodos
	public void setTasaInteres(double interes) {
		this.tasaInteres = interes;
	}
	
	//Metodos sobreescritos
	@Override
	public void retirar(double cantidad) {
		super.retirar(cantidad);
		double saldo = getSaldo();
		if(saldo < this.minSaldo) {
			this.minSaldo = saldo;
		}
	}
	@Override
	public void consultar() {
		double interes = minSaldo * tasaInteres / 100;
		depositar(interes);
		this.minSaldo = getSaldo();
	}
	
}
