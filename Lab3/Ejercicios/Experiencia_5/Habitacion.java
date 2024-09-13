package experiencia_cinco;

import java.time.LocalDateTime;

public class Habitacion {
    protected String tipo;
    protected double precioPorNoche;
    protected boolean disponible;
    protected GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(String tipo, double precioPorNoche) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion();
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    // Cambiar LocalDate a LocalDateTime para ser consistente con el resto del código
    public boolean verificarDisponibilidad(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        if (!disponible) {
            return false;
        }
        return gestorDisponibilidad.estaDisponible(this, fechaEntrada, fechaSalida);
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public GestorDisponibilidadHabitacion getGestorDisponibilidad() {
        return gestorDisponibilidad;
    }
}
