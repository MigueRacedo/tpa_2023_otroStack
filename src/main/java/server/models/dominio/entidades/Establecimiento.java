package server.models.dominio.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.georef.entidades.Localizacion;
import server.models.dominio.servicios.Servicio;
import server.models.dominio.trabajos.Persistente;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Establecimiento")
public class Establecimiento extends Persistente {
    @Setter
    @Getter
    @Column(name = "nombre")
    private String nombre;
    @Setter
    @Getter
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "localizacion_id")
    private Localizacion localizacion;
    @Getter
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "establecimiento_servicio",
            joinColumns = @JoinColumn(name = "id_establecimiento"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private List<Servicio> listaDeServicios;
    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidad_id", referencedColumnName = "id")
    private Entidad entidad;

    public Establecimiento(){
        this.listaDeServicios = new ArrayList<>();
    }

}
