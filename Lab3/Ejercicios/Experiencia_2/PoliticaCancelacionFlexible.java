package experiencia_dos;

import java.util.Date;

// Politica de cancelacion flexible: permite cancelar hasta 24 horas antes del check-in sin penalizacion
public class PoliticaCancelacionFlexible implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        Date ahora = new Date();
        long diferenciaEnMilis = reserva.getFechaEntrada().getTime() - ahora.getTime();
        // Si faltan más de 24 horas para el check-in, se permite cancelar
        return diferenciaEnMilis >= (24 * 60 * 60 * 1000);
    }
}
