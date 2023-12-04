package models.dominio.rankings;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GeneradorDeRankingSemanal {

  private static GeneradorDeRankingSemanal instancia = null;
  public static GeneradorDeRankingSemanal getInstance(){
    if(instancia == null){
      instancia = new GeneradorDeRankingSemanal();
    }
    return instancia;
  }
  /*public Ranking generarRankingSegunCriterio(Criterio criterio){
    Ranking nuevoRanking = new Ranking();
    nuevoRanking.setNombre(criterio.getNombre());
    nuevoRanking.setValorRankings(criterio.generarRanking());
    return nuevoRanking;
  }*/
}
