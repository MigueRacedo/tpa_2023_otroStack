package models.dominio.georef.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provincia")
public class Provincia {
    @Setter
    @Getter
    @Id
    public String id;
    @Setter
    @Getter
    @Column(name = "nombre")
    public String nombre;
    @Getter
    @Setter
    @OneToMany(mappedBy = "provincia", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Departamento> departamentos;
}
