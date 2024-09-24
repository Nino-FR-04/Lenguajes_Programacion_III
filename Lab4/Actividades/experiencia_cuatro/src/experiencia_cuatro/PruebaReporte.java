package experiencia_cuatro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PruebaReporte {
    public static void main(String[] args) {
        List<CuentaBancaria> cuentas = new ArrayList<>();
        
        // Crear algunas cuentas bancarias para la prueba
        CuentaBancaria cuenta1 = new CuentaBancaria("001", "Juan Perez", 500.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("002", "Ana Gomez", 150.0);
        
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        
        // Instanciar clase ReporteTransacciones
        ReporteTransacciones reporte = new ReporteTransacciones();
        
        // Probar la generación de reportes
        try {
            reporte.generarReporte(cuentas, "reporte.txt");
        } catch (HistorialVacioException | IOException e) {
            System.out.println(e.getMessage());
        }

        // Probar la lectura de transacciones desde un archivo
        LecturaTransacciones lector = new LecturaTransacciones();
        lector.leerTransacciones("reporte.txt");
        
        // Probar con archivo inexistente
        lector.leerTransacciones("archivo_inexistente.txt");
    }
}
