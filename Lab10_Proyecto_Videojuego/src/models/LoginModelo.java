package models;

import java.sql.*;

public class LoginModelo {
	
	//Establecer conexion
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
	
	public boolean validarDatos(String usuario,String contrasenia) throws ClassNotFoundException, IllegalArgumentException {
		
		if (usuario.isEmpty() || contrasenia.isEmpty()) {
	        throw new IllegalArgumentException();
	    }
		
		String query = "SELECT * FROM Usuarios WHERE Nombre_usuario = ? AND Contraseña = ?";
		
		try (Connection con = establecerConexion();
		         PreparedStatement pstmt = con.prepareStatement(query)) {
		        
		        pstmt.setString(1, usuario);
		        pstmt.setString(2, contrasenia);		      
		        
		        ResultSet rs = pstmt.executeQuery();
		        
		        if (rs.next()) {
	                // Si se encuentra un usuario que coincide con el nombre y la contraseña
	                return true; // El inicio de sesión es exitoso
	            }
		    } catch (SQLException e) {
		        return false;
		    }
		
		return false;
	}
	
    public Usuarios getDatosUsuario(String usuario) throws ClassNotFoundException {
        String query = "SELECT * FROM Usuarios WHERE Nombre_usuario = ?";

        try (Connection con = establecerConexion();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, usuario);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Crear y devolver un objeto Usuarios con los datos obtenidos
                Usuarios user = new Usuarios(
                		
                		rs.getString("Nombre_usuario"),
                		rs.getInt("ID_Personaje_Seleccionado")
                		
                		);

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Si no se encuentra el usuario o ocurre un error, retornar null
        return null;
    }
}
