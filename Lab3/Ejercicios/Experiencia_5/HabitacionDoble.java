package experiencia_cinco;

public class HabitacionDoble extends Habitacion implements ServicioLimpieza {

    public HabitacionDoble(double precioPorNoche) {
        super("Doble", precioPorNoche);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza solicitada para la Habitación Doble.");
    }
}
