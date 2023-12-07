package server.models.dominio.georef.entidades;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.usuario.Permiso;

@Entity
//@Access(AccessType.PROPERTY)

@Table(name = "departamento")
public class Departamento extends Persistente {
    @Setter
    @Getter
    @Column(name = "nombre")
    private String nombre;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;
}
