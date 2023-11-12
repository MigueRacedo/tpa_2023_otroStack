package models.dominio.entidades;

import lombok.Getter;
import lombok.Setter;
import models.dominio.trabajos.Persistente;

import javax.persistence.*;
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
    private models.dominio.georef.entidades.Localizacion Localizacion;
    @OneToMany(mappedBy = "entidad", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Establecimiento> establecimientos = new ArrayList<>();
    public Entidad() {
        this.nombre = nombre;
    }
    public void setNombre(String nombre){ this.nombre = nombre;}
    public void agregarEstablecimiento(Establecimiento establecimiento){
        this.establecimientos.add(establecimiento);
        establecimiento.setEntidad(this);
    }
}
