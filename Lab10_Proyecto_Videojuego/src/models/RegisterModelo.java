package models;
import java.sql.*;
import excepciones.UsuarioExistenteException;

public class RegisterModelo {
	
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
	
	public boolean insertarDatos(String usuario, String contraseña) throws ClassNotFoundException, IllegalArgumentException, UsuarioExistenteException {
	    if (usuario.isEmpty() || contraseña.isEmpty()) {
	        throw new IllegalArgumentException();
	    }

	    // Verificar si el usuario ya existe
	    if (existeUsuario(usuario)) {
	        throw new UsuarioExistenteException();
	    }

	    String query = "INSERT INTO Usuarios (Nombre_usuario, Contraseña, ID_Personaje_Seleccionado) VALUES (?, ?, ?)";

	    try (Connection con = establecerConexion();
	         PreparedStatement pstmt = con.prepareStatement(query)) {

	        // Establecer los parámetros de la consulta
	        pstmt.setString(1, usuario);
	        pstmt.setString(2, contraseña);
	        pstmt.setInt(3, 1); // Personaje por defecto al crear la cuenta

	        // Ejecutar la consulta
	        int filasInsertadas = pstmt.executeUpdate();

	        // Si al menos una fila fue afectada, la inserción fue exitosa
	        return filasInsertadas > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

    
    private boolean existeUsuario(String usuario) throws ClassNotFoundException {
        String query = "SELECT * FROM Usuarios WHERE Nombre_usuario = ?";
        
        try (Connection con = establecerConexion();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setString(1, usuario);
            ResultSet rs = pstmt.executeQuery();
            
            // Si existe algún registro, el usuario ya está registrado
            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}