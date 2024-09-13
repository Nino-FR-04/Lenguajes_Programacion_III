package experiencia_uno;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;  // Asegúrate de importar la clase Date

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

    // Metodo para realizar una reserva utilizando el GestorDisponibilidadHabitacion
    public void realizarReserva(Habitacion habitacion, Cliente cliente, Date fechaEntrada, Date fechaSalida) {
        // Usamos el gestor de disponibilidad para verificar si la habitacion esta libre
        if (habitacion.verificarDisponibilidad(fechaEntrada, fechaSalida)) {
            Reserva reserva = new Reserva(habitacion, cliente, fechaEntrada, fechaSalida);
            reservas.add(reserva);
            habitacion.getGestorDisponibilidad().registrarReserva(reserva);
            habitacion.setDisponible(false);
            System.out.println("Reserva realizada para el cliente: " + cliente.getNombre());
        } else {
            System.out.println("Habitacion no disponible en ese rango de fechas.");
        }
    }

    public void cancelarReserva(Habitacion habitacion, Cliente cliente) {
        // Buscar la reserva
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) && reserva.getCliente().equals(cliente)) {
                reservas.remove(reserva);
                habitacion.getGestorDisponibilidad().cancelarReserva(reserva);
                habitacion.setDisponible(true);
                System.out.println("Reserva cancelada para el cliente: " + cliente.getNombre());
                return;
            }
        }
        System.out.println("No se encontro la reserva para cancelar.");
    }
}
