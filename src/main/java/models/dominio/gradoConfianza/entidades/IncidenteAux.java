package models.dominio.gradoConfianza.entidades;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class IncidenteAux {
  @Getter
  @Setter
  @SerializedName("fechaApertura")
  public LocalDateTime fechaApertura;
  @Getter
  @Setter
  @SerializedName("fechaCierre")
  public LocalDateTime fechaCierre;
}
