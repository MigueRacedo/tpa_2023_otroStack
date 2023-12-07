package server.models.dominio.usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.incidentes.Incidente;
import server.models.dominio.incidentes.IncidenteEnComunidad;
import server.models.dominio.servicios.Servicio;
import server.models.dominio.trabajos.Persistente;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
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
    public List<Usuario> getAfectadosPor(Servicio servicio){
        return miembros.stream().filter(u -> u.esAfectado(servicio)).toList();
    }
    public List<IncidenteEnComunidad> getIncidentes(){

        return new ArrayList<>();
    }
    public void cerrar(Incidente incidente, Usuario usuario){
        IncidenteEnComunidad incidenteEnComunidad = this.getIncidentes().stream()
                .filter(i -> i.getIncidente().equals(incidente)) //TODO comparar Ids
                .findFirst().orElseThrow(()->new RuntimeException("No encuentra el incidente"));//orElse(null);

        incidenteEnComunidad.cerrar(usuario);
    }
    public void eliminarMiembro(Usuario usuario){
        this.miembros.remove(usuario);
    }
}
