package ejercicio_uno;

// Excepciones Personalizadas
class ExcepcionVocal extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionVocal(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionNumero extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionNumero(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionBlanco extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionBlanco(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionSalida extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionSalida(String mensaje) {
        super(mensaje);
    }
}
