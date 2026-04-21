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
                cr.CargarDatos();
        }
        return cr.finALL();
    }

    @Override
    public void update(Cliente c, int index) {
        cr.update(c, index);

    }

    @Override
    public void delete(int index) {
        cr.delete(index);

    }
}
