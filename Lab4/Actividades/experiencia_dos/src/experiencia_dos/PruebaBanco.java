package experiencia_dos;

public class PruebaBanco {
    public static void main(String[] args) {
        // Crear dos cuentas bancarias
        CuentaBancaria cuenta1 = new CuentaBancaria("001", "Juan Perez", 500.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("002", "Ana Garcia", 200.0);

        // Probar transferencias validas
        try {
            System.out.println("Saldo de cuenta1 antes de transferir: " + cuenta1.consultarSaldo());
            System.out.println("Saldo de cuenta2 antes de transferir: " + cuenta2.consultarSaldo());

            cuenta1.transferir(cuenta2, 100);

            System.out.println("Saldo de cuenta1 despues de transferir: " + cuenta1.consultarSaldo());
            System.out.println("Saldo de cuenta2 despues de recibir la transferencia: " + cuenta2.consultarSaldo());
        } catch (SaldoInsuficienteException | CuentaNoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        // Probar cierre de cuenta con saldo no cero
        try {
            cuenta1.cerrarCuenta();
        } catch (SaldoNoCeroException e) {
            System.out.println(e.getMessage());  // Espera un error porque el saldo no es cero
        }

        // Probar cierre de cuenta con saldo cero
        try {
            cuenta2.retirar(200);
            cuenta2.cerrarCuenta();
            System.out.println("Cuenta2 cerrada con exito.");
        } catch (SaldoNoCeroException | SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}
