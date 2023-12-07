package server.models.datos;

import models.dominio.usuario.Comunidad;
import server.models.dominio.usuario.Comunidad;
import server.models.dominio.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepoDeComunidades {
    public List<Comunidad> getComunidades(){
        //return entityManager().createQuery("from " + Comunidad.class.getName()).getResultList();
        return new ArrayList<Comunidad>();
    }
    public List<Comunidad> getComunidadesParaElegir(Long id) {
    /*
        RepoDeUsuarios repoDeUsuarios = new RepoDeUsuarios();
        Usuario usuario = repoDeUsuarios.findById(id);
        List<Long> ids = usuario.comunidades().stream().map(c -> c.getId()).toList();
        if(ids.isEmpty() || ids == null){
            return this.getComunidades();
        }
        return entityManager()
                .createQuery("from "+Comunidad.class.getName()+" c WHERE c.id NOT IN :lista")
                .setParameter("lista",ids)
                .getResultList();
*/
        return new ArrayList<Comunidad>();
    }
    /*public List<Comunidad> buscarComunidadesDeUnUsuario(Long usuario_id){
        return (List<Comunidad>) entityManager()
                .createQuery("FROM "+Comunidad.class.getName()+" c " +
                        "JOIN c.miembros m " +
                        "WHERE m.usuario_id = :usuario_id")
                .setParameter("usuario_id", usuario_id)
                .getResultList();
    }*/
    public List<Comunidad> buscarComunidadesDeUnUsuario(Long usuario_id){
        /*return (List<Comunidad>) entityManager()
                .createQuery("FROM "+Comunidad.class.getName()+" c " +
                        "JOIN miembros m ON (c.id = m.comunidad_id) " +
                        "WHERE m.usuario_id = :usuario_id")
                .setParameter("usuario_id", usuario_id)
                .getResultList();*/
        return new ArrayList<Comunidad>();
    }

    public Comunidad findById(Long id) {
        //return entityManager().find(Comunidad.class, id);
        return new Comunidad();
    }
}
