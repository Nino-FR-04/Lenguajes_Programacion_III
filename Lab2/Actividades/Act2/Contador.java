package Lab2;

public class Contador {
    static int acumulador = 0;
    final static int VALOR_INICIAL = 10;
    private int valor;
    
    // Variables de clase nuevas
    private static int nContadores = 0; 
    private static int ultimoContador = 0; 

    public static int acumulador() {
        return acumulador;
    }

    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;
        // Actualizar variables de clase
        nContadores++;
        ultimoContador = valor;
    }

    public Contador() {
        this(Contador.VALOR_INICIAL);
    }

    public void inc() {
        valor++;
        acumulador++;
    }

    public int getValor() {
        return this.valor;
    }

    // Métodos para obtener los nuevos valores
    public static int getNContadores() {
        return nContadores;
    }

    public static int getUltimoContador() {
        return ultimoContador;
    }
}
