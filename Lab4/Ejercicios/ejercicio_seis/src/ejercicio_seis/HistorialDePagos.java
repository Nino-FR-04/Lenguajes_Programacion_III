package ejercicio_seis;

import java.time.LocalDate;

// Clase HistorialDePagos
public class HistorialDePagos {
    private LocalDate fechaPago;
    private double montoPago;

    public HistorialDePagos(LocalDate fechaPago, double montoPago) throws PagoInvalidoException {
        if (fechaPago.isAfter(LocalDate.now())) {
            throw new PagoInvalidoException("La fecha de pago no puede ser en el futuro");
        }
        if (montoPago <= 0) {
            throw new PagoInvalidoException("El monto de pago debe ser positivo");
        }
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
    }

    // Getters
    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }
}
