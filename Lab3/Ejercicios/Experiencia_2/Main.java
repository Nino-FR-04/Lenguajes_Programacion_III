package experiencia_dos;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear el hotel
        Hotel hotel = new Hotel();

        // Registrar habitaciones
        Habitacion hab1 = new Habitacion("Individual", 50.0);
        Habitacion hab2 = new Habitacion("Doble", 80.0);
        Habitacion hab3 = new Habitacion("Suite", 150.0);
        hotel.registrarHabitacion(hab1);
        hotel.registrarHabitacion(hab2);
        hotel.registrarHabitacion(hab3);

        // Registrar clientes
        Cliente cliente1 = new Cliente("Juan Perez", "jperez@gmail.com");
        Cliente cliente2 = new Cliente("Maria Lopez", "mlopez@gmail.com");
        hotel.registrarCliente(cliente1);
        hotel.registrarCliente(cliente2);

        // Realizar una reserva con PoliticaCancelacionFlexible
        Date fechaEntrada1 = new Date(); // Fecha actual
        Date fechaSalida1 = new Date(fechaEntrada1.getTime() + (1000 * 60 * 60 * 24 * 3)); // +3 dias
        PoliticaCancelacion politicaFlexible = new PoliticaCancelacionFlexible();
        hotel.realizarReserva(hab1, cliente1, fechaEntrada1, fechaSalida1, politicaFlexible);

        // Intentar reservar la misma habitacion con PoliticaCancelacionEstricta
        PoliticaCancelacion politicaEstricta = new PoliticaCancelacionEstricta();
        hotel.realizarReserva(hab1, cliente2, fechaEntrada1, fechaSalida1, politicaEstricta);

        // Cancelar la primera reserva (PoliticaCancelacionFlexible permite cancelacion)
        hotel.cancelarReserva(hab1, cliente1);

        // Cancelar la segunda reserva (PoliticaCancelacionEstricta no permite cancelacion)
        hotel.cancelarReserva(hab1, cliente2);
    }
}
