package ejercicio_dos;

// Excepción personalizada para división por cero
class DivisionPorCeroException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}

