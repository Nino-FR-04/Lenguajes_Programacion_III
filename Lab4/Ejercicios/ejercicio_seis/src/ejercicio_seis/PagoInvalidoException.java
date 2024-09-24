package ejercicio_seis;

// Excepción personalizada para pago inválido
class PagoInvalidoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PagoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
