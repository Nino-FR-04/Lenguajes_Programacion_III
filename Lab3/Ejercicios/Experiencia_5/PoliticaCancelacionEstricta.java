package experiencia_cinco;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        // La política estricta no permite cancelaciones
        return false;
    }
}
