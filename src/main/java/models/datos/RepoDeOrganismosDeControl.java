package models.datos;

import models.dominio.entidades.OrganismoDeControl;

import java.util.List;

public class RepoDeOrganismosDeControl extends Repo{
  public List<OrganismoDeControl> getOrganismosDeControl(){
    return entityManager().createQuery("from " + OrganismoDeControl.class.getName()).getResultList();
  }
  public OrganismoDeControl findById(Long id) {
    return entityManager().find(OrganismoDeControl.class, id);
  }
}
