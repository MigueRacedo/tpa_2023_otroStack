package models.datos;

import models.dominio.usuario.Comunidad;
import models.dominio.usuario.Usuario;

import java.util.List;

public class RepoDeUsuarios extends Repo {
    public List<Usuario> usuariosDe(List<Comunidad> comunidades){
        List<Long> ids = comunidades.stream().map(c ->c.getId()).toList();
        return entityManager()
                .createQuery("SELECT DISTINCT u FROM "+Usuario.class.getName()+" u JOIN u.comunidades c WHERE c.id IN :lista")
                .setParameter("lista", ids)
                .getResultList();
    }

    public Usuario findById(Long id) {
        return entityManager().find(Usuario.class, id);
    }
    public Usuario findByUsername(String username, String password) {
        try{
            return (Usuario) entityManager()
                    .createQuery("FROM "+Usuario.class.getName()+" u WHERE nombre_usuario = :usuario AND contraseña = :contrasenia")
                    .setParameter("usuario", username)
                    .setParameter("contrasenia", password)
                    .getSingleResult();
        }
        catch (Exception e){
            return null;
        }

    }

    public List<Usuario> getUsuarios() {
        return entityManager().createQuery("from " + Usuario.class.getName()).getResultList();
    }
}
