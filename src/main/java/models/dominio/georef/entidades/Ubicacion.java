package models.dominio.georef.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ubicacion {
    private String departamento_id;
    private String departamento_nombre;
    private double lat;
    private double lon;
    private String municipio_id;
    private String municipio_nombre;
    private String provincia_id;
    private String provincia_nombre;

}