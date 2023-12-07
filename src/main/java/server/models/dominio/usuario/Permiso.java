package server.models.dominio.usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;

@Entity
//@Access(AccessType.PROPERTY)

@Table(name = "permiso")
@Setter
@Getter
public class Permiso extends Persistente {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombreInterno")
    private String nombreInterno;

    public boolean coincideConNombreInterno(String nombre) {
        return this.nombreInterno.equals(nombre);
    }
}