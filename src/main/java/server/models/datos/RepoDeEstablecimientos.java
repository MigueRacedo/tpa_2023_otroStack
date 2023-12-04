package models.datos;

import models.dominio.entidades.Establecimiento;

import java.util.List;

public class RepoDeEstablecimientos extends Repo{
    public Establecimiento findById(Long id) {
        return entityManager().find(Establecimiento.class, id);
    }
    public List<Establecimiento> getEstablecimientos(){
        return entityManager().createQuery("from " + Establecimiento.class.getName()).getResultList();
    }
}
