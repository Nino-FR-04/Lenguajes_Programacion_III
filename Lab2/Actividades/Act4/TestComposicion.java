package Lab2;

public class TestComposicion {
    public static void main(String[] args) {
        // Crear una instancia de Persona con sus datos y número de cuenta
        Persona persona1 = new Persona(1, "Juan", "Perez", 12345);
        
        // Mostrar la información de la persona y su cuenta asociada
        System.out.println(persona1.toString());
        
        // Modificar el saldo de la cuenta a través de la persona
        persona1.getCuenta().setSaldo(1000.50);
        
        // Mostrar nuevamente la información de la persona, ahora con el saldo actualizado
        System.out.println(persona1.toString());

        // Crear otra persona con diferente cuenta
        Persona persona2 = new Persona(2, "Ana", "Lopez", 67890);
        System.out.println(persona2.toString());
        
        // Cambiar el saldo de la cuenta de la segunda persona
        persona2.getCuenta().setSaldo(5000.00);
        System.out.println(persona2.toString());
    }
}

