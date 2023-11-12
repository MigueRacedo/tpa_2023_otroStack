package models.datos;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import models.dominio.incidentes.Incidente;
import models.dominio.incidentes.IncidenteEnComunidad;
import models.dominio.notificador.Notificacion;
import models.dominio.usuario.Usuario;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.time.LocalDateTime;
import java.util.List;

public class RepoDeIncidentes extends Repo implements WithSimplePersistenceUnit {
    public List<Incidente> getIncidentes(){
        return entityManager().createQuery("from " + Incidente.class.getName()).getResultList();
    }
    public Incidente findById(Long id) {
        return entityManager().find(Incidente.class, id);
    }
    public Incidente incidenteOriginal(Incidente incidente){
        return this.getIncidentes().stream().filter(i ->
                i.getServicio() == incidente.getServicio() &&
                        i.getEstablecimiento() == incidente.getEstablecimiento() &&
                        i.esOriginal() &&
                        !i.estaResuelto()).findFirst().orElse(incidente);

    }
    public void buscarIncidenteCerca(Usuario usuario){
        if(this.hayIncidenteCerca(usuario)){
            Notificacion notificacion = new Notificacion();
            notificacion.setDestinatario(usuario);
            notificacion.setMensaje("Hay un incidente cercano, fijate si podes confirmar si el servicio sigue inhabilitado");
            notificacion.setAsunto("Revisión manual de incidente");
            notificacion.setFecha(LocalDateTime.now());
            persistir(notificacion);
            usuario.recibirNotificacion(notificacion);
        }
    }
    public Boolean hayIncidenteCerca(Usuario usuario){
        return this.getIncidentes().stream()
                .anyMatch(i -> i.getEstablecimiento().getLocalizacion().esCercana(usuario.getLocalizacionActual()) &&
                        i.afectaA(usuario));
    }
    public List<Incidente> getIncidentesByUsuario(Long id){
        Session session = entityManager().unwrap(Session.class);
        RepoDeUsuarios repoDeUsuarios = new RepoDeUsuarios();
        Usuario usuario = repoDeUsuarios.findById(id);
        List<Long> ids = usuario.comunidades().stream().map(c->c.getId()).toList();
        String sql = "SELECT DISTINCT i.* FROM incidente i JOIN indicente_en_comunidad ic ON (i.id=ic.incidente_id) WHERE ic.comunidad_id IN :u";

        NativeQuery<Incidente> query = session.createNativeQuery(sql, Incidente.class);
        query.setParameter("u", ids);

        List<Incidente> incidentes = query.getResultList();
        return incidentes;
    }

    public List<IncidenteEnComunidad> incidentesCerradosPor(Long id) {
        Session session = entityManager().unwrap(Session.class);

        String sql = "SELECT * FROM incidente_en_comunidad  WHERE usuario_id = :u AND abierto = 0";

        NativeQuery<IncidenteEnComunidad> query = session.createNativeQuery(sql, IncidenteEnComunidad.class);
        query.setParameter("u", id);

        List<IncidenteEnComunidad> incidentesEnComunidad = query.getResultList();
        return incidentesEnComunidad;
    }
    public List<Incidente> incidentesAbiertosPor(Long id) {
        Session session = entityManager().unwrap(Session.class);

        String sql = "SELECT * FROM "+Incidente.class.getName()+"  WHERE usuario_id = :u";

        NativeQuery<Incidente> query = session.createNativeQuery(sql, Incidente.class);
        query.setParameter("u", id);

        List<Incidente> incidentes = query.getResultList();
        return incidentes;
    }
    public List<IncidenteEnComunidad> getIncidentesById(Long id){
        Session session = entityManager().unwrap(Session.class);
        RepoDeUsuarios repoDeUsuarios = new RepoDeUsuarios();
        Usuario usuario = repoDeUsuarios.findById(id);
        String sql = "SELECT * FROM incidente_en_comunidad WHERE usuario_id = :u";

        NativeQuery<IncidenteEnComunidad> query = session.createNativeQuery(sql, IncidenteEnComunidad.class);
        query.setParameter("u", id);

        List<IncidenteEnComunidad> incidentes = query.getResultList();
        return incidentes;
    }
}
