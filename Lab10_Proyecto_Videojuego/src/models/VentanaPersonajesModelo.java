package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VentanaPersonajesModelo {
	
	private ArrayList<Personaje> personajes;
	
	public VentanaPersonajesModelo() throws ClassNotFoundException {
		this.personajes = new ArrayList<>();
		cargarPersonajes();
	}
	
	private Connection establecerConexion() throws ClassNotFoundException, SQLException  {
		Connection con = null;
		//Cargar controlador
		Class.forName("org.sqlite.JDBC");
		
		//Corregir path----
		con = DriverManager.getConnection(
				"jdbc:sqlite:JuegoRol.db"
				);
		
		return con;
	}
	
	private boolean cargarPersonajes() throws ClassNotFoundException {
        String query = "SELECT * FROM Personajes";
        
        try (Connection con = establecerConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Personaje personaje = new Personaje(
                		rs.getInt("ID_Personaje"),
                		rs.getString("Nombre"),
                		rs.getString("Descripcion"),
                		rs.getInt("Vida"),
                		rs.getInt("Resistencia"),
                		rs.getInt("Daño"),
                		rs.getString("MovimientoRuta"),
                		rs.getString("IconoRuta")
                		);
                this.personajes.add(personaje);
                
            }
        } catch (SQLException e) {
        	return false;
        }
        return true;
	}	
	
	//----------------------------
	public boolean actualizarPersonaje(int id, String nombre) throws ClassNotFoundException {
		String query = "UPDATE Usuarios SET ID_Personaje_Seleccionado = ? WHERE Nombre_usuario = ?;";

        
        try (Connection con = establecerConexion();
        		PreparedStatement pstmt = con.prepareStatement(query)) {
            
        	// Establecer los parámetros de la consulta
        	pstmt.setInt(1, id);  // ID del nuevo personaje
            pstmt.setString(2, nombre);   // Nombre del usuario
            
            // Ejecutar la actualización
            int filasActualizadas = pstmt.executeUpdate();
            
            // Verificar si se actualizó alguna fila
            return filasActualizadas > 0; // Devuelve true si se actualizó al menos un registro
                
        } catch (SQLException e) {
        	return false;
        }
	}
	
	//Obtener Personajes
	public ArrayList<Personaje> getPersonajes(){
		return this.personajes;
	}
	

}
