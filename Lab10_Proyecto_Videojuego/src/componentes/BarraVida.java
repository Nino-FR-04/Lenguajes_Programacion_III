package componentes;

import javax.swing.JProgressBar;
import Colores.InterfazColores;
import Fuente.FuentePersonalizada;
import interfaces_ClasesPatrones.Observador;
import models.Entidad;

public class BarraVida extends JProgressBar implements Observador {

	private static final long serialVersionUID = 1L;

	//-----------------Constructor
	public BarraVida(Entidad entidad) {
		super(0,entidad.getVida());
		setValue(entidad.getVida());
		setFont(FuentePersonalizada.cargarFuente(14));
		setStringPainted(true);
		setForeground(InterfazColores.BARRAVIDA_COLOR_FULL);
	}
	
	@Override
	public void actualizar(int vida) {
		setValue(vida);
		
		if(vida > 60) {
			this.setForeground(InterfazColores.BARRAVIDA_COLOR_FULL);
		}else if(vida > 30) {
			this.setForeground(InterfazColores.BARRAVIDA_COLOR_MEDIUM);
		}else {
			this.setForeground(InterfazColores.BARRAVIDA_COLOR_LOW);
		}
		
	}
}
