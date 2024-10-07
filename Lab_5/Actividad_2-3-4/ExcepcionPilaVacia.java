package Actividad2;

public class ExcepcionPilaVacia extends Exception{
	private static final long serialVersionUID = 1L;
	public ExcepcionPilaVacia(String mensaje) {
		super(mensaje);
	}
}
