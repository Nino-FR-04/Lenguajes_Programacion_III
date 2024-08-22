public class Ejercicio4 {
    
    public static float menor(float n1,float n2,float n3){
        if(n1<n2 && n1<n3){
            return n1;
        }else if(n2<n3){
            return n2;
        }else{
            return n3;
        }
    }
    //Funcion principal.
    public static void main(String[] args) {
        
        //float num = 6.7f;
        float n1 = (float)5.5;
        float n2 = (float)7.7;
        float n3 = (float)9.9;

        System.out.print("Menor: " + menor(n1,n2,n3));
    }

}
