package models.dominio.entidades;

import lombok.Getter;
import lombok.Setter;
import models.dominio.servicios.Servicio;
import models.dominio.trabajos.Persistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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
