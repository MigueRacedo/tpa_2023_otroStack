package server.models.dominio.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.georef.entidades.Localizacion;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Entidad")
public class Entidad extends Persistente {
    @Setter
    @Getter
    @Column(name = "nombre")
    private String nombre;
    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidadPrestadora_id", referencedColumnName = "id")
    private EntidadPrestadora entidadPrestadora;
    @Setter
    @Getter
    @OneToOne(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "localizacion_id")
    private Localizacion localizacion;
    @OneToMany(mappedBy = "entidad", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Establecimiento> establecimientos = new ArrayList<>();
}
