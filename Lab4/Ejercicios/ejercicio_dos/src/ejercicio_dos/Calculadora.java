package ejercicio_dos;

//Clase Calculadora
public class Calculadora {
 public double sumar(double a, double b) {
     return a + b;
 }

 public double restar(double a, double b) {
     return a - b;
 }

 public double multiplicar(double a, double b) {
     return a * b;
 }

 public double dividir(double a, double b) throws DivisionPorCeroException {
     if (b == 0) {
         throw new DivisionPorCeroException("No se puede dividir por cero");
     }
     return a / b;
 }

 public static void main(String[] args) {
     Calculadora calculadora = new Calculadora();
     try {
         System.out.println("Suma: " + calculadora.sumar(10, 5));
         System.out.println("Resta: " + calculadora.restar(10, 5));
         System.out.println("Multiplicación: " + calculadora.multiplicar(10, 5));
         System.out.println("División: " + calculadora.dividir(10, 0)); // Esto lanzará una excepción
     } catch (DivisionPorCeroException e) {
         System.out.println(e.getMessage());
     } catch (IllegalArgumentException | ArithmeticException e) {
         System.out.println("Error matemático: " + e.getMessage());
     }
 }
}