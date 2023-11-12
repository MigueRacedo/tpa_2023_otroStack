package models.dominio.gradoConfianza;

import models.dominio.gradoConfianza.entidades.ComunidadData;
import models.dominio.gradoConfianza.entidades.ResponseAPI;
import models.dominio.gradoConfianza.entidades.UsuarioData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GradoDeConfianzaService {

  @POST("usuarios/gradoConfianza")
  Call<ResponseAPI> gradoDeConfianzaUsuario(@Body UsuarioData usuarioData);

  @POST("comunidades/gradoConfianza")
  Call<ResponseAPI> gradoDeConfianzaComunidad(@Body ComunidadData comunidadData);
}
