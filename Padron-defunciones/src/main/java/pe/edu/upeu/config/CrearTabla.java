package pe.edu.upeu.config;

import java.sql.Connection;
import java.sql.Statement;

public class CrearTabla {

    public static void crearTabla() {

        String sql = "CREATE TABLE IF NOT EXISTS defuncion (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "fecha TEXT," +
                "lugar TEXT," +
                "causa TEXT," +
                "familiar TEXT," +
                "parentesco TEXT" +
                ");";

        try {
            ConexionSQLITE con = new ConexionSQLITE();
            Connection conn = con.conectar();

            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            System.out.println("Tabla creada correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
