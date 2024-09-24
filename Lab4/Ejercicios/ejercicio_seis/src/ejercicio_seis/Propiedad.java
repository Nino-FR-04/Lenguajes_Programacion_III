package ejercicio_seis;

// Clase Propiedad
public class Propiedad {
    private String direccion;
    private double precio;
    private double tamaño;

    public Propiedad(String direccion, double precio, double tamaño) throws DatosInvalidosException {
        if (precio <= 0 || tamaño <= 0) {
            throw new DatosInvalidosException("El precio y el tamaño deben ser positivos");
        }
        this.direccion = direccion;
        this.precio = precio;
        this.tamaño = tamaño;
    }

    // Getters
    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTamaño() {
        return tamaño;
    }
}
