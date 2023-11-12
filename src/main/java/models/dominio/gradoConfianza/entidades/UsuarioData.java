package models.dominio.gradoConfianza.entidades;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UsuarioData {
  @Getter
  @Setter
  @SerializedName("username")
  public String username;
  @Getter
  @Setter
  @SerializedName("incidentesAbiertos")
  public List<IncidenteAux> incidentesAbiertos;
  @Getter
  @Setter
  @SerializedName("incidentesCerrados")
  public List<IncidenteAux> incidentesCerrados;
}
