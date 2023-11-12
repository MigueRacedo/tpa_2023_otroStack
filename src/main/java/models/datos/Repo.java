package models.datos;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

public abstract class Repo implements WithSimplePersistenceUnit{
    public <T> void persistir(T entidad){
        entityManager().getTransaction().begin();
        entityManager().persist(entidad);
        entityManager().getTransaction().commit();
        entityManager().close();
    }
    public <T> void actualizar(T entidad){
        entityManager().getTransaction().begin();
        entityManager().merge(entidad);
        entityManager().getTransaction().commit();
        entityManager().close();
    }
}
