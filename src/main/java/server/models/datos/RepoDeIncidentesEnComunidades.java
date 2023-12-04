package models.datos;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import models.dominio.incidentes.IncidenteEnComunidad;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class RepoDeIncidentesEnComunidades extends Repo implements WithSimplePersistenceUnit {

    public List<IncidenteEnComunidad> incidentesDeComunidad(Long id) {
        /*return entityManager().createQuery(" FROM "+IncidenteEnComunidad.class.getName()+" WHERE comunidad_id = :u")
                .setParameter("u", id)
                .getResultList();*/ //TODO Ver el nombre de la entidad incidente en comunidad

        Session session = entityManager().unwrap(Session.class);

        String sql = "SELECT * FROM indicente_en_comunidad  WHERE comunidad_id = :u";//TODO cambiar el nombre indicente

        NativeQuery<IncidenteEnComunidad> query = session.createNativeQuery(sql, IncidenteEnComunidad.class);
        query.setParameter("u", id);

        List<IncidenteEnComunidad> incidentes = query.getResultList();
        return incidentes;
    }
}
