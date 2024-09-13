package experiencia_cinco;

// Interfaz que define el método para determinar si se puede cancelar la reserva
public interface PoliticaCancelacion {
    // Metodo que verifica si una reserva puede ser cancelada segun la politica
    boolean puedeCancelar(Reserva reserva);
}
