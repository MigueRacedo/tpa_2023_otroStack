package models.dominio.entidades;

import lombok.Getter;
import lombok.Setter;
import models.dominio.trabajos.Persistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EntidadPrestadora")
public class EntidadPrestadora extends Persistente {
    @Setter
    @Getter
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "entidadPrestadora", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Entidad> entidades = new ArrayList<>();
    public EntidadPrestadora() {

    }
}
