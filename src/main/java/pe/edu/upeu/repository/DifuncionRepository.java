package pe.edu.upeu.repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import pe.edu.upeu.model.Difuncion;
import java.util.List;

import static io.micronaut.data.model.query.builder.sql.Dialect.H2;

@JdbcRepository(dialect = H2)
public interface DifuncionRepository extends CrudRepository<Difuncion, String> {
    List<Difuncion> findByNombreFallecidoContainsIgnoreCase(String nombreFallecido);
    List<Difuncion> findByFechaDefuncionContains(String fechaDefuncion);}