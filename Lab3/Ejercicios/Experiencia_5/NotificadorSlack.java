package experiencia_cinco;

// Clase que implementa el canal de notificación por Slack
public class NotificadorSlack implements CanalNotificacion {

    @Override
    public void enviarNotificacion(String mensaje) {
        // Simulación de envío a un canal de Slack
        System.out.println("Enviando mensaje a Slack: " + mensaje);
    }
}
