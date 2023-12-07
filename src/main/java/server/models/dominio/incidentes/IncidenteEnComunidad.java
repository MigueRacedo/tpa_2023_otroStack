package server.models.dominio.incidentes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import server.models.datos.*;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.usuario.Comunidad;
import server.models.dominio.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;

@Entity
//@Access(AccessType.PROPERTY)

@Getter
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
    /*public void cerrar(Usuario usuario){
        RepoDeIncidentesEnComunidades repoDeIncidentesEnComunidades = new RepoDeIncidentesEnComunidades();
        this.setAbierto(false);
        this.fechaYHoraFinal = LocalDateTime.now();
        this.usuarioFinal = usuario;
        //repoDeIncidentesEnComunidades.actualizar(this);
    }*/
}
