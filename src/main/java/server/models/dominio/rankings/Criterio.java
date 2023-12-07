package server.models.dominio.rankings;

import lombok.Getter;
import server.models.dominio.entidades.Entidad;
import server.models.dominio.incidentes.Incidente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public abstract class Criterio {
  @Getter
  String nombre;
  /*public List<ValorRanking> generarRanking(){
    List<Incidente> incidentes = this.obtenerIncidentes();
    System.out.println("Incidentes "+ incidentes.size());
    List<Map.Entry<Entidad,Double>> rankingMap = this.generarListado(incidentes);
    System.out.println("RankingMap "+ rankingMap.size());
    rankingMap.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    return this.convertirAValoresDeDominio(rankingMap);
  }*/
  //protected abstract List<Incidente> obtenerIncidentes();
  protected abstract  List<Map.Entry<Entidad, Double>> generarListado(List<Incidente> lista);
  public List<ValorRanking> convertirAValoresDeDominio(List<Map.Entry<Entidad, Double>> lista){
    List<ValorRanking> listaAdevolver = new ArrayList<>();

    lista.stream().forEach(e -> listaAdevolver.add(this.crearValor(e.getKey(), e.getValue())));
    return listaAdevolver;
  }
  public ValorRanking crearValor(Entidad entidad, Double valor){
    ValorRanking valorRanking = new ValorRanking();
    valorRanking.setValor(valor);
    valorRanking.setEntidad(entidad);
    return valorRanking;
  }
}

