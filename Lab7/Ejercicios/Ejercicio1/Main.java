package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        //Agregando Personajes
        gestor.agregarPersonaje(new Personaje("Caballero", 4, 2, 4, 2));
        gestor.agregarPersonaje(new Personaje("Guerrero", 2, 4, 2, 4));
        gestor.agregarPersonaje(new Personaje("Arquero", 2, 4, 1, 8));

        // Mostrar todos los personajes
        gestor.mostrarPersonajes();
        
        //Modificar Personaje
        //---------Personaje no existente
        gestor.modificarPersonaje("Mago", 2, 10, 4, 4);
        gestor.modificarPersonaje("Caballero", 1, 2, 2, 2);
        gestor.agregarPersonaje(new Personaje("Mago", 2, 10, 4, 4));
        
        //Mostrar Personajes con la modifcacion
        gestor.mostrarPersonajes();
        
        //Borrar Personaje
        gestor.borrarPersonaje("Arquero");
        
        //Mostrar Personajes - Personaje borradp
        gestor.mostrarPersonajes();
        
        // Filtrar personajes
        System.out.println("----------------------Personajes filtrados por Vida----------------------");
        gestor.filtrarPorAtributo("Vida");

        // Test Estadisticas
        System.out.println("---------------------Estadísticas Generales---------------------:");
        gestor.mostrarEstadisticas();

    }
}


