package componentes;

import javax.swing.*;
import Fuente.FuentePersonalizada;
import java.util.Timer;
import java.util.TimerTask;

public class TimerLabel extends JLabel {

    private static final long serialVersionUID = 1L;
    private int tiempoRestante;
    private Timer timer; 
    private boolean enEjecucion;
    
    
    public TimerLabel(int valorInicial) {
    	super(String.valueOf(valorInicial), SwingConstants.CENTER);
        this.tiempoRestante = valorInicial;
        this.setFont(FuentePersonalizada.cargarFuente(18));
        this.timer = new Timer();
        this.enEjecucion = false;
    }
    
    public void iniciar() {
        if (enEjecucion) return;
        enEjecucion = true;
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                tiempoRestante--;
                setText(String.valueOf(tiempoRestante));
                if (tiempoRestante < 0) {
                    detener();
                }
            }
        };
        timer.scheduleAtFixedRate(tarea, 0, 1000);
    }
    
    public void detener() {
        if (!enEjecucion) return;
        enEjecucion = false;
        timer.cancel();
        tiempoRestante = 0;
        setText("0");
    }
    
    public void reiniciar(int nuevoValor) {
        if (enEjecucion) {
            detener();  // Detener el temporizador antes de reiniciarlo
        }
        tiempoRestante = nuevoValor;
        setText(String.valueOf(tiempoRestante));
        // Crear un nuevo Timer para cada reinicio
        timer = new Timer();
        enEjecucion = false;
    }
    
    //Getter
    public boolean estaEnEjecucion() {
        return enEjecucion;
    }
    
}

