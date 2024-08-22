import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        Random rdm = new Random();
        int[] frecuencias = {0,0,0,0,0,0};
        
        for (int i = 0; i < 20000; i++) {
            frecuencias[rdm.nextInt(6)]++;
        }

        for (int i = 0; i < frecuencias.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencias[i]);
        }

    }

}
