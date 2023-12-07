package server.models.dominio.notificador;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.usuario.Usuario;
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
