package pe.edu.upeu.model;

import io.micronaut.data.annotation.*;
import lombok.*;

@MappedEntity("difuncion")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Difuncion {

    @Id
    private String id;

    private String nombreFallecido;

    private String fechaDefuncion;

    private String lugarDefuncion;

    private String causaMuerte;

    private String nombreFamiliar;

    private String parentesco;
}