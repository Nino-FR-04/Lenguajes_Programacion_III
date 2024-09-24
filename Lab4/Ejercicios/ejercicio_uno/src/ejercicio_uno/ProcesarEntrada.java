package ejercicio_uno;

import java.io.IOException;

// Clase principal
public class ProcesarEntrada {
    private char caracter;
    private LeerEntrada entrada = new LeerEntrada();

    public void procesar() throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida, IOException {
        caracter = entrada.getChar();
        if (Character.isDigit(caracter)) {
            throw new ExcepcionNumero("Es un número");
        } else if (Character.isWhitespace(caracter)) {
            throw new ExcepcionBlanco("Es un espacio en blanco");
        } else if ("AEIOUaeiou".indexOf(caracter) != -1) {
            throw new ExcepcionVocal("Es una vocal");
        } else if (caracter == 'x' || caracter == 'X') {
            throw new ExcepcionSalida("Salida detectada");
        }
    }

    public static void main(String[] args) {
        ProcesarEntrada procesar = new ProcesarEntrada();
        while (true) {
            try {
                System.out.print("Ingrese un carácter: ");
                procesar.procesar();
            } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage() + ". Programa terminado.");
                break;
            } catch (IOException e) {
                System.out.println("Error de entrada/salida");
            }
        }
    }
}
