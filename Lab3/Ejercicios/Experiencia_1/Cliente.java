package experiencia_uno;

public class Cliente {
    // Atributos que almacenan la informacion del cliente
    private String nombre;
    private String contacto;

    // Constructor que inicializa los atributos del cliente
    public Cliente(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }

    // Metodo para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Metodo para obtener el contacto del cliente
    public String getContacto() {
        return contacto;
    }
}
