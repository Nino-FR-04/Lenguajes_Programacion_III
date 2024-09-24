package ejercicio_seis;

// Clase ContratoAlquiler
public class ContratoAlquiler {
    private int duracionMeses;
    private double montoAlquiler;

    public ContratoAlquiler(int duracionMeses, double montoAlquiler) throws ContratoInvalidoException {
        if (duracionMeses <= 0) {
            throw new ContratoInvalidoException("La duración del contrato debe ser positiva");
        }
        if (montoAlquiler <= 0) {
            throw new ContratoInvalidoException("El monto del alquiler debe ser mayor a cero");
        }
        this.duracionMeses = duracionMeses;
        this.montoAlquiler = montoAlquiler;
    }

    // Getters
    public int getDuracionMeses() {
        return duracionMeses;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }
}
