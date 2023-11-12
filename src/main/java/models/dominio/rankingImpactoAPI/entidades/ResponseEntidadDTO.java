package models.dominio.rankingImpactoAPI.entidades;

import lombok.Getter;
import lombok.Setter;

public class ResponseEntidadDTO {
  @Setter
  @Getter
  public int idEntidad;
  @Setter
  @Getter
  public int nivelImpactoEntidad;
  @Setter
  @Getter
  public int puestoRanking;
}
