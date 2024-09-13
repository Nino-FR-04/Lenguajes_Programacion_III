package experiencia_tres;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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

    // Metodo para realizar una reserva utilizando el GestorDisponibilidadHabitacion y seleccion de politica de cancelacion
    public void realizarReserva(Habitacion habitacion, Cliente cliente, Date fechaEntrada, Date fechaSalida, PoliticaCancelacion politicaCancelacion) {
        if (habitacion.verificarDisponibilidad(fechaEntrada, fechaSalida)) {
            Reserva reserva = new Reserva(habitacion, cliente, fechaEntrada, fechaSalida, politicaCancelacion);
            reservas.add(reserva);
            habitacion.getGestorDisponibilidad().registrarReserva(reserva);
            habitacion.setDisponible(false);
            System.out.println("Reserva realizada para el cliente: " + cliente.getNombre());
        } else {
            System.out.println("Habitacion no disponible en ese rango de fechas.");
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
        System.out.println("No se encontro la reserva para cancelar.");
    }
}
