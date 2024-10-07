package Actividad2;

public class ExcepcionPilaLlena extends Exception{

	private static final long serialVersionUID = 1L;
	public ExcepcionPilaLlena(String mensaje) {
		super(mensaje);
	}
}
