package experiencia_cuatro;

import java.time.LocalDateTime;
import java.time.Duration;

// Politica de cancelacion flexible: permite cancelar hasta 24 horas antes del check-in sin penalizacion
public class PoliticaCancelacionFlexible implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        LocalDateTime ahora = LocalDateTime.now();
        // Calcular la diferencia en horas entre la fecha actual y la fecha de entrada
        long diferenciaEnHoras = Duration.between(ahora, reserva.getFechaEntrada()).toHours();
        // Si faltan más de 24 horas para el check-in, se permite cancelar
        return diferenciaEnHoras >= 24;
    }
}
