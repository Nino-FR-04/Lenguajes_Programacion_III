package actividades;

//Strategy Pattern: Promociones de Productos
interface EstrategiaPromocion {
	double aplicarPromocion(double precio);
}

class PromocionDescuentoFijo implements EstrategiaPromocion {
	@Override
	public double aplicarPromocion(double precio) {
		return precio - 10;
	}
}

class PromocionPorcentaje implements EstrategiaPromocion {
	@Override
	public double aplicarPromocion(double precio) {
		return precio * 0.9;
	}
}

class PromocionSinDescuento implements EstrategiaPromocion {
	@Override
	public double aplicarPromocion(double precio) {
		return precio;
	}
}

class CalculadoraPromociones {
	private EstrategiaPromocion estrategia;

	public void setEstrategia(EstrategiaPromocion estrategia) {
		this.estrategia = estrategia;
	}

	public double calcularPrecio(double precio) {
		return estrategia.aplicarPromocion(precio);
	}
}

public class Actividad2 {
    public static void main(String[] args) {
        CalculadoraPromociones calculadora = new CalculadoraPromociones();
        calculadora.setEstrategia(new PromocionDescuentoFijo());
        System.out.println("Precio final con descuento fijo: " + calculadora.calcularPrecio(100));
        calculadora.setEstrategia(new PromocionPorcentaje());
        System.out.println("Precio final con descuento porcentual: " + calculadora.calcularPrecio(50));
    }
}