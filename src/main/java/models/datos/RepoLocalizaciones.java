package models.datos;

import models.dominio.georef.entidades.Departamento;
import models.dominio.georef.entidades.Provincia;

import java.util.List;

public class RepoLocalizaciones extends Repo{
    public List<Provincia> getProvincias(){
        return entityManager().createQuery("from " + Provincia.class.getName()).getResultList();
    }
    public List<Departamento> getDepartamentos(){
        return entityManager().createQuery("from " + Departamento.class.getName()).getResultList();
    }
    public Provincia findProvinciaById(String id){
        return entityManager().find(Provincia.class, id);
    }
    public Departamento findDepartamentoById(String id){
        return entityManager().find(Departamento.class, id);
    }
}
