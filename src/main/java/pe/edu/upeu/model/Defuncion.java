package pe.edu.upeu.model;
import java.time.LocalDate;

public class Defuncion {
    private String nombreFallecido;
    private LocalDate fechaDefuncion;
    private String lugarDefuncion;
    private String causaMuerte;
    private String nombreFamiliar;
    private String parentesco;

    public Defuncion(String nombreFallecido, LocalDate fechaDefuncion,
                     String lugarDefuncion, String causaMuerte,
                     String nombreFamiliar, String parentesco) {
        this.nombreFallecido = nombreFallecido;
        this.fechaDefuncion = fechaDefuncion;
        this.lugarDefuncion = lugarDefuncion;
        this.causaMuerte = causaMuerte;
        this.nombreFamiliar = nombreFamiliar;
        this.parentesco = parentesco;
    }

    public String getNombreFallecido() { return nombreFallecido; }
    public LocalDate getFechaDefuncion() { return fechaDefuncion; }
    public String getLugarDefuncion() { return lugarDefuncion; }
    public String getCausaMuerte() { return causaMuerte; }
    public String getNombreFamiliar() { return nombreFamiliar; }
    public String getParentesco() { return parentesco; }
}
