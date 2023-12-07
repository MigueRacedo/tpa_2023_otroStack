package server.models.dominio.servicios;
import jakarta.persistence.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.entidades.OrganismoDeControl;
import server.models.dominio.trabajos.Persistente;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;

@Entity
//@Access(AccessType.PROPERTY)

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
