import java.util.Scanner;

public class Ejercicio6 {
    //Funcion principal.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Horas: ");
        int horas = sc.nextInt();

        System.out.print("Minutos: ");
        int minutos = sc.nextInt();

        System.out.print("Segundos: ");
        int segundos = sc.nextInt();
        
        //Calculo de la cantidad de segundos.
        int totalSegundos = horas * 3600 + minutos * 60 + segundos;
        System.out.println("Total de segundos: " + totalSegundos);

        sc.close();
    }

}
