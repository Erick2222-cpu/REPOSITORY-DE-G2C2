package pe.edu.upeu.service;

import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.repository.ClienteRepository;

import java.util.List;

public class ClienteServiceImp  implements ClienteService {
        ClienteRepository cr=ClienteRepository.getInstance();

        private static ClienteService instance=new ClienteServiceImp();

        public  static ClienteService getInstance(){
            if(instance==null){
                instance=new ClienteServiceImp();
            }
            return instance;
        }



    @Override
    public void save(Cliente c) {
        cr.save(c);
    }

    @Override
    public List<Cliente> finAll() {
        if (cr.finALL().isEmpty()){
                cr.finALL();
        }
        return cr.finALL();
    }

    @Override
    public void update(Cliente c, String dni) {
        cr.update(c, dni);

    }

    @Override
    public void delete(String dni) {
        cr.delete(dni);

    }
}
