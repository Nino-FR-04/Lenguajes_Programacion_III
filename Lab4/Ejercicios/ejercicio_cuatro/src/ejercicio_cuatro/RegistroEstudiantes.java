package ejercicio_cuatro;

import java.util.ArrayList;
import java.util.NoSuchElementException;

// Clase RegistroEstudiantes
public class RegistroEstudiantes {
    private ArrayList<String> estudiantes = new ArrayList<>();

    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        estudiantes.add(nombre);
    }

    public boolean buscarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (!estudiantes.contains(nombre)) {
            throw new NoSuchElementException("Estudiante no encontrado");
        }
        return estudiantes.contains(nombre);
    }

    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();
        try {
            registro.agregarEstudiante("Juan Pérez");
            registro.agregarEstudiante(""); // Esto lanzará una excepción
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            registro.buscarEstudiante("Ana López"); // Esto lanzará una excepción
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
