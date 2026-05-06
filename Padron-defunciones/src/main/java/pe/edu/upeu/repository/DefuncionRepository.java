package pe.edu.upeu.repository;
import pe.edu.upeu.model.Defuncion;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

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

    public void cargarDatos() {
        lista.add(new Defuncion(
                "Romulo",
                LocalDate.of(2027, 4, 27),
                "Hospital",
                "Bala perdida",
                "Marco",
                "Hermanos"
        ));

        lista.add(new Defuncion(
                "Anthony",
                LocalDate.of(2030, 10, 2),
                "Habitacion",
                "Corazon se detuvo",
                "Justina",
                "Madre e hijo"
        ));
    }
}
