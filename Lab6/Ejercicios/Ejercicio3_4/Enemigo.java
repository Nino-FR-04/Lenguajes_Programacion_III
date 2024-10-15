package Ejercicio3;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public void atacar(Jugador jugador) {
        int danio = 5 * nivel; 
        jugador.recibirDanio(danio);
    }

    public void recibirDanio(int danio) {salud -= danio;}
    public String getNombre() {return nombre;}
    public int getSalud() {return salud;}
}

