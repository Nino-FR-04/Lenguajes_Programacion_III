package ejercicio_cinco;

import java.util.ArrayList;
import java.util.NoSuchElementException; // Importar NoSuchElementException

// Clase GestorContactos
public class GestorContactos {
    private ArrayList<Contacto> contactos = new ArrayList<>();

    // Método para agregar un nuevo contacto
    public void agregarContacto(Contacto contacto) {
        if (contacto == null) {
            throw new IllegalArgumentException("El contacto no puede ser nulo");
        }
        contactos.add(contacto);
    }

    // Método para modificar un contacto existente
    public void modificarContacto(String nombre, Contacto nuevoContacto) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(nombre)) {
                contactos.set(i, nuevoContacto);
                return;
            }
        }
        throw new NoSuchElementException("Contacto no encontrado");
    }

    // Método para eliminar un contacto por su nombre
    public void eliminarContacto(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(nombre)) {
                contactos.remove(i);
                return;
            }
        }
        throw new NoSuchElementException("Contacto no encontrado");
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        GestorContactos gestor = new GestorContactos();
        Contacto contacto = new Contacto("Carlos", "123456789", "carlos@example.com");

        try {
            // Agregar contacto
            gestor.agregarContacto(contacto);
            System.out.println("Contacto agregado: " + contacto.getNombre());

            // Modificar contacto
            gestor.modificarContacto("Carlos", new Contacto("Carlos", "987654321", "carlos_new@example.com"));
            System.out.println("Contacto modificado");

            // Eliminar contacto
            gestor.eliminarContacto("Carlos");
            System.out.println("Contacto eliminado");

        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
