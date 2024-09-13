package experiencia_cuatro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private List<Cliente> clientes;

    public Hotel() {
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void registrarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para realizar una reserva utilizando el GestorDisponibilidadHabitacion y selección de política de cancelación
    public void realizarReserva(Habitacion habitacion, Cliente cliente, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, PoliticaCancelacion politicaCancelacion) {
        if (habitacion.verificarDisponibilidad(fechaEntrada, fechaSalida)) {
            Reserva reserva = new Reserva(habitacion, cliente, fechaEntrada, fechaSalida, politicaCancelacion);
            reservas.add(reserva);
            habitacion.getGestorDisponibilidad().registrarReserva(reserva);
            habitacion.setDisponible(false);
            System.out.println("Reserva realizada para el cliente: " + cliente.getNombre());
        } else {
            System.out.println("Habitación no disponible en ese rango de fechas.");
        }
    }

    public void cancelarReserva(Habitacion habitacion, Cliente cliente) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) && reserva.getCliente().equals(cliente)) {
                if (reserva.cancelar()) {
                    reservas.remove(reserva);
                    habitacion.getGestorDisponibilidad().cancelarReserva(reserva);
                    habitacion.setDisponible(true);
                }
                return;
            }
        }
        System.out.println("No se encontró la reserva para cancelar.");
    }
}
