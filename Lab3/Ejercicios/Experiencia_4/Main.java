package experiencia_cuatro;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Crear el hotel
        Hotel hotel = new Hotel();

        // Registrar habitaciones
        Habitacion hab1 = new HabitacionIndividual(50.0);
        Habitacion hab2 = new HabitacionDoble(80.0);
        Habitacion hab3 = new Suite(150.0);
        hotel.registrarHabitacion(hab1);
        hotel.registrarHabitacion(hab2);
        hotel.registrarHabitacion(hab3);

        // Registrar clientes
        Cliente cliente1 = new Cliente("Samuel", "samuel@gmail.com", "989234106");
        Cliente cliente2 = new Cliente("Aaron", "aaron@gmail.com", "944759306");
        Cliente cliente3 = new Cliente("Nino", "nino@gmail.com", "982842219");
        hotel.registrarCliente(cliente1);
        hotel.registrarCliente(cliente2);
        hotel.registrarCliente(cliente3);

        // Definir las fechas de entrada y salida usando LocalDateTime
        LocalDateTime fechaEntrada1 = LocalDateTime.now(); // Fecha y hora actual
        LocalDateTime fechaSalida1 = fechaEntrada1.plusDays(3); // +3 días

        // Realizar una reserva
        hotel.realizarReserva(hab1, cliente1, fechaEntrada1, fechaSalida1, new PoliticaCancelacionFlexible());

        // Solicitar servicios específicos
        if (hab3 instanceof ServicioLimpieza) {
            ((ServicioLimpieza) hab3).solicitarLimpieza();
        }

        if (hab3 instanceof ServicioComida) {
            ((ServicioComida) hab3).solicitarComida();
        }

        if (hab3 instanceof ServicioLavanderia) {
            ((ServicioLavanderia) hab3).solicitarLavanderia();
        }
    }
}
