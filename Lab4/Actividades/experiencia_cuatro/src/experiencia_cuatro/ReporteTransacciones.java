package experiencia_cuatro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReporteTransacciones {
    
    // Metodo para generar el reporte de transacciones
    public void generarReporte(List<CuentaBancaria> cuentas, String archivo) 
            throws HistorialVacioException, IOException {
        // Verificar si la lista de cuentas esta vacia
        if (cuentas == null || cuentas.isEmpty()) {
            throw new HistorialVacioException("No se puede generar el reporte: no hay transacciones");
        }

        // Manejo de archivo con try-with-resources para garantizar cierre del recurso
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (CuentaBancaria cuenta : cuentas) {
                writer.write("Numero de Cuenta: " + cuenta.getNumeroCuenta() + "\n");
                writer.write("Titular: " + cuenta.getTitular() + "\n");
                writer.write("Saldo: " + cuenta.consultarSaldo() + "\n\n");
            }
            System.out.println("Reporte generado correctamente.");
        }
    }
}
