package experiencia_cinco;

// Clase que implementa el canal de notificación por SMS
public class EnviadorSMS implements CanalNotificacion {

    @Override
    public void enviarNotificacion(String mensaje) {
        // Simulación de envío de SMS
        System.out.println("Enviando SMS: " + mensaje);
    }
}
