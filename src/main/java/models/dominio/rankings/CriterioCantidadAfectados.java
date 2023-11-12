package models.dominio.rankings;

import lombok.Getter;
import models.datos.RepoDeIncidentes;
import models.datos.RepoDeUsuarios;
import models.dominio.entidades.Entidad;
import models.dominio.incidentes.Incidente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriterioCantidadAfectados extends Criterio{
  @Getter
  String nombre = "Cantidad de Afectados";

  //Singleton
  private static CriterioCantidadAfectados instancia = null;
  public static CriterioCantidadAfectados getInstance(){
    if(instancia == null){
      instancia = new CriterioCantidadAfectados();
    }
    return instancia;
  }
  @Override
  protected List<Incidente> obtenerIncidentes() {
    RepoDeIncidentes repo = new RepoDeIncidentes();
    return repo.getIncidentes().stream().filter(i -> i.esDeEstaSemana() && i.esOriginal()).toList();
  }

  @Override
  protected List<Map.Entry<Entidad, Double>> generarListado(List<Incidente> lista) {
    RepoDeUsuarios repo = new RepoDeUsuarios();
    Map<Entidad, Double> cantidadAfectadosPorIncidente = new HashMap<>();

    for (Incidente incidente : lista) {
      Entidad entidad = incidente.getEstablecimiento().getEntidad();
      Integer afectados = repo.getUsuarios().stream().filter(u->u.esAfectado(incidente.getServicio()) && u.tieneInteresEn(incidente.getServicio(), incidente.getEstablecimiento())).toList().size();
      cantidadAfectadosPorIncidente.put(entidad, cantidadAfectadosPorIncidente.getOrDefault(entidad, 0.0) + afectados);
    }
    return new ArrayList<>(cantidadAfectadosPorIncidente.entrySet());
  }
}
