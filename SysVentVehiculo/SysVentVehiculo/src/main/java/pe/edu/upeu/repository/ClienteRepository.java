package pe.edu.upeu.repository;

import pe.edu.upeu.config.ConexionSQLITE;
import pe.edu.upeu.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    public static ClienteRepository instance=new ClienteRepository();
    public Connection con=new ConexionSQLITE().conectar();
    PreparedStatement ps;
    ResultSet rs;
     public static ClienteRepository getInstance(){
         if(instance==null){
             instance=new ClienteRepository();
         }
         return instance;
     }

     List<Cliente> clientes;

     public void save(Cliente cliente){
         String sql="INSERT INTO cliente (idDni, nombre, telefono, email) VALUES (?, ?, ?, ?);";
         try {
             ps=con.prepareStatement(sql);
             ps.setString(1,cliente.getIdDni());
             ps.setString(2,cliente.getNombre());
             ps.setString(3,cliente.getTelefono());
             ps.setString(4,cliente.getEmail());
             ps.executeLargeUpdate();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         //clientes.add(cliente);
     }
     public List<Cliente> finALL(){
         clientes=new ArrayList<>();
         try {
             ps=con.prepareStatement("select * from cliente");
             rs=ps.executeQuery();
             while (rs.next()){
                 Cliente c=new Cliente();
                 c.setIdDni(rs.getString("idDni"));
                 clientes.add(c);
             }
         } catch (Exception e) {
             throw  new RuntimeException(e);
         }
         return clientes;
     }
     public void update(Cliente c, String dni){
         //clientes.set(index, c );
         String sql="UPDATE cliente SET nombre=?, telefono=?, email=? WHERE idDni=?;";
         try {
             ps=con.prepareStatement(sql);
             ps.setString(1,c.getNombre());
             ps.setString(2,c.getTelefono());
             ps.setString(3,c.getEmail());
             ps.setString(4,c.getIdDni());
             ps.executeUpdate();
         } catch (Exception e) {
             throw new RuntimeException(e);

         }
     }
     //Delete
    public void delete(String dni ){
         String sql="DELETE FROM cliente WHERE idDni=?";
         try {
             ps=con.prepareStatement(sql);
             ps.setString(1,dni);
             ps.executeLargeUpdate();

         } catch (Exception e) {
             throw new RuntimeException(e);
         }
         //clientes.remove(dni);
    }

    /*public void CargarDatos(){
         clientes.add(new Cliente("61158799","Anthony Erick","987590865","ccosisucapucaanthony@gmail.com"));
        clientes.add(new Cliente("61158798","Khaelriz","997590865","khaelriz43@gmail.com"));
    }*/
}
