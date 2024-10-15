package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        //-----------------------------------------------
        Jugador jugador = new Jugador("Heroe", 100, 1);
        
        //-----------------------------------------------
        Enemigo enemigo = new Enemigo("Goblin", 50, 1, "Bestia");
        
        //-----------------------------------------------
        CombateView vista = new CombateView();

        //-----------------------------------------------
        CombateController controlador = new CombateController(jugador, enemigo, vista);

        // ------------------- Iniciar combate
        controlador.iniciarCombate();
    }
}


