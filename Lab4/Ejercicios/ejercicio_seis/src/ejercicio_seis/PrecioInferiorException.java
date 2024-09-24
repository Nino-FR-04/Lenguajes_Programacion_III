package ejercicio_seis;

// Excepción personalizada para precio inferior
class PrecioInferiorException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrecioInferiorException(String mensaje) {
        super(mensaje);
    }
}
