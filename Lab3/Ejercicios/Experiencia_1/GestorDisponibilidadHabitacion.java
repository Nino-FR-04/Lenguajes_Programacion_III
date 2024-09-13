package experiencia_uno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas; // Lista de reservas de la habitacion

    // Constructor que inicializa la lista de reservas
    public GestorDisponibilidadHabitacion() {
        this.reservas = new ArrayList<>();
    }

    // Metodo para verificar si la habitacion esta disponible en un rango de fechas
    public boolean estaDisponible(Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion)) {
                // Verificar si las fechas de la reserva se superponen con el nuevo rango
                if (!(fechaSalida.before(reserva.getFechaEntrada()) || fechaEntrada.after(reserva.getFechaSalida()))) {
                    return false; // La habitacion esta reservada en ese rango
                }
            }
        }
        return true; // No hay conflicto, habitacion disponible
    }

    // Metodo para registrar una reserva
    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva); // Añadir la reserva a la lista
    }

    // Metodo para cancelar una reserva
    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva); // Eliminar la reserva de la lista
    }

    // Metodo para generar un informe de ocupacion de la habitacion
    public void generarInformeOcupacion(Habitacion habitacion) {
        System.out.println("Informe de ocupacion para la habitacion " + habitacion.getTipo());
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion)) {
                System.out.println("Ocupada desde " + reserva.getFechaEntrada() + " hasta " + reserva.getFechaSalida());
            }
        }
    }
}
