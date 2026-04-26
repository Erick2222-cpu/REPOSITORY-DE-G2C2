package pe.edu.upeu.repository;
import pe.edu.upeu.model.Defuncion;
import java.util.ArrayList;
import java.util.List;

public class DefuncionRepository {
    private List<Defuncion> lista = new ArrayList<>();

    public void guardar(Defuncion d) {
        lista.add(d);
    }

    public List<Defuncion> listar() {
        return lista;
    }

    public void actualizar(int index, Defuncion d) {
        lista.set(index, d);
    }

    public void eliminar(int index) {
        lista.remove(index);
    }
}
