package Ejercicio1;
import java.io.Serializable;

public class Personaje implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    //----------------------------------------
    
    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        setVida(vida);
        setAtaque(ataque);
        setDefensa(defensa);
        setAlcance(alcance);
    }
    
    //----------------------------------------
    // Getters
    public String getNombre() {return nombre;}
    public int getVida() {return vida;}
    public int getAtaque() {return ataque;}
    public int getDefensa() {return defensa;}
    public int getAlcance() {return alcance;}

    // Setters 
    public void setVida(int vida) {
        if (vida > 0) {
            this.vida = vida;
        } else {
            throw new IllegalArgumentException("Vida debe ser mayor a 0.");
        }
    }

    public void setAtaque(int ataque) {
        if (ataque > 0) {
            this.ataque = ataque;
        } else {
            throw new IllegalArgumentException("Ataque debe ser mayor a 0.");
        }
    }

    public void setDefensa(int defensa) {
        if (defensa > 0) {
            this.defensa = defensa;
        } else {
            throw new IllegalArgumentException("Defensa debe ser mayor a 0.");
        }
    }

    public void setAlcance(int alcance) {
        if (alcance > 0) {
            this.alcance = alcance;
        } else {
            throw new IllegalArgumentException("Alcance debe ser mayor a 0.");
        }
    }

    
    //------------------------------------------------
    @Override
    public String toString() {
        return "Personaje[" +
                "Nombre: " + nombre +
                ", Vida: " + vida +
                ", Ataque: " + ataque +
                ", Defensa: " + defensa +
                ", Alcance: " + alcance +
                ']';
    }
}
