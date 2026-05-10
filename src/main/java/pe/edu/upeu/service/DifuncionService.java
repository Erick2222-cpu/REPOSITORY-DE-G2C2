package pe.edu.upeu.service;
import pe.edu.upeu.model.Difuncion;
import java.util.List;
import java.util.Optional;
public interface DifuncionService {
    Difuncion save(Difuncion c);
    Difuncion update(Difuncion c);
    void delete(String id);
    List<Difuncion> findAll();
    List<Difuncion> buscar(String dato);
    Optional<Difuncion> findById(String id);
}