package experiencia_cuatro;

// Excepcion personalizada para saldo insuficiente
public class SaldoInsuficienteException extends Exception {
    private static final long serialVersionUID = 1L;  // Agregar serialVersionUID

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);  // Pasa el mensaje al constructor de Exception
    }
}
