package experiencia_tres;

//Excepcion personalizada para saldo no cero al cerrar cuenta
public class SaldoNoCeroException extends Exception {
    private static final long serialVersionUID = 1L;  // Agregar serialVersionUID

    public SaldoNoCeroException(String mensaje) {
        super(mensaje);  // Pasa el mensaje al constructor de Exception
    }
}
