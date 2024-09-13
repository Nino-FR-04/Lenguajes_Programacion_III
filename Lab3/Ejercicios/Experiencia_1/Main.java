package experiencia_uno;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear el hotel
        Hotel hotel = new Hotel();

        // Registrar habitaciones en el hotel
        Habitacion hab1 = new Habitacion("Individual", 50.0);
        Habitacion hab2 = new Habitacion("Doble", 80.0);
        Habitacion hab3 = new Habitacion("Suite", 150.0);
        hotel.registrarHabitacion(hab1);
        hotel.registrarHabitacion(hab2);
        hotel.registrarHabitacion(hab3);

        // Registrar clientes en el hotel
        Cliente cliente1 = new Cliente("Juan Perez", "jperez@gmail.com");
        Cliente cliente2 = new Cliente("Maria Lopez", "mlopez@gmail.com");
        hotel.registrarCliente(cliente1);
        hotel.registrarCliente(cliente2);

        // Realizar una reserva para cliente1
        Date fechaEntrada1 = new Date(); // Fecha actual
        Date fechaSalida1 = new Date(fechaEntrada1.getTime() + (1000 * 60 * 60 * 24 * 3)); // +3 dias
        hotel.realizarReserva(hab1, cliente1, fechaEntrada1, fechaSalida1);

        // Intentar reservar la misma habitacion nuevamente (habitacion ocupada)
        hotel.realizarReserva(hab1, cliente2, fechaEntrada1, fechaSalida1);

        // Realizar otra reserva para cliente2 en otra habitacion disponible
        hotel.realizarReserva(hab2, cliente2, fechaEntrada1, fechaSalida1);

        // Cancelar la primera reserva de cliente1
        hotel.cancelarReserva(hab1, cliente1);

        // Reservar la habitacion liberada por cliente1 para cliente2
        hotel.realizarReserva(hab1, cliente2, fechaEntrada1, fechaSalida1);
    }
}
