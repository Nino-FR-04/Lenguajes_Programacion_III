package models;

import java.sql.*;

public class VentanaCombateModelo {
	
	private Connection establecerConexion() throws ClassNotFoundException, SQLException {
        Connection con = null;
        // Cargar controlador
        Class.forName("org.sqlite.JDBC");

        // Corregir path----
        con = DriverManager.getConnection(
                "jdbc:sqlite:JuegoRol.db"
        );

        return con;
    }
	
	public Personaje cargarPersonaje(String nombre) throws ClassNotFoundException {
    	
    	String query = "SELECT * FROM Personajes " +
                "JOIN Usuarios ON Personajes.ID_Personaje = Usuarios.ID_Personaje_Seleccionado " +
                "WHERE Nombre_usuario = ?";

        // Utilizamos try-with-resources para manejar los recursos (Connection, PreparedStatement y ResultSet)
        try (Connection con = establecerConexion();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombre); // Establecer el valor de 'Nombre_usuario'

            // Intentamos ejecutar la consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Si se encuentra un resultado, construir el objeto Personaje
                    return new Personaje(
                            rs.getInt("ID_Personaje"),
                            rs.getString("Nombre"),
                            rs.getString("Descripcion"),
                            rs.getInt("Vida"),
                            rs.getInt("Resistencia"),
                            rs.getInt("Daño"),
                            rs.getString("MovimientoRuta"),
                            rs.getString("IconoRuta")
                    );
                }
            }

        } catch (SQLException e) {
            // Manejo de la excepción SQL (por ejemplo, si la conexión falla o la consulta tiene problemas)
            e.printStackTrace();
        }

        // Si no se encuentra el personaje, retornar null
        return null;
    }
	
	
	//Por el momento se carga un solo enemigo debido
	public Enemigo cargarEnemigo() throws ClassNotFoundException {
    	
    	String query = "SELECT * FROM Enemigos "
    			+ "WHERE ID_Enemigo = ?";

        // Utilizamos try-with-resources para manejar los recursos (Connection, PreparedStatement y ResultSet)
        try (Connection con = establecerConexion();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, 3); // Establecer el valor de 'Enemigo' - predeterminado

            // Intentamos ejecutar la consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Si se encuentra un resultado, construir el objeto Personaje
                    return new Enemigo(
                            rs.getInt("ID_Enemigo"),
                            rs.getString("Nombre"),
                            rs.getInt("Vida"),
                            rs.getInt("Resistencia"),
                            rs.getInt("Daño"),
                            rs.getString("MovimientoRuta"),
                            rs.getString("IconoRuta")
                    );
                }
            }

        } catch (SQLException e) {
            // Manejo de la excepción SQL (por ejemplo, si la conexión falla o la consulta tiene problemas)
            e.printStackTrace();
        }

        // Si no se encuentra el personaje, retornar null
        return null;
    }
	
}
