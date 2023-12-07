package server.models.dominio.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Access(AccessType.PROPERTY)
@Table(name = "Entidad")
public class Entidad extends Persistente {

    @Setter
    @Getter
    @Column(name = "nombre")//, columnDefinition = "VARCHAR(255)")
    private String nombre;

    @OneToMany(mappedBy = "entidad", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Establecimiento> establecimientos = new ArrayList<>();

    public Entidad() {
        // If you intend to initialize properties in the constructor, make sure to do it correctly.
    }

    public void agregarEstablecimiento(Establecimiento establecimiento){
        this.establecimientos.add(establecimiento);
        establecimiento.setEntidad(this);
    }
}
