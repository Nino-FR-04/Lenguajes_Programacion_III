package ejercicio1;
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message); 
}

class Usuario implements Observer{
	private String nombre; 
	private boolean suscripcion; 
	
	public Usuario(String nombre) {
		this.nombre=nombre;
		this.suscripcion=false; 
	}
	public String getNombre() {
		return nombre; 
	}
	public boolean suscripcion() {
		return suscripcion;
	}
	public void suscribirse() {
		this.suscripcion=true;
		System.out.println(nombre + " se ha suscrito");
	}
	public void anusucrip() {
		this.suscripcion=false;
		System.out.println(nombre + " se ha desuscrito"); 
	}
	
	@Override 
	public void update(String message) {
		if(suscripcion) {
			System.out.println(nombre+" ha recibido la notificacion"+message); 
		}
	}
}
class Notificacion{
	private List <Observer> observers =new ArrayList<>(); 
	
	public void attach(Observer observer) {
		observers.add(observer); 
		Usuario usuario = (Usuario) observer;
	    usuario.suscribirse(); 
	}
	public void detach(Observer observer) {
		observers.remove(observer); 
		if (observer instanceof Usuario) {
	        Usuario usuario = (Usuario) observer;
	        System.out.println(usuario.getNombre() + " se ha eliminado del sistema de notificaciones.");
	    }
	} 
	
	public void notifyObservers(String message) {
		for (Observer observer : observers) {
		observer.update(message);
		}
	}
}

public class Main {
    public static void main(String[] args) {
        Notificacion notificacion = new Notificacion();

        Usuario usuario1 = new Usuario("Nino");
        Usuario usuario2 = new Usuario("Alvaro");
        Usuario usuario3 = new Usuario("Jesus");

        notificacion.attach(usuario1);
        notificacion.attach(usuario2);
        notificacion.attach(usuario3);

        notificacion.notifyObservers("¡Nueva promoción disponible de cursos para algoritmia!");

        notificacion.detach(usuario1);

        notificacion.notifyObservers("¡Oferta especial por tiempo limitado!");
    }
}
