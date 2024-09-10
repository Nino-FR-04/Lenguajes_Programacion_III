package Lab2_1;

public class CuentaCorriente extends Cuenta{
	//Atributos
	private int retiros;
	
	//Constructor
	public CuentaCorriente(double si) {
		super(si);
		this.retiros = 0;
	}
	
	//Metodos sobreeescritos
	public void retirar(double cantidad) {
		final int LIBRE_RETIROS = 3;
		final double TARIFA_TRANSACCION = 3.5;
		super.retirar(cantidad);
		if(this.retiros > LIBRE_RETIROS) {
			super.retirar(TARIFA_TRANSACCION);
		}
	}
	public void consultar() {
		this.retiros = 0;
	}
	
	
}
