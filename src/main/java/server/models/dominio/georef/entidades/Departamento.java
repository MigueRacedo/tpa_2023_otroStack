package server.models.dominio.georef.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Access(AccessType.PROPERTY)

@Table(name = "departamento")
public class Departamento {
    @Setter
    @Getter
    @Id
    private String id;
    @Setter
    @Getter
    @Column(name = "nombre")
    private String nombre;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;
}
