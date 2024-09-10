package Lab2;

public class ContadorTest {
    public static void main(String[] args) {
        Contador c1, c2, c3;

        System.out.println("Número de contadores creados: " + Contador.getNContadores());
        System.out.println("Último contador creado: " + Contador.getUltimoContador()); 

        c1 = new Contador(3);
        c2 = new Contador(10);
        c3 = new Contador(); 

        System.out.println("Número de contadores creados: " + Contador.getNContadores()); 
        System.out.println("Último contador creado: " + Contador.getUltimoContador()); 

        c1.inc(); 
        c2.inc(); 

        System.out.println(c1.getValor()); 
        System.out.println(c2.getValor()); 
        System.out.println(c3.getValor()); 
        System.out.println("Acumulador total: " + Contador.acumulador()); 
    }
}

