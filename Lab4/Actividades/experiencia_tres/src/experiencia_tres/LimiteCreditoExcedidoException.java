package experiencia_tres;

// Excepcion personalizada para limite de credito excedido
public class LimiteCreditoExcedidoException extends Exception {
    private static final long serialVersionUID = 1L;  // Agregar serialVersionUID

    // Constructor que recibe un mensaje de error
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);  // Llama al constructor de Exception con el mensaje
    }
}
