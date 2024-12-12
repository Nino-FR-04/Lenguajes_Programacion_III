package models;

//Patron Singleton - Asegura una sola instancia durante la ejecucion del programa
public class Sesion {
    private static Sesion instancia;
    private Usuarios usuario;

    // Constructor privado para prevenir la creación de instancias desde fuera
    private Sesion() {}

    // Método para obtener la única instancia de Session
    public static Sesion getinstancia() {
        if (instancia == null) {
        	instancia = new Sesion();
        }
        return instancia;
    }

    // Getter y Setter para el usuario
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}

