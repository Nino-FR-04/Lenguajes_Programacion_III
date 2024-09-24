package experiencia_tres;

// Clase hija de CuentaBancaria que incluye limite de credito
public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;  // Atributo adicional para el limite de credito

    // Constructor de la clase
    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);  // Llama al constructor de la clase padre
        this.limiteCredito = limiteCredito;  // Asigna el limite de credito
    }

    // Metodo para retirar dinero, permitiendo el uso del limite de credito
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        double saldoDisponible = consultarSaldo();  // Obtener el saldo disponible en la cuenta

        // Verificar que el monto a retirar sea positivo
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero");
        }

        // Verificar que el monto no exceda el saldo disponible + limite de credito
        if (monto > saldoDisponible + limiteCredito) {
            throw new LimiteCreditoExcedidoException("Operacion rechazada: El monto excede el limite de credito disponible");
        }

        // Si el monto excede el saldo pero no el limite de credito, usa credito
        if (monto > saldoDisponible) {
            double usoCredito = monto - saldoDisponible;
            limiteCredito -= usoCredito;  // Reducir el limite de credito por el uso
            super.retirar(saldoDisponible);  // El saldo actual queda en 0, solo lo que hay disponible
        } else {
            super.retirar(monto);  // Retirar solo del saldo sin usar credito
        }
    }

    // Metodo para transferir dinero, permitiendo el uso del limite de credito
    @Override
    public void transferir(CuentaBancaria destino, double monto) 
            throws SaldoInsuficienteException, LimiteCreditoExcedidoException, CuentaNoEncontradaException {
        // Verificar que la cuenta destino no sea nula
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe");
        }

        // Intentar retirar el monto usando el limite de credito
        this.retirar(monto);

        // Si no hay excepciones, depositar en la cuenta destino
        destino.depositar(monto);
    }

    // Metodo para consultar el limite de credito disponible
    public double consultarLimiteCredito() {
        return limiteCredito;
    }
}
