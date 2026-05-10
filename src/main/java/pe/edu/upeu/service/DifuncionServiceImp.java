package pe.edu.upeu.service;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import pe.edu.upeu.model.Difuncion;
import pe.edu.upeu.repository.DifuncionRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Singleton
public class DifuncionServiceImp implements DifuncionService {

    private final DifuncionRepository repo;

    public DifuncionServiceImp(DifuncionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Difuncion save(Difuncion d) {
        return repo.save(d);
    }

    @Override
    public Difuncion update(Difuncion d) {
        return repo.update(d);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }

    @Override
    public List<Difuncion> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Difuncion> buscar(String dato) {
        return repo.findByNombreFallecidoContainsIgnoreCase(dato);
    }

    @Override
    public Optional<Difuncion> findById(String id) {
        return repo.findById(id);
    }
}