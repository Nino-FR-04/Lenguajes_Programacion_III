package Ejercicio3;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(Item item) {
        modelo.AgregarItem(item);
        vista.MostrarMensaje("Item agregado: " + item.getNombre());
    }

    public void eliminarItem(String nombre) {
        Item item = modelo.BuscarItem(nombre);
        if (item != null) {
            modelo.EliminarItem(item);
            vista.MostrarMensaje("Item eliminado: " + nombre);
        } else {
            vista.MostrarMensaje("Item no encontrado: " + nombre);
        }
    }

    public void verInventario() {
        vista.MostrarInventario(modelo.ObtenerItems());
    }

    public void mostrarDetalles(String nombre) {
        Item item = modelo.BuscarItem(nombre);
        vista.MostrarDetallesItem(item);
    }

    public void buscarItem(String nombre) {
        Item item = modelo.BuscarItem(nombre);
        if (item != null) {
            vista.MostrarDetallesItem(item);
        } else {
            vista.MostrarMensaje("El ítem no fue encontrado.");
        }
    }

    // Nuevo método para usar un ítem
    public void usarItem(String nombre) {
        Item item = modelo.BuscarItem(nombre);
        if (item != null) {
            item.usarItem();
            if (item.getCantidad() == 0) {
                modelo.EliminarItem(item); 
                vista.MostrarMensaje("El ítem " + nombre + " ha sido eliminado del inventario.");
            }
        } else {
            vista.MostrarMensaje("No se encontró el ítem: " + nombre);
        }
    }
}

