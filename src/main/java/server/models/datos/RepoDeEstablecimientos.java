package server.models.datos;

import server.models.dominio.entidades.Establecimiento;

import java.util.List;

public class RepoDeEstablecimientos {
    public Establecimiento findById(Long id) {
        //return entityManager().find(Establecimiento.class, id);
        return
    }
    public List<Establecimiento> getEstablecimientos(){
        return entityManager().createQuery("from " + Establecimiento.class.getName()).getResultList();
    }
}
