package server.models.dominio.entidades;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.servicios.Servicio;
import server.models.dominio.trabajos.Persistente;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;

@Entity
//@Access(AccessType.PROPERTY)

@Table(name = "Establecimiento")
public class Establecimiento extends Persistente {
    @Setter
    @Getter
    @Column(name = "nombre")
    private String nombre;
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
    public void agregarServicio(Servicio unServicio) {
        this.listaDeServicios.add(unServicio);
    }

}
