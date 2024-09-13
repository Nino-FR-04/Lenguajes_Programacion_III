package experiencia_cinco;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas; // Lista de reservas de la habitación

    // Constructor que inicializa la lista de reservas
    public GestorDisponibilidadHabitacion() {
        this.reservas = new ArrayList<>();
    }

    // Método para verificar si la habitación está disponible en un rango de fechas
    public boolean estaDisponible(Habitacion habitacion, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion)) {
                // Verificar si las fechas de la reserva se superponen con el nuevo rango
                if (!(fechaSalida.isBefore(reserva.getFechaEntrada()) || fechaEntrada.isAfter(reserva.getFechaSalida()))) {
                    return false; // La habitación está reservada en ese rango
                }
            }
        }
        return true; // No hay conflicto, habitación disponible
    }

    // Método para registrar una reserva
    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva); // Añadir la reserva a la lista
    }

    // Método para cancelar una reserva
    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva); // Eliminar la reserva de la lista
    }
}
