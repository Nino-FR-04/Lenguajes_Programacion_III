package experiencia_cinco;

import java.time.LocalDateTime;

public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private PoliticaCancelacion politicaCancelacion; // Politica de cancelacion

    // Constructor que inicializa la reserva con una politica de cancelacion
    public Reserva(Habitacion habitacion, Cliente cliente, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, PoliticaCancelacion politicaCancelacion) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.politicaCancelacion = politicaCancelacion;
    }

    // Metodo para intentar cancelar la reserva usando la politica de cancelacion
    public boolean cancelar() {
        if (politicaCancelacion.puedeCancelar(this)) {
            System.out.println("Reserva cancelada para el cliente: " + cliente.getNombre());
            return true;
        } else {
            System.out.println("No se puede cancelar la reserva debido a la politica de cancelacion.");
            return false;
        }
    }

    // Getters y setters
    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
