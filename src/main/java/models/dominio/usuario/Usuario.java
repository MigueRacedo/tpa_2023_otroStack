package models.dominio.usuario;

import lombok.Getter;
import lombok.Setter;
import models.datos.RepoDeIncidentes;
import models.datos.RepoDeNotificaciones;
import models.dominio.converter.MedioNotificacionConverter;
import models.dominio.converter.ModoNotificacionConverter;
import models.dominio.entidades.Entidad;
import models.dominio.entidades.Establecimiento;
import models.dominio.georef.entidades.Localizacion;
import models.dominio.notificador.Horario;
import models.dominio.notificador.MedioNofiticacion;
import models.dominio.notificador.ModoNotificacion;
import models.dominio.notificador.Notificacion;
import models.dominio.servicios.Servicio;
import models.dominio.trabajos.Persistente;
import models.dominio.validador.Validador;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario extends Persistente {

    @Getter
    @Column(name = "nombre_usuario")
    private String username;
    @Column(name = "contraseña")
    private String contrasenia;
    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "loc_interes")
    private Localizacion LocalizacionDeInteres;
    @Getter
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "loc_actual")
    private Localizacion LocalizacionActual;
    @Getter
    @Column(name="fecha_contrasenia")
    private LocalDateTime ultimoCambioContrasenia;
    @ManyToMany(mappedBy = "miembros", fetch = FetchType.LAZY)
    private List<Comunidad> comunidades = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}/*, fetch = FetchType.LAZY*/)
    @JoinTable(
            name = "entidades_de_interes",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_entidad")
    )
    private List<Entidad> entidadesDeInteres = new ArrayList<>();
    @Getter
    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<InteresServicio> serviciosDeInteres = new ArrayList<>();

    @Getter
    @Setter
    @Convert(converter = MedioNotificacionConverter.class)
    @Column(name = "medio")
    private MedioNofiticacion medio;
    @Getter
    @Setter
    @Convert(converter = ModoNotificacionConverter.class)
    @Column(name = "modo")
    private ModoNotificacion modo;
    @Getter
    @OneToMany(mappedBy = "usuario",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Horario> horarios = new ArrayList<>();
    @Getter
    @Setter
    @Column(name = "mail")
    private String mail;
    @Getter
    @Setter
    @Column(name = "telefono")
    private String telefono;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;
    public Usuario(){

    }
    public void setNombreUsuario(String nombreUsuario) {
        this.username = nombreUsuario;
    }
    public void setContrasenia(String contrasenia) {
        Validador.getInstance().validarContrasenia(this.username, contrasenia);
        this.contrasenia = contrasenia;
        this.ultimoCambioContrasenia = LocalDateTime.now();
    }
    public List<Comunidad> comunidades(){
        return this.comunidades;
    }
    public List<Entidad> getEntidadesDeInteres(){return this.entidadesDeInteres;}
    public Boolean tieneInteresEn(Servicio servicio, Establecimiento establecimiento) {
        //try {
            System.out.println(this.getUsername()+" - "+servicio.getNombre()+" - "+establecimiento.getNombre());
            return getEntidadesDeInteres().stream().map(e->e.getId()).toList().contains(establecimiento.getEntidad().getId())
                    && (getServiciosDeInteres().stream().map(i -> i.getServicio().getId()).toList().contains(servicio.getId()));
                    //&& establecimiento.getLocalizacion().esIgualA(this.LocalizacionDeInteres);

        //}
        //catch (Exception e){
         //   return false;
        //}
    }
    public Boolean esAfectado(Servicio servicio){
        return this.getServiciosDeInteres().stream().filter(i->i.getCondicion() == Condicion.AFECTADO).map(s->s.getServicio()).toList().contains(servicio);
    }
    public void setLocalizacionActual(Localizacion localizacionActual) {
        RepoDeIncidentes repo = new RepoDeIncidentes();
        LocalizacionActual = localizacionActual;
        repo.buscarIncidenteCerca(this);
    }
    public Boolean perteneceAAlmenosUnaComunidadDe(List<Comunidad> comunidades){
        return this.comunidades().stream().anyMatch(comunidades::contains);
    }
    public void recibirNotificacion(Notificacion notificacion) {
        this.modo.notificar(notificacion);
    }
    public void agregarNotificacion(Notificacion notificacion){
        this.getNotificacionesPendientes().add(notificacion);
    }
    public List<Notificacion> getNotificacionesPendientes(){
        RepoDeNotificaciones repo = new RepoDeNotificaciones();
        return repo.notificacionesPendientesPorId(this.getId());
    }
    public void agregarServicioDeInteres(InteresServicio servicio){
        this.serviciosDeInteres.add(servicio);
    }
    public void agregarEntidadDeInteres(Entidad e){
        this.entidadesDeInteres.add(e);
    }

}
