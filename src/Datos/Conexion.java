package Datos;
import java.sql.*;
public class Conexion {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONNECT_STRING = "jdbc:mysql://127.0.0.1/peliculasv3";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con = null;

    // Constructor privado para evitar instancias
    private Conexion() {
    }

    public static Connection obtenerConexion() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(CONNECT_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de la base de datos: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos: " + e.getMessage());
        }
        return null;
    }

    public static void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

