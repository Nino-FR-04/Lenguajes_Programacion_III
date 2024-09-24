package experiencia_cuatro;

//Excepcion personalizada para cuenta no encontrada
public class CuentaNoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;  // Agregar serialVersionUID

    public CuentaNoEncontradaException(String mensaje) {
        super(mensaje);  // Pasa el mensaje al constructor de Exception
    }
}
