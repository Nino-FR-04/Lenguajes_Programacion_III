import java.util.Scanner;

public class Ejercicio5 {
    public static double cargoHoras(int horas){

        if(horas==1){
            return 3.00;
        }else if(horas>1){
            double cargo = 3.00 + (horas-1)*0.50;
            return (cargo<12.00) ? cargo : 12.00;
        }else{
            return 0.00;
        }
    }
    //Funcion principal.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de horas: ");
        int horas = sc.nextInt();

        System.out.print("Cargo por " + horas + " horas: " + cargoHoras(horas));

        sc.close();
    }

}
