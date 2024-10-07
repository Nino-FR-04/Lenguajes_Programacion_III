package Actividad1;

public class InvalidSubscriptException extends ArrayIndexOutOfBoundsException{

	private static final long serialVersionUID = 1L;

	public InvalidSubscriptException(String mensaje) {
		super(mensaje);
	}
	
}