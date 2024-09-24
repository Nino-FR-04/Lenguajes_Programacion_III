package ejercicio_tres;

// Clase Numero
public class Numero {
    private double valor;

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public static void main(String[] args) {
        Numero numero = new Numero();
        try {
            numero.setValor(-10); // Esto lanzará una excepción
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
