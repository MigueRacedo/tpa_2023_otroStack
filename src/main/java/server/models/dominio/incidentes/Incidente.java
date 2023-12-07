package server.models.dominio.incidentes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.entidades.Establecimiento;
import server.models.dominio.notificador.Notificacion;
import server.models.dominio.servicios.Servicio;
import server.models.dominio.trabajos.Persistente;
import server.models.dominio.usuario.Comunidad;
import server.models.dominio.usuario.Usuario;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Incidente")
public class Incidente extends Persistente {
    @Getter
    @Setter
    @Column(name = "descripcion")
    private String descripcion;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "establecimiento_id")
    private Establecimiento establecimiento;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
    @Getter
    @Column(name = "fechaYHoraInicial")
    private LocalDateTime fechaYHoraInicial;
    @Getter
    @Setter
    @Column(name = "fechaYHoraFinal", nullable = true)
    private LocalDateTime fechaYHoraFinal;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuarioInicial;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incidente_original", referencedColumnName = "id")
    private Incidente incidenteOriginal;
    @Getter
    @OneToMany(mappedBy = "incidente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<IncidenteEnComunidad> incidentesAsociados = new ArrayList<>();

    public Incidente(){
        this.fechaYHoraInicial = LocalDateTime.now();
    }
    /*public void abrir(){
        RepoDeIncidentes repo = new RepoDeIncidentes();
        Incidente incidenteOriginal = repo.incidenteOriginal(this);
        this.setIncidenteOriginal(incidenteOriginal);

        List<Comunidad> comunidades = usuarioInicial.comunidades();
        comunidades.stream().forEach(c -> this.crearIncidenteEnComunidad(c));
        repo.persistir(this);
        String mensajeNotificacion = "El servicio " + servicio.getNombre() + " no esta disponible en " + establecimiento.getNombre();

        List<Usuario> usuariosApertura = this.usuariosANotificarApertura(usuarioInicial);
        this.notificar(usuariosApertura,"Nuevo Incidente", mensajeNotificacion, this.getFechaYHoraInicial());
    }*/
    /*public void crearIncidenteEnComunidad(Comunidad c){
        IncidenteEnComunidad incidenteEnComunidad = new IncidenteEnComunidad();
        incidenteEnComunidad.setComunidad(c);
        incidenteEnComunidad.setIncidente(this);
        incidenteEnComunidad.setAbierto(true);
        this.agregarIncidenteAsociado(incidenteEnComunidad);
    }*/
    /*public void cerrar(Usuario usuario){
        RepoDeIncidentes repoDeIncidentes = new RepoDeIncidentes();
        if(fechaYHoraFinal == null){
            this.setFechaYHoraFinal(LocalDateTime.now());
        }
        this.cerrarParaComunidadesDe(usuario);
        //repoDeIncidentes.actualizar(this);
        List<Usuario> usuarios = this.usuariosANotificarCierre(usuario);
        String mensajeNotificacion = "El servicio " + servicio.getNombre() + " ya esta disponible en " + establecimiento.getNombre();
        this.notificar(usuarios, "Cierre de Incidente", mensajeNotificacion, this.fechaYHoraInicial);
    }
    public void agregarIncidenteAsociado(IncidenteEnComunidad i){
        this.incidentesAsociados.add(i);
    }*/

    public void cerrarParaComunidadesDe(Usuario usuario){
    }
    public List<Usuario> usuariosANotificarApertura(Usuario usuario){
        return new ArrayList<>();
    }
    public List<Usuario> usuariosANotificarCierre(Usuario usuario){
        return new ArrayList<>();
    }
    public void notificar(List<Usuario> usuarios, String asunto, String mensaje, LocalDateTime fecha){

    }
    public List<Comunidad> comunidades(){
        return usuarioInicial.comunidades();
    }
    public Boolean estaResuelto(){
        return fechaYHoraFinal != null;
    }

    public boolean esOriginal() {
        return this.incidenteOriginal == this;
    }
    public void setIncidenteOriginal(Incidente i){
        this.incidenteOriginal = i;
    }
    public Boolean esDeEstaSemana() {
        Period period = Period.between(this.fechaYHoraInicial.toLocalDate(), LocalDateTime.now().toLocalDate());
        return period.getDays() < 7;
    }
    public Boolean hayDiferenciaDe24HorasConOriginal() {
        return ChronoUnit.HOURS.between(this.fechaYHoraInicial, this.incidenteOriginal.getFechaYHoraInicial()) >= 24;
    }
    public Boolean afectaA(Usuario usuario){
        return usuario.comunidades().stream().anyMatch(c->this.comunidades().contains(c));
    }

    public LocalDateTime getFechaYHoraInicial() {
        return fechaYHoraInicial;
    }
    public LocalDateTime getFechaYHoraFinal() {
        return fechaYHoraFinal;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }
    public void setFechaYHoraFinal(LocalDateTime fechaYhora){ this.fechaYHoraFinal = fechaYhora;}
    public Notificacion crearNotificacion(String asunto, String mensaje, LocalDateTime fechaYhora, Usuario usuario){
        Notificacion noti = new Notificacion();
        noti.setAsunto(asunto);
        noti.setMensaje(mensaje);
        noti.setFecha(fechaYhora);
        noti.setDestinatario(usuario);
        return noti;
    }
}
