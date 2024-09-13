package experiencia_dos;

import java.util.Date;

public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private Date fechaEntrada;
    private Date fechaSalida;
    private PoliticaCancelacion politicaCancelacion; // Politica de cancelacion

    // Constructor que inicializa la reserva con una politica de cancelacion
    public Reserva(Habitacion habitacion, Cliente cliente, Date fechaEntrada, Date fechaSalida, PoliticaCancelacion politicaCancelacion) {
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

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
