package models.dominio.usuario;

import lombok.Getter;
import lombok.Setter;
import models.dominio.trabajos.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
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