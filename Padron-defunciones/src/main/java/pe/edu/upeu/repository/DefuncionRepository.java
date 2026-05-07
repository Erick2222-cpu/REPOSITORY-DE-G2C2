package pe.edu.upeu.repository;

import pe.edu.upeu.model.Defuncion;
import pe.edu.upeu.config.ConexionSQLITE;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefuncionRepository {

    ConexionSQLITE con = new ConexionSQLITE();

    // ✅ GUARDAR EN BD
    public void guardar(Defuncion d) {

        String sql = "INSERT INTO defuncion(nombre, fecha, lugar, causa, familiar, parentesco) VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = con.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, d.getNombre());
            ps.setString(2, d.getFechaDefuncion().toString());
            ps.setString(3, d.getLugarDefuncion());
            ps.setString(4, d.getCausaMuerte());
            ps.setString(5, d.getNombreFamiliar());
            ps.setString(6, d.getParentesco());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error guardar: " + e.getMessage());
        }
    }

    // ✅ LISTAR DESDE BD
    public List<Defuncion> listar() {

        List<Defuncion> lista = new ArrayList<>();
        String sql = "SELECT * FROM defuncion";

        try {
            Connection conn = con.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Defuncion d = new Defuncion(
                        rs.getString("nombre"),
                        LocalDate.parse(rs.getString("fecha")),
                        rs.getString("lugar"),
                        rs.getString("causa"),
                        rs.getString("familiar"),
                        rs.getString("parentesco")
                );

                d.equals(rs.getInt("id"));
                lista.add(d);
            }

        } catch (Exception e) {
            System.out.println("Error listar: " + e.getMessage());
        }

        return lista;
    }

    // ✅ ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM defuncion WHERE id=?";

        try {
            Connection conn = con.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error eliminar: " + e.getMessage());

        }

    }

    // ✅ ACTUALIZAR
    public void actualizar(int id, Defuncion d) {

        String sql = "UPDATE defuncion SET nombre=?, fecha=?, lugar=?, causa=?, familiar=?, parentesco=? WHERE id=?";

        try {
            Connection conn = con.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, d.getNombre());
            ps.setString(2, d.getFechaDefuncion().toString());
            ps.setString(3, d.getLugarDefuncion());
            ps.setString(4, d.getCausaMuerte());
            ps.setString(5, d.getNombreFamiliar());
            ps.setString(6, d.getParentesco());
            ps.setInt(7, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error actualizar: " + e.getMessage());
        }
    }
    public void cargarDatos() {
        guardar(new Defuncion("Romulo",
                LocalDate.of(2027,4,27),
                "Hospital","Bala perdida",
                "Marco","Hermanos"));

        guardar(new Defuncion("Anthony",
                LocalDate.of(2030,10,2),
                "Habitacion","Corazon se detuvo",
                "Justina","Madre e hijo"));
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}