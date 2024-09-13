package experiencia_tres;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear el hotel
        Hotel hotel = new Hotel();

        // Registrar habitaciones utilizando polimorfismo
        Habitacion hab1 = new HabitacionIndividual(50.0);
        Habitacion hab2 = new HabitacionDoble(80.0);
        Habitacion hab3 = new Suite(150.0);
        hotel.registrarHabitacion(hab1);
        hotel.registrarHabitacion(hab2);
        hotel.registrarHabitacion(hab3);

        // Registrar clientes con el nuevo atributo celular
        Cliente cliente1 = new Cliente("Samuel", "samuel@gmail.com", "989234106");
        Cliente cliente2 = new Cliente("Aaron", "aaron@gmail.com", "944759306");
        Cliente cliente3 = new Cliente("Nino", "nino@gmail.com", "982842219");
        hotel.registrarCliente(cliente1);
        hotel.registrarCliente(cliente2);
        hotel.registrarCliente(cliente3);

        // Realizar una reserva con PoliticaCancelacionFlexible para Samuel
        Date fechaEntrada1 = new Date(); // Fecha actual
        Date fechaSalida1 = new Date(fechaEntrada1.getTime() + (1000 * 60 * 60 * 24 * 3)); // +3 dias
        PoliticaCancelacion politicaFlexible = new PoliticaCancelacionFlexible();
        hotel.realizarReserva(hab1, cliente1, fechaEntrada1, fechaSalida1, politicaFlexible);

        // Intentar reservar la misma habitacion con PoliticaCancelacionEstricta para Aaron
        PoliticaCancelacion politicaEstricta = new PoliticaCancelacionEstricta();
        hotel.realizarReserva(hab1, cliente2, fechaEntrada1, fechaSalida1, politicaEstricta);

        // Realizar otra reserva con PoliticaCancelacionModerada para Nino
        Date fechaEntrada2 = new Date(fechaEntrada1.getTime() + (1000 * 60 * 60 * 24 * 7)); // +7 días
        Date fechaSalida2 = new Date(fechaEntrada2.getTime() + (1000 * 60 * 60 * 24 * 3)); // +3 días
        PoliticaCancelacion politicaModerada = new PoliticaCancelacionModerada();
        hotel.realizarReserva(hab2, cliente3, fechaEntrada2, fechaSalida2, politicaModerada);

        // Cancelar la primera reserva (Samuel)
        hotel.cancelarReserva(hab1, cliente1);

        // Cancelar la segunda reserva (Aaron)
        hotel.cancelarReserva(hab1, cliente2);
    }
}
