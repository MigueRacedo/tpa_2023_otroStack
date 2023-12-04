package models.datos;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import models.dominio.notificador.Notificacion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RepoDeNotificaciones extends Repo implements WithSimplePersistenceUnit {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Notificacion> notificacionesPendientesPorId(Long id) {
        return entityManager()
                .createQuery("SELECT * FROM "+Notificacion.class.getName()+" WHERE usuario_id = :usuario_id AND pendiente = 1")
                .setParameter("usuario_id", id)
                .getResultList();
    }
}
