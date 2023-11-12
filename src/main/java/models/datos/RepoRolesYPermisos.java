package models.datos;

import models.dominio.usuario.Permiso;
import models.dominio.usuario.Rol;

import java.util.List;

public class RepoRolesYPermisos extends Repo{
    public List<Rol> getRoles(){
        return entityManager().createQuery("from " + Rol.class.getName()).getResultList();
    }
    public List<Permiso> getPermisos(){
        return entityManager().createQuery("from " + Permiso.class.getName()).getResultList();
    }
    public Rol getRolByNombre(String nombre){
        return (Rol) entityManager().createQuery("FROM "+Rol.class.getName()+" where nombre = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
    }
}
