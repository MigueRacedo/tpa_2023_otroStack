package server.models.dominio.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.servicios.Servicio;
import server.models.dominio.trabajos.Persistente;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;

@Entity
//@Access(AccessType.PROPERTY)

@Table(name = "OrganismoDeControl")
public class OrganismoDeControl extends Persistente {
    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "organismoDeControl", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Servicio> servicios = new ArrayList<>();
    public OrganismoDeControl() {

    }
}
