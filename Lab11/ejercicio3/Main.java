package ejercicio3;

interface Command {
    void execute();
    void undo();
}
class Luz {
    public void encender() {
        System.out.println("luz prendida");
    }

    public void apagar() {
        System.out.println("luz apagada");
    }
}
class Ventilador {
    public void encender() {
        System.out.println("ventilador prendido");
    }
    public void apagar() {
        System.out.println("ventilador apagado");
    }
}

class AireAcondicionado {
    public void encender() {
        System.out.println("aire acondicionado prendido");
    }

    public void apagar() {
        System.out.println("aire acondicionado apagado.");
    }
}
class EncenderLuzCommand implements Command {
    private Luz luz;
    public EncenderLuzCommand(Luz luz) {
        this.luz = luz;
    }
    @Override
    public void execute() {
        luz.encender();
    }
    @Override
    public void undo() {
        luz.apagar();
    }
}
class ApagarLuzCommand implements Command {
    private Luz luz;
    public ApagarLuzCommand(Luz luz) {
        this.luz = luz;
    }
    @Override
    public void execute() {
        luz.apagar();
    }
    @Override
    public void undo() {
        luz.encender();
    }
}

class EncenderVentiladorCommand implements Command {
    private Ventilador ventilador;
    public EncenderVentiladorCommand(Ventilador ventilador) {
        this.ventilador = ventilador;
    }
    @Override
    public void execute() {
        ventilador.encender();
    }
    @Override
    public void undo() {
        ventilador.apagar();
    }
}
class ApagarVentiladorCommand implements Command {
    private Ventilador ventilador;
    public ApagarVentiladorCommand(Ventilador ventilador) {
        this.ventilador = ventilador;
    }
    @Override
    public void execute() {
        ventilador.apagar();
    }
    @Override
    public void undo() {
        ventilador.encender();
    }
}
class EncenderAireCommand implements Command {
    private AireAcondicionado aire;
    public EncenderAireCommand(AireAcondicionado aire) {
        this.aire = aire;
    }
    @Override
    public void execute() {
        aire.encender();
    }
    @Override
    public void undo() {
        aire.apagar();
    }
}
class ApagarAireCommand implements Command {
    private AireAcondicionado aire;
    public ApagarAireCommand(AireAcondicionado aire) {
        this.aire = aire;
    }
    @Override
    public void execute() {
        aire.apagar();
    }
    @Override
    public void undo() {
        aire.encender();
    }
}

class ControlRemoto {
    private Command ultima = null;

    public void ejecutarComando(Command comando) {
        comando.execute();
        ultima = comando;
    }

    public void deshacer() {
        if (ultima != null) {
            ultima.undo();
            ultima = null;
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Luz luz = new Luz();
        Ventilador ventilador = new Ventilador();
        AireAcondicionado aire = new AireAcondicionado();
        ControlRemoto controlRemoto = new ControlRemoto();
        
        Command encenderLuz = new EncenderLuzCommand(luz);
        Command apagarLuz = new ApagarLuzCommand(luz);
        Command encenderVentilador = new EncenderVentiladorCommand(ventilador);
        Command apagarVentilador = new ApagarVentiladorCommand(ventilador);
        Command encenderAire = new EncenderAireCommand(aire);
        Command apagarAire = new ApagarAireCommand(aire);
        
        controlRemoto.ejecutarComando(encenderLuz);
        controlRemoto.ejecutarComando(encenderVentilador);
        controlRemoto.ejecutarComando(encenderAire);
        controlRemoto.deshacer();
        controlRemoto.deshacer();

        controlRemoto.ejecutarComando(apagarLuz);
        controlRemoto.ejecutarComando(apagarVentilador);
        controlRemoto.ejecutarComando(apagarAire);
    }
}
