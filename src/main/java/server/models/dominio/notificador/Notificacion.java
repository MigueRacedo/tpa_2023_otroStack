package server.models.dominio.notificador;
import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.usuario.Usuario;

import java.time.LocalDateTime;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;

@Entity
//@Access(AccessType.PROPERTY)

@Getter
@Setter
@Table(name = "Notificacion")
public class Notificacion extends Persistente {

    @Column(name = "asunto")
    private String Asunto;
    @Column(name = "mensaje")
    private String Mensaje;
    @Column(name = "fecha", columnDefinition = "DATE")
    private LocalDateTime fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario destinatario;
    @Column(name = "pendiente")
    private Boolean pendiente;
    public Notificacion(){
        this.pendiente = true;
    }

    public void notificar(){
        this.destinatario.getMedio().notificar(this);
    }
    public void descartar(){
        this.pendiente = false;
    }

}
