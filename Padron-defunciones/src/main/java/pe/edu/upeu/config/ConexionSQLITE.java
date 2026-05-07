package pe.edu.upeu.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLITE {

    private static final String URL = "jdbc:sqlite:data/defunciones.db";
    private Connection conexion;

    public Connection conectar() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL);
                System.out.println("Conectado a SQLite");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conexion;
    }

    public void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar: " + e.getMessage());
        }
    }
}
