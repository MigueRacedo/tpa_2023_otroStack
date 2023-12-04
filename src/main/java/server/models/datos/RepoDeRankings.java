package models.datos;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import models.dominio.rankings.Criterio;
import models.dominio.rankings.Ranking;

public class RepoDeRankings extends Repo implements WithSimplePersistenceUnit {
    public Ranking getRanking(Criterio criterio){
        try{
            return (Ranking) entityManager()
                    .createQuery("FROM "+Ranking.class.getName()+" r WHERE r.id = (SELECT MAX(ra.id) FROM "+Ranking.class.getName()+" ra WHERE ra.nombre = :nombreCriterio)")
                    .setParameter("nombreCriterio", criterio.getNombre())
                    .getSingleResult();
        }
        catch (Exception e){
            return null;
        }

    }
}
