package models.dominio.rankingImpactoAPI.entidades;

import lombok.Getter;
import lombok.Setter;

public class RequestEntidadDTO {
  @Setter
  @Getter
  public int idEntidad;
  @Setter
  @Getter
  public int sumatoriaTiemposResolucion;
  @Setter
  @Getter
  public int cantidadIncidentesNoResueltos;
  @Setter
  @Getter
  public int cantidadMiembrosAfectados;
}
