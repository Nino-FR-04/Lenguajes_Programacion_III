package ejercicio4;
import javax.swing.*;
import java.io.*;
import java.util.HashMap;

public class Contador {

    public static void procesar(File archivo) throws IOException {
        //-----------------------------------------------------------
        int totaLineas = 0; 
        int totalPalabras = 0; 
        int totalCaracteres = 0; 
        HashMap<String, Integer> Frecuencias = new HashMap<>(); 

        //-----------------------------------------------------------
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
            	//-----------------------------------------------------------
            	totaLineas++; // contador de lineas
                String[] palabras = linea.split("\\s+"); // Divide la línea en palabras
                totalPalabras += palabras.length; 
                totalCaracteres += linea.length();

                for (String palabra : palabras) {
                    palabra = palabra.replaceAll("[\\.\\,\\(\\)]", "");
                    if (!palabra.isEmpty()) { 
                    	Frecuencias.put(palabra, Frecuencias.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        }

        //------------------------------------------------------------------------
        float prom = totaLineas > 0 ? (float) totalPalabras / totaLineas: 0;

        System.out.println("Total de líneas: " + totaLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres: " + totalCaracteres);
        System.out.println("Promedio de palabras por línea: " + prom);

        System.out.println("Frecuencia de palabras:");
        for (String palabra : Frecuencias.keySet()) {
            System.out.println(palabra + ": " + Frecuencias.get(palabra));
        }
    }

    public static void main(String[] args) {
    	//--------------------------------------------------------------
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de texto");

        //--------------------------------------------------------------
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile(); 
            try {
                procesar(archivo); 
            } catch (IOException e) {
                System.err.println("Error al procesar el archivo");
            }
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
