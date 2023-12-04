package models.dominio.incidentes;

import lombok.Getter;
import lombok.Setter;
import models.datos.RepoDeIncidentesEnComunidades;
import models.dominio.trabajos.Persistente;
import models.dominio.usuario.Comunidad;
import models.dominio.usuario.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "indicente_En_Comunidad")
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
    @Column(name = "fechaYHoraFinal", columnDefinition = "DATETIME", nullable = true)
    private LocalDateTime fechaYHoraFinal;
    public IncidenteEnComunidad(){
        this.abierto = true;
    }


    public void setAbierto(Boolean abierto){
        this.abierto = abierto;
    }
    public void cerrar(Usuario usuario){
        RepoDeIncidentesEnComunidades repoDeIncidentesEnComunidades = new RepoDeIncidentesEnComunidades();
        this.setAbierto(false);
        this.fechaYHoraFinal = LocalDateTime.now();
        this.usuarioFinal = usuario;
        //repoDeIncidentesEnComunidades.actualizar(this);
    }
}
