package experiencia_dos;

import java.util.Date;

public class Habitacion {
    private String tipo;
    private double precioPorNoche;
    private boolean disponible; // Usaremos este atributo para verificar disponibilidad general
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    // Constructor que inicializa los atributos
    public Habitacion(String tipo, double precioPorNoche) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true; // Por defecto, la habitacion esta disponible
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion(); // Inicializamos el gestor
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    // Metodo para verificar si la habitacion esta disponible, utilizando el atributo 'disponible'
    public boolean verificarDisponibilidad(Date fechaEntrada, Date fechaSalida) {
        // Si disponible es false, la habitacion no esta disponible, sin importar las fechas
        if (!disponible) {
            return false;
        }
        // Si esta disponible, verificamos las fechas con el gestor de disponibilidad
        return gestorDisponibilidad.estaDisponible(this, fechaEntrada, fechaSalida);
    }

    // Metodo para cambiar el estado de la habitacion (disponible u ocupada)
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Getter del gestor de disponibilidad
    public GestorDisponibilidadHabitacion getGestorDisponibilidad() {
        return gestorDisponibilidad;
    }
}
