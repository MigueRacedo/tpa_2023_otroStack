package server.models.dominio.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;

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
