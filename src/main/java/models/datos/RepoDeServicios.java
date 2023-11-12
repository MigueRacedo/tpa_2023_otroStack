package models.datos;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import models.dominio.servicios.Servicio;

import java.util.List;

public class RepoDeServicios extends Repo implements WithSimplePersistenceUnit {
    public List<Servicio> getServicios(){
        return entityManager().createQuery("from " + Servicio.class.getName()).getResultList();
    }
    public Servicio findById(Long id) {
        return entityManager().find(Servicio.class, id);
    }
}
