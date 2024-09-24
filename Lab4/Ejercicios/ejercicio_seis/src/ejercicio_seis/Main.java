package ejercicio_seis;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Creando una propiedad válida
            Propiedad propiedad = new Propiedad("Av. Siempre Viva 123", 150000, 120);

            // Transacción de compra válida
            TransaccionInmobiliaria transaccion = new TransaccionInmobiliaria(1, propiedad, 160000);
            System.out.println("Transacción realizada con éxito por: " + transaccion.getPrecioTransaccion());

            // Creación de un contrato de alquiler válido
            ContratoAlquiler contrato = new ContratoAlquiler(12, 1200);
            System.out.println("Contrato de alquiler por: " + contrato.getMontoAlquiler() + " por " + contrato.getDuracionMeses() + " meses");

            // Registro de un pago válido
            HistorialDePagos pago = new HistorialDePagos(LocalDate.now(), 1200);
            System.out.println("Pago registrado por: " + pago.getMontoPago());

        } catch (DatosInvalidosException | PrecioInferiorException | ContratoInvalidoException | PagoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
