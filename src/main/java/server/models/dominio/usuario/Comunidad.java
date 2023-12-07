package server.models.dominio.usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.incidentes.Incidente;
import server.models.dominio.incidentes.IncidenteEnComunidad;
import server.models.dominio.servicios.Servicio;
import server.models.dominio.trabajos.Persistente;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;

@Entity
//@Access(AccessType.PROPERTY)
@Getter
@Table(name = "Comunidad")
public class Comunidad extends Persistente {
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "miembros",
            joinColumns = @JoinColumn(name = "comunidad_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> miembros;
    public Comunidad() {
        this.miembros = new ArrayList<>();
    }

    public void agregarMiembro(Usuario unMiembro) {
        this.miembros.add(unMiembro);
    }
    public List<Usuario> getMiembros(){ return miembros;}

    /*public List<IncidenteEnComunidad> getIncidentes(){
        RepoDeIncidentesEnComunidades repo = new RepoDeIncidentesEnComunidades();
        return repo.incidentesDeComunidad(this.getId());
        //return this.incidentes;
    }*/
    /*public void cerrar(Incidente incidente, Usuario usuario){
        IncidenteEnComunidad incidenteEnComunidad = this.getIncidentes().stream()
                .filter(i -> i.getIncidente().equals(incidente)) //TODO comparar Ids
                .findFirst().orElseThrow(()->new RuntimeException("No encuentra el incidente"));//orElse(null);

        incidenteEnComunidad.cerrar(usuario);
    }*/
    public void eliminarMiembro(Usuario usuario){
        this.miembros.remove(usuario);
    }
}
