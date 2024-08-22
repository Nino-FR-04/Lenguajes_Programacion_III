import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("Número " + (i + 1) + ": ");
                num = sc.nextInt();
            } else {
                do {
                    System.out.print("Número " + (i + 1) + ": ");
                    num = sc.nextInt();
                } while (num < arr[i - 1]);
            }

            arr[i] = num;
        }

        System.out.println("\nNúmeros ingresados:");
        for (int i : arr) {System.out.print(i + " ");}

        sc.close();
    }

}
