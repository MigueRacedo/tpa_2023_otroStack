package server.models.dominio.georef.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.usuario.Permiso;

@Entity
//@Access(AccessType.PROPERTY)

@Table(name = "provincia")
public class Provincia extends Persistente {
    @Setter
    @Getter
    @Column(name = "nombre")
    public String nombre;
    @Getter
    @Setter
    @OneToMany(mappedBy = "provincia", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Departamento> departamentos;
}
