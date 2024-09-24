package ejercicio_seis;

// Excepción personalizada para contrato inválido
class ContratoInvalidoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContratoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
