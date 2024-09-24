package ejercicio_uno;

import java.io.IOException;

// Clase LeerEntrada
class LeerEntrada {
    public char getChar() throws IOException {
        return (char) System.in.read();
    }
}
