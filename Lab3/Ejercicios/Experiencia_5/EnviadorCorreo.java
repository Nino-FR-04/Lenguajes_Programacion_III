package experiencia_cinco;

// Clase que implementa el canal de notificación por correo electrónico
public class EnviadorCorreo implements CanalNotificacion {

    @Override
    public void enviarNotificacion(String mensaje) {
        // Simulación de envío de correo
        System.out.println("Enviando correo: " + mensaje);
    }
}
