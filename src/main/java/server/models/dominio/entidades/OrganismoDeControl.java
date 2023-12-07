package server.models.dominio.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.servicios.Servicio;
import server.models.dominio.trabajos.Persistente;

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
