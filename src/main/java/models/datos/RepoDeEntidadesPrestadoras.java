package models.datos;

import models.dominio.entidades.EntidadPrestadora;

import java.util.List;

public class RepoDeEntidadesPrestadoras extends Repo{
  public List<EntidadPrestadora> getEntidadesPrestadoras(){
    return entityManager().createQuery("from " + EntidadPrestadora.class.getName()).getResultList();
  }
  public EntidadPrestadora findById(Long id) {
    return entityManager().find(EntidadPrestadora.class, id);
  }

}