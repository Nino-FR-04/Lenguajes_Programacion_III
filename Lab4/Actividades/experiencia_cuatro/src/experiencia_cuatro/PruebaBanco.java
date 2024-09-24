package experiencia_cuatro;

public class PruebaBanco {
    public static void main(String[] args) {
        // Crear una cuenta bancaria normal
        CuentaBancaria cuenta1 = new CuentaBancaria("001", "Juan Perez", 500.0);

        // Crear una cuenta de credito con limite de 300
        CuentaCredito cuentaCredito = new CuentaCredito("003", "Carlos Ramirez", 200.0, 300.0);

        // Probar transferencias y retiros en una cuenta de credito
        try {
            System.out.println("Saldo de cuentaCredito antes del retiro: " + cuentaCredito.consultarSaldo());
            System.out.println("Limite de credito disponible: " + cuentaCredito.consultarLimiteCredito());

            // Probar un retiro dentro del limite de credito
            cuentaCredito.retirar(400);  // Retiro que usa parte del limite de credito
            System.out.println("Saldo despues del retiro: " + cuentaCredito.consultarSaldo());
            System.out.println("Limite de credito disponible: " + cuentaCredito.consultarLimiteCredito());

            // Probar un retiro que excede el limite de credito
            cuentaCredito.retirar(200);  // Esto debe lanzar una LimiteCreditoExcedidoException
        } catch (SaldoInsuficienteException | LimiteCreditoExcedidoException e) {
            System.out.println(e.getMessage());  // Captura la excepcion si excede el limite
        }

        // Probar una transferencia valida
        try {
            System.out.println("Saldo de cuenta1 antes de la transferencia: " + cuenta1.consultarSaldo());
            cuentaCredito.transferir(cuenta1, 100);  // Transferencia valida
            System.out.println("Saldo de cuenta1 despues de recibir la transferencia: " + cuenta1.consultarSaldo());
            System.out.println("Saldo de cuentaCredito despues de transferir: " + cuentaCredito.consultarSaldo());
            System.out.println("Limite de credito disponible: " + cuentaCredito.consultarLimiteCredito());
        } catch (SaldoInsuficienteException | LimiteCreditoExcedidoException | CuentaNoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }
}
