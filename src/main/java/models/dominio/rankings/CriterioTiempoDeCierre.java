package models.dominio.rankings;

import lombok.Getter;
import models.datos.RepoDeIncidentes;
import models.dominio.entidades.Entidad;
import models.dominio.incidentes.Incidente;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriterioTiempoDeCierre extends Criterio {
  @Getter
  String nombre = "Tiempo de Cierre";

  /*private static CriterioTiempoDeCierre instancia = null;
  public static CriterioTiempoDeCierre getInstance(){
    if(instancia == null){
      instancia = new CriterioTiempoDeCierre();
    }
    return instancia;
  }*/
  /*@Override
  public List<Incidente> obtenerIncidentes() {
    RepoDeIncidentes repo = new RepoDeIncidentes();
    return repo.getIncidentes().stream().filter(i -> i.estaResuelto() && i.esDeEstaSemana()).toList();
  }*/

  @Override
  public List<Map.Entry<Entidad, Double>> generarListado(List<Incidente> lista) {
    Map<Entidad, Duration> sumaTiemposResolucionPorEntidad = new HashMap<>();
    Map<Entidad, Integer> contadorIncidentesPorEntidad = new HashMap<>();

    for (Incidente incidente : lista) {
      Entidad entidad = incidente.getEstablecimiento().getEntidad();
      LocalDateTime tiempoInicio = incidente.getFechaYHoraInicial();
      LocalDateTime tiempoCierre = incidente.getFechaYHoraFinal();
      Duration tiempoResolucion = Duration.between(tiempoInicio, tiempoCierre);

      sumaTiemposResolucionPorEntidad.merge(entidad, tiempoResolucion, Duration::plus);
      contadorIncidentesPorEntidad.merge(entidad, 1, Integer::sum);
    }

    Map<Entidad, Double> tiempoPromedioResolucionPorEntidad = new HashMap<>();

    for (Map.Entry<Entidad, Duration> entry : sumaTiemposResolucionPorEntidad.entrySet()) {
      Entidad entidad = entry.getKey();
      Duration sumaTiemposResolucion = entry.getValue();
      int contadorIncidentes = contadorIncidentesPorEntidad.getOrDefault(entidad, 0);

      if (contadorIncidentes > 0) {
        double tiempoPromedioResolucion = (sumaTiemposResolucion.getSeconds() / (double) contadorIncidentes)/3600;
        tiempoPromedioResolucionPorEntidad.put(entidad, tiempoPromedioResolucion);
      }
    }
    return new ArrayList<>(tiempoPromedioResolucionPorEntidad.entrySet());
  }
}
