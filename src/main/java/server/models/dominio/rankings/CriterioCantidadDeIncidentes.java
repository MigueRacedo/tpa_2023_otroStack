package server.models.dominio.rankings;

import lombok.Getter;
import server.models.datos.RepoDeIncidentes;
import server.models.dominio.entidades.Entidad;
import server.models.dominio.incidentes.Incidente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriterioCantidadDeIncidentes extends Criterio{
  @Getter
  String nombre = "Cantidad de Incidentess";

  private static CriterioCantidadDeIncidentes instancia = null;
  public static CriterioCantidadDeIncidentes getInstance(){
    if(instancia == null){
      instancia = new CriterioCantidadDeIncidentes();
    }
    return instancia;
  }
  /*@Override
  protected List<Incidente> obtenerIncidentes() {
    RepoDeIncidentes repo = new RepoDeIncidentes();
    return repo.getIncidentes().stream().filter(i -> i.esDeEstaSemana() && (i.esOriginal() || i.hayDiferenciaDe24HorasConOriginal())).toList();
  }*/

  @Override
  protected List<Map.Entry<Entidad, Double>> generarListado(List<Incidente> lista) {
    Map<Entidad, Double> cantidadIncidentesPorEntidad = new HashMap<>();

    for (Incidente incidente : lista) {
      Entidad entidad = incidente.getEstablecimiento().getEntidad();
      cantidadIncidentesPorEntidad.put(entidad, cantidadIncidentesPorEntidad.getOrDefault(entidad, 0.0) + 1);
    }
    return new ArrayList<>(cantidadIncidentesPorEntidad.entrySet());
  }
}
