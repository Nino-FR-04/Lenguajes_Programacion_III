package experiencia_cinco;

public class Cliente {
    private String nombre;
    private String contacto;
    private String celular; // Nuevo atributo

    // Constructor actualizado que incluye el celular
    public Cliente(String nombre, String contacto, String celular) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getCelular() {
        return celular;
    }
}
