package Ejercicio3;

public class CombateView {
    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("=== Estado de Combate ===");
        System.out.println("Jugador: " + jugador.getNombre() + " | Salud: " + jugador.getSalud());
        System.out.println("Enemigo: " + enemigo.getNombre() + " | Salud: " + enemigo.getSalud());
        System.out.println("=========================");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

