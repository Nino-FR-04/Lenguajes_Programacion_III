package experiencia_cuatro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LecturaTransacciones {
    
    // Metodo para leer transacciones desde un archivo
    public void leerTransacciones(String archivo) {
        // Manejo de Scanner con try-with-resources para garantizar cierre del recurso
        try (Scanner scanner = new Scanner(new File(archivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado. " + e.getMessage());
        }
    }
}
