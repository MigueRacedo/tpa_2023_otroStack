package models.dominio.gradoConfianza.entidades;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ComunidadData {
  @Getter
  @Setter
  @SerializedName("nombre")
  public String nombre;
  @Getter
  @Setter
  @SerializedName("usuarios")
  public List<UsuarioData> usuarios;
}
