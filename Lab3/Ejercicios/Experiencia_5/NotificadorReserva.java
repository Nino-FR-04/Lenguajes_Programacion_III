package experiencia_cinco;

// Clase que utiliza el canal de notificación inyectado
public class NotificadorReserva {

    private CanalNotificacion canalNotificacion;

    // Inyección de dependencia mediante el constructor
    public NotificadorReserva(CanalNotificacion canalNotificacion) {
        this.canalNotificacion = canalNotificacion;
    }

    // Método para notificar sobre una reserva
    public void notificar(String mensaje) {
        canalNotificacion.enviarNotificacion(mensaje); // Utiliza el canal de notificación
    }
}
