package server.models.dominio.notificador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalTime;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;

@Entity
//@Access(AccessType.PROPERTY)

@Table(name = "horario")
public class Horario extends Persistente {
    @Setter
    @Getter
    @Column(name = "horario")
    private LocalTime horario;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    public Horario(){

    }

}
