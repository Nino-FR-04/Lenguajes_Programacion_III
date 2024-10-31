package Ejercicio1;

import java.io.*;
import java.util.ArrayList;

public class Gestor {
    private ArrayList<Personaje> personajes;
    private String archivo;

    public Gestor() {
        this.archivo = "personajes.dat";
        personajes = new ArrayList<>();
        leerPersonajes();
    }

    // Añadir personaje
    public void agregarPersonaje(Personaje p) {
        if (buscarPersonaje(p.getNombre()) == null) {
            personajes.add(p);
            guardarPersonajes();
        } else {
            System.out.println("El personaje ya existe.");
        }
    }

    // Modificar un personaje existente
    public void modificarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        Personaje personaje = buscarPersonaje(nombre);
        if (personaje != null) {
        	personaje.setVida(vida);
        	personaje.setAtaque(ataque);
        	personaje.setDefensa(defensa);
        	personaje.setAlcance(alcance);
            guardarPersonajes();
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    //----------------------------------------------
    public void borrarPersonaje(String nombre) {
        Personaje personaje = buscarPersonaje(nombre);
        if (personaje != null) {
            personajes.remove(personaje);
            guardarPersonajes();
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    //------------------------------------------------
    public Personaje buscarPersonaje(String nombre) {
        for (Personaje personaje : personajes) {
            if (personaje.getNombre().equals(nombre)) {
                return personaje;
            }
        }
        return null;
    }

    //------------------------------------------------
    public void mostrarPersonajes() {
    	System.out.println("--------------------PERSONAJES--------------------");
        for (Personaje p : personajes) {
            System.out.println(p);
        }
        System.out.println("--------------------------------------------------");
    }

    //------------------------------------------------
    // Guardar los personajes
    private void guardarPersonajes() {
    	//Uso try with resources
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
        	//Guarda ArrayList de los personajes
            oos.writeObject(personajes);
        } catch (IOException e) {
            System.out.println("Error: Guardado de Personajes erroneo");
        }
    }
    
    //------------------------------------------------
    // Leer los personajes
    private void leerPersonajes() {
        File file = new File(archivo);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            	//Casting
                personajes = (ArrayList<Personaje>) ois.readObject();
            } catch (IOException e) {
            	System.out.println("Error al leer el archivo");
            } catch (ClassNotFoundException e) {
            	System.out.println("Error: Clase no encontrada");
            }
        }
    }

    
    
    //------------------EjercicioII - Nuevas Funcionalidades
    
    //-------------------FiltrarPorAtributo
    public void filtrarPorAtributo(String atributo) {
        for (int i = 0; i < personajes.size() - 1; i++) {
            for (int j = i + 1; j < personajes.size(); j++) {
                if (comparar(personajes.get(i), personajes.get(j), atributo)) {
                    Personaje temp = personajes.get(i);
                    personajes.set(i, personajes.get(j));
                    personajes.set(j, temp);
                }
            }
        }
        mostrarPersonajes();
    }

    
    //---------------Comparacion
    private boolean comparar(Personaje p1, Personaje p2, String atributo) {
        switch (atributo.toLowerCase()) {
            case "vida":
                return p1.getVida() > p2.getVida();
            case "ataque":
                return p1.getAtaque() > p2.getAtaque();
            case "defensa":
                return p1.getDefensa() > p2.getDefensa();
            case "alcance":
                return p1.getAlcance() > p2.getAlcance();
            default:
                return false;
        }
    }

    // EstadísticasGenerales
    public void mostrarEstadisticas() {
    	if(!this.personajes.isEmpty()) {
    		int VidaGeneral = 0;
    		int AtaqueGeneral = 0;
    		int DefensaGeneral = 0;
    		int AlcanceGeneral = 0;
    		
    		for(Personaje personaje : this.personajes) {
    			VidaGeneral += personaje.getVida();
    			AtaqueGeneral += personaje.getAtaque();
    			DefensaGeneral += personaje.getDefensa();
    			AlcanceGeneral += personaje.getAlcance();
    		}
    		
    		System.out.println("Total de personajes: " + this.personajes.size());
            System.out.println("Promedio de vida: " + (VidaGeneral/ this.personajes.size()));
            System.out.println("Promedio de ataque: " + (AtaqueGeneral / this.personajes.size()));
            System.out.println("Promedio de defensa: " + (DefensaGeneral / this.personajes.size()));
            System.out.println("Promedio de alcance: " + (AlcanceGeneral / this.personajes.size()));
    		
    	}else {
    		System.out.println("No hay personajes");
    	}
    }

}


