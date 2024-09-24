package experiencia_cuatro;

// Clase que representa una cuenta bancaria
public class CuentaBancaria {
    private String numeroCuenta;  // Atributo para el numero de cuenta
    private String titular;       // Atributo para el titular de la cuenta
    private double saldo;         // Atributo para el saldo

    // Constructor de la clase
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        // Validacion para no permitir saldo inicial negativo
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.numeroCuenta = numeroCuenta;  // Asigna el numero de cuenta
        this.titular = titular;            // Asigna el nombre del titular
        this.saldo = saldoInicial;         // Asigna el saldo inicial
    }

    // Metodo para depositar dinero en la cuenta
    public void depositar(double monto) {
        // Verificar que el monto a depositar sea positivo
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero");
        }
        saldo += monto;  // Incrementa el saldo
    }

    // Metodo para retirar dinero de la cuenta
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        // Verificar que el monto a retirar sea positivo
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero");
        }
        // Verificar que haya suficiente saldo disponible
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la operacion");
        }
        saldo -= monto;  // Decrementa el saldo
    }

    // Metodo para consultar el saldo actual de la cuenta
    public double consultarSaldo() {
        return saldo;  // Devuelve el saldo actual
    }

    // Metodo para transferir dinero entre cuentas
    public void transferir(CuentaBancaria destino, double monto) 
            throws SaldoInsuficienteException, CuentaNoEncontradaException, LimiteCreditoExcedidoException {
        // Verificar que la cuenta destino no sea nula
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe");
        }
        // Intentar retirar el monto de la cuenta actual
        this.retirar(monto);
        // Si no hay excepciones, depositar en la cuenta destino
        destino.depositar(monto);
    }

    // Metodo para cerrar la cuenta si el saldo es cero
    public void cerrarCuenta() throws SaldoNoCeroException {
        // Verificar que el saldo sea cero para permitir cerrar la cuenta
        if (saldo != 0) {
            throw new SaldoNoCeroException("La cuenta no puede cerrarse, el saldo no es cero");
        }
        // Accion adicional para cerrar la cuenta (no implementado)
    }

    // Metodo para obtener el numero de cuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    // Metodo para obtener el titular de la cuenta
    public String getTitular() {
        return titular;
    }
}
