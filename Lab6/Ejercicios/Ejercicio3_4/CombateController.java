package Ejercicio3;

import java.util.Random;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;
    private Random random;

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
        this.random = new Random();
    }

    public void iniciarCombate() {
        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            vista.mostrarEstadoCombate(jugador, enemigo);

            jugador.atacar(enemigo);

            if (enemigo.getSalud() <= 0) {
                vista.mostrarMensaje(enemigo.getNombre() + " ha sido derrotado!");
                break;
            }

            if (random.nextBoolean()) {
                enemigo.atacar(jugador);
            }

            if (jugador.getSalud() <= 0) {
                vista.mostrarMensaje(jugador.getNombre() + " ha sido derrotado!");
                break;
            }
        }
    }
}

