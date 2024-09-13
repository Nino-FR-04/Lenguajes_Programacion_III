package experiencia_cinco;

import java.time.LocalDateTime;
import java.time.Duration;

// Politica de cancelacion moderada: permite cancelar hasta 72 horas antes con una penalizacion del 50%
public class PoliticaCancelacionModerada implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        LocalDateTime ahora = LocalDateTime.now();
        // Calcular la diferencia en horas entre la fecha actual y la fecha de entrada
        long diferenciaEnHoras = Duration.between(ahora, reserva.getFechaEntrada()).toHours();
        // Si faltan más de 72 horas para el check-in, se permite cancelar
        return diferenciaEnHoras >= 72;
    }
}
