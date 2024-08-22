public class Ejercicio1 {

    public static int suma_array(int[] arr){
        int suma = 0;
        for(int i = 0; i < arr.length; i++){
            suma += arr[i];
        }
        return suma;
    }
    //Funcion principal.
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Suma - elementos: " + suma_array(arr));

    }
}

