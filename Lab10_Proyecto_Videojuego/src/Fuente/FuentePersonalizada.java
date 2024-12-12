package Fuente;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FuentePersonalizada {
	
    // Método para cargar la fuente desde un archivo y ajustar su tamaño
	public static Font cargarFuente(float tamaño) {
        try {
            // Carga la fuente desde el archivo
            File archivoFuente = new File("Recursos\\FuenteJuego\\PressStart2P-Regular.ttf");
            if (!archivoFuente.exists()) {
                throw new IOException();
            }
            
            Font fuenteCargada = Font.createFont(Font.TRUETYPE_FONT, archivoFuente);
            // Ajusta el tamaño de la fuente
            return fuenteCargada.deriveFont(tamaño);
        //Verificacion de errores------------------
        } catch (IOException e) {
            // Si hay un error con el archivo
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (FontFormatException e) {
            // Si el formato de la fuente no es compatible
            System.out.println("Error de formato de fuente: " + e.getMessage());
        } catch (Exception e) {
            // Cualquier otro error
            System.out.println("Error al cargar la fuente: " + e.getMessage());
        }
        return new Font("SansSerif", Font.PLAIN, (int) tamaño);
	}
}