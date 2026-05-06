package pe.edu.upeu.model;


import java.time.LocalDate;

class Persona {
    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

public class Defuncion extends Persona {
    private String nombreFallecido;
    private LocalDate fechaDefuncion;
    private String lugarDefuncion;
    private String causaMuerte;
    private String nombreFamiliar;
    private String parentesco;

    public Defuncion(String nombreFallecido, LocalDate fechaDefuncion,
                     String lugarDefuncion, String causaMuerte,
                     String nombreFamiliar, String parentesco) {
        this.nombreFallecido = nombreFallecido;//herencia
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

    public void setNombreFallecido(String nombre) {
        this.nombreFallecido = nombre;
    }
    public class Persona {
        protected String nombre;
    }

}
