package ejercicio2;

import java.util.*;

class Producto {
    String nombre;
    double precio;

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}

interface EstrategiaDescuento {
    double calcularPrecio(List<Producto> productos);
}

class SinDescuento implements EstrategiaDescuento {
    public double calcularPrecio(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total += p.precio;
        }
        return total;
    }
}

class DescuentoFijo implements EstrategiaDescuento {
    public double calcularPrecio(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total += p.precio;
        }
        return total * 0.9; // 10% descuento
    }
}

class DescuentoPorcentual implements EstrategiaDescuento {
    public double calcularPrecio(List<Producto> productos) {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            Producto p1 = productos.get(i);
            boolean descuentoAplicado = false;

            for (int j = i + 1; j < productos.size(); j++) {
                Producto p2 = productos.get(j);
                if (p1.nombre.equals(p2.nombre) && !descuentoAplicado) {
                    total += p1.precio * 0.7; // 30% descuento
                    productos.remove(j);
                    descuentoAplicado = true;
                    break;
                }
            }

            if (!descuentoAplicado) {
                total += p1.precio;
            }
        }
        return total;
    }
}

class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    public double calcularPrecio(List<Producto> productos) {
        if (productos.size() < 3) {
            return new SinDescuento().calcularPrecio(productos);
        }

        Producto masBarato = productos.get(0);
        for (Producto p : productos) {
            if (p.precio < masBarato.precio) {
                masBarato = p;
            }
        }

        double total = 0;
        for (Producto p : productos) {
            total += p.precio;
        }
        total -= masBarato.precio * 0.5; // 50% descuento en el más barato
        return total;
    }
}

class CalculadoraDePrecios {
    EstrategiaDescuento estrategia;

    void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    double calcularPrecioFinal(List<Producto> productos) {
        return estrategia.calcularPrecio(productos);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto1", 100));
        productos.add(new Producto("Producto2", 200));
        productos.add(new Producto("Producto3", 50));
        productos.add(new Producto("Producto1", 100));

        while (true) {
        	//-----------Menu
            System.out.println("Seleccione una estrategia de descuento:");
            System.out.println("1. Sin Descuento");
            System.out.println("2. Descuento Fijo (10%)");
            System.out.println("3. Descuento Porcentual (30% para 2 productos iguales)");
            System.out.println("4. Descuento Porcentual Acumulado (50% en el producto más barato con 3 o más productos)");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    calculadora.setEstrategia(new SinDescuento());
                    break;
                case 2:
                    calculadora.setEstrategia(new DescuentoFijo());
                    break;
                case 3:
                    calculadora.setEstrategia(new DescuentoPorcentual());
                    break;
                case 4:
                    calculadora.setEstrategia(new DescuentoPorcentualAcumulado());
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida");
                    continue;
            }

            double total = calculadora.calcularPrecioFinal(productos);
            System.out.println("El precio final es: " + total);
        }
    }
}

