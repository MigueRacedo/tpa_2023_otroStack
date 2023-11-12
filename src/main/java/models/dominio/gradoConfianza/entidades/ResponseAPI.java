package models.dominio.gradoConfianza.entidades;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class ResponseAPI {
  @Setter
  @Getter
  @SerializedName("nombre")
  public String nombre;
  @Setter
  @Getter
  @SerializedName("confianza")
  public String confianza;
}
