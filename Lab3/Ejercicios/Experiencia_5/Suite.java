package experiencia_cinco;

// La clase Suite puede tener los tres servicios
public class Suite extends Habitacion implements ServicioLimpieza, ServicioComida, ServicioLavanderia {

    public Suite(double precioPorNoche) {
        super("Suite", precioPorNoche);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza solicitada para la Suite.");
    }

    @Override
    public void solicitarComida() {
        System.out.println("Comida solicitada para la Suite.");
    }

    @Override
    public void solicitarLavanderia() {
        System.out.println("Lavandería solicitada para la Suite.");
    }
}
