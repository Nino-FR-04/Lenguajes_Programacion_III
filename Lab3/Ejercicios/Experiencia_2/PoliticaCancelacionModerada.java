package experiencia_dos;

import java.util.Date;

// Politica de cancelacion moderada: permite cancelar hasta 72 horas antes con una penalizacion del 50%
public class PoliticaCancelacionModerada implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        Date ahora = new Date();
        long diferenciaEnMilis = reserva.getFechaEntrada().getTime() - ahora.getTime();
        // Si faltan más de 72 horas para el check-in, se permite cancelar
        return diferenciaEnMilis >= (72 * 60 * 60 * 1000);
    }
}
