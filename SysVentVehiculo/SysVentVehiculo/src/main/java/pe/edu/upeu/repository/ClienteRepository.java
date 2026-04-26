package pe.edu.upeu.repository;

import pe.edu.upeu.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    public static ClienteRepository instance=new ClienteRepository();
     public static ClienteRepository getInstance(){
         if(instance==null){
             instance=new ClienteRepository();
         }
         return instance;
     }

     List<Cliente> clientes=new ArrayList<>();

     public void save(Cliente cliente){
         clientes.add(cliente);
     }
     public List<Cliente> finALL(){
         return clientes;
     }
     public void update(Cliente c, int index){
         clientes.set(index, c );
     }
     //Delete
    public void delete(int index){
         clientes.remove(index);
    }
    public void CargarDatos(){
         clientes.add(new Cliente("61158799","Anthony Erick","987590865","ccosisucapucaanthony@gmail.com"));
        clientes.add(new Cliente("61158798","Khaelriz","997590865","khaelriz43@gmail.com"));
    }
}
