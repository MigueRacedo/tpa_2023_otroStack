package models.dominio.notificador;

import lombok.Getter;
import lombok.Setter;
import models.dominio.trabajos.Persistente;
import models.dominio.usuario.Usuario;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
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
