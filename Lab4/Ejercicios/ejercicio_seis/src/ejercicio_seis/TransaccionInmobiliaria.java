package ejercicio_seis;

// Clase TransaccionInmobiliaria
public class TransaccionInmobiliaria {
    private int id;
    private Propiedad propiedad;
    private double precioTransaccion;

    public TransaccionInmobiliaria(int id, Propiedad propiedad, double precioTransaccion) throws PrecioInferiorException {
        if (precioTransaccion < propiedad.getPrecio()) {
            throw new PrecioInferiorException("El precio de la transacción no puede ser menor que el precio de la propiedad");
        }
        this.id = id;
        this.propiedad = propiedad;
        this.precioTransaccion = precioTransaccion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public double getPrecioTransaccion() {
        return precioTransaccion;
    }
}
