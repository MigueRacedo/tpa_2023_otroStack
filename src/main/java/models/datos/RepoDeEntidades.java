package models.datos;

import models.dominio.entidades.Entidad;

import java.util.List;

public class RepoDeEntidades extends Repo {
    public List<Entidad> getEntidades(){
        return entityManager().createQuery("from " + Entidad.class.getName()).getResultList();
    }
    public Entidad findById(Long id) {
        return entityManager().find(Entidad.class, id);
    }

}
