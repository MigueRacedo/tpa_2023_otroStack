package server.models.dominio.servicios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.entidades.OrganismoDeControl;
import server.models.dominio.trabajos.Persistente;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_servicio", discriminatorType = DiscriminatorType.STRING)
@Table(name = "servicio")
public abstract class Servicio extends Persistente {
    @Column(name = "nombre")
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "organismoDeControl_id", referencedColumnName = "id")
    private OrganismoDeControl organismoDeControl;
    @Setter
    @Getter
    @Column(name = "imagen")
    private String imagen;
    Boolean esElMismoServicio(Servicio servicio){ return false;}
}
