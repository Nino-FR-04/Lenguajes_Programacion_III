package Lab2;

public class TestAgregacion {
    public static void main(String[] args) {
        Motor motor1 = new Motor(101, 5000);
        Motor motor2 = new Motor(102, 6000);

        Automovil auto1 = new Automovil("ABC123", 4, "Toyota", "Corolla");
        Automovil auto2 = new Automovil("XYZ789", 2, "Ford", "Mustang");

        // Asignamos motores a los automóviles
        auto1.setMotor(motor1);
        auto2.setMotor(motor2);

        // Mostramos los datos de los objetos
        System.out.println(auto1.toString());
        System.out.println(auto2.toString());
    }
}
