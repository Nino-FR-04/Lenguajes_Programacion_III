package models;

public class Combate {
	//--------------------Ataques
	public static void ataqueFisico(Entidad atacante,Entidad atacado) {
		
		double resistencia = atacado.getResistencia() / 100f;
		int totalDaño = (int) (atacante.getDanio() * (1 - resistencia));
		
		atacado.modificarVida(-totalDaño);
			
	}
	
	public static void ataqueMagico(Entidad atacante,Entidad atacado) {
		atacado.modificarVida(-atacante.getDanio());
	}
	
	public static void curarse(Entidad entidad) {
		
		int vidaMaxima = entidad.getVidaMaxima();
	    int vidaActual = entidad.getVida();

	    // Si la vida actual + la cantidad de curación supera la vida máxima, ajustar
	    int nuevaVida = vidaActual + 10;

	    if (nuevaVida > vidaMaxima) {
	        nuevaVida = vidaMaxima; // No se puede exceder la vida máxima
	    }

	    // Llamar a modificarVida para actualizar la vida
	    entidad.modificarVida(nuevaVida - vidaActual);
	}
}
