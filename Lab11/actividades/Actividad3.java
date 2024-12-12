package actividades;

class Televisor {
    public void encender() {System.out.println("Televisor encendido.");}
    public void apagar() {System.out.println("Televisor apagado.");}
    public void subirVolumen() {System.out.println("Volumen subido.");}
    public void bajarVolumen() {System.out.println("Volumen bajado.");}
    public void cambiarCanal() {System.out.println("Canal cambiado.");}
}

interface Comando {
    void ejecutar();
}

class ComandoEncender implements Comando {
    private Televisor televisor;

    public ComandoEncender(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void ejecutar() {televisor.encender();}
}

class ComandoApagar implements Comando {
    private Televisor televisor;

    public ComandoApagar(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void ejecutar() {televisor.apagar();}
}

class ComandoSubirVolumen implements Comando {
    private Televisor televisor;

    public ComandoSubirVolumen(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void ejecutar() {televisor.subirVolumen();}
}

class ComandoBajarVolumen implements Comando {
    private Televisor televisor;

    public ComandoBajarVolumen(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void ejecutar() {televisor.bajarVolumen();}
}

class ComandoCambiarCanal implements Comando {
    private Televisor televisor;

    public ComandoCambiarCanal(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void ejecutar() {televisor.cambiarCanal();}
}

class ControlRemoto {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void presionarBoton() {
        if (comando != null) {
            comando.ejecutar();
        } else {
            System.out.println("No hay comando asignado al botón.");
        }
    }
}

public class Actividad3 {
	public static  void main(String[] args) {
		Televisor televisor = new Televisor();
		ControlRemoto controlRemoto = new ControlRemoto();
	        
		Comando encender = new ComandoEncender(televisor);
		Comando apagar = new ComandoApagar(televisor);
	        
		controlRemoto.setComando(encender);
		controlRemoto.presionarBoton();
		controlRemoto.setComando(apagar);
		controlRemoto.presionarBoton();
	}
}
