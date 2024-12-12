package models;

import java.util.ArrayList;
import interfaces_ClasesPatrones.Observador;

public class Enemigo extends Entidad {
	
	private ArrayList<Observador> observadores;
	
	public Enemigo(int id,String nombre,int vida,int resistencia,
			int danio,String movRuta,String iconoRuta) {
		
		super(id,nombre,vida,resistencia,danio,movRuta,iconoRuta);
		this.observadores = new ArrayList<>();
	}

	
	public void agregarObservador(Observador observador) {
		this.observadores.add(observador);
	}

	private void notificarVida() {
		for(Observador obs : this.observadores) {
			obs.actualizar(this.getVida());
		}
	}
	
	
	@Override
	public void modificarVida(int cantidad) {
        int nuevaVida = this.getVida() + cantidad;

        // Validar que la vida no sea menor a 0 ni mayor a vidaMaxima
        if (nuevaVida < 0) {
            nuevaVida = 0; // No puede ser negativa
        } else if (nuevaVida > this.getVidaMaxima()) {
            nuevaVida = this.getVidaMaxima(); // No puede superar vidaMaxima
        }

        // Actualizar vida
        this.setVida(nuevaVida);
        notificarVida();
	}

}
