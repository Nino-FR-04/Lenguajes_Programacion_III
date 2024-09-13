package experiencia_tres;

public class Limpieza {
    // Atributos que describen al personal de limpieza
    private String nombre;
    private int cargaDeTrabajo; // Numero de habitaciones asignadas

    // Constructor que inicializa el nombre del personal y su carga de trabajo
    public Limpieza(String nombre) {
        this.nombre = nombre;
        this.cargaDeTrabajo = 0; // Inicialmente no tiene habitaciones asignadas
    }

    // Metodo para asignar una habitacion al personal, incrementa la carga de trabajo
    public void asignarHabitacion() {
        this.cargaDeTrabajo++;
    }

    // Getters y setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public int getCargaDeTrabajo() {
        return cargaDeTrabajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargaDeTrabajo(int cargaDeTrabajo) {
        this.cargaDeTrabajo = cargaDeTrabajo;
    }
}
