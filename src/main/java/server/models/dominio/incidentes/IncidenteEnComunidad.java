package server.models.dominio.incidentes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.usuario.Comunidad;
import server.models.dominio.usuario.Usuario;

import java.time.LocalDateTime;

@Entity
//@Access(AccessType.PROPERTY)

@Getter
@Table(name = "IncidenteEnComunidad")
//@IdClass(IncidenteEnComunidad.class)
public class IncidenteEnComunidad extends Persistente{
    //@Id
    @Setter
    @ManyToOne
    @JoinColumn(name = "incidente_id", referencedColumnName = "id")
    private Incidente incidente;
    @Setter
    //@Id
    @ManyToOne
    @JoinColumn(name = "comunidad_id", referencedColumnName = "id")
    private Comunidad comunidad;
    private Boolean abierto;
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuarioFinal;
    @Setter
    @Column(name = "fechaYHoraFinal", nullable = true)
    private LocalDateTime fechaYHoraFinal;
    public IncidenteEnComunidad(){
        this.abierto = true;
    }


    public void setAbierto(Boolean abierto){
        this.abierto = abierto;
    }
    /*public void cerrar(Usuario usuario){
        RepoDeIncidentesEnComunidades repoDeIncidentesEnComunidades = new RepoDeIncidentesEnComunidades();
        this.setAbierto(false);
        this.fechaYHoraFinal = LocalDateTime.now();
        this.usuarioFinal = usuario;
        //repoDeIncidentesEnComunidades.actualizar(this);
    }*/
}
