package models.dominio.gradoConfianza;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.dominio.gradoConfianza.entidades.ComunidadData;
import models.dominio.gradoConfianza.entidades.ResponseAPI;
import models.dominio.gradoConfianza.entidades.UsuarioData;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.*;

import java.io.IOException;

public class ServicioGradoDeConfianza {
  private static ServicioGradoDeConfianza instancias = null;
  private static final String urlAPI = "http://localhost:8081/";

  private Retrofit retrofit;

  private ServicioGradoDeConfianza() {
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();

    this.retrofit = new Retrofit.Builder()
        .baseUrl(urlAPI)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
  }

  public static ServicioGradoDeConfianza getInstance() {
    if(instancias == null) {
      instancias = new ServicioGradoDeConfianza();
    }
    return instancias;
  }

  public ResponseAPI getGradoConfianzaUsuario(UsuarioData usuarioData) throws IOException {
    GradoDeConfianzaService gradoDeConfianzaService = this.retrofit.create(GradoDeConfianzaService.class);
    Call<ResponseAPI> requestGrado = gradoDeConfianzaService.gradoDeConfianzaUsuario(usuarioData);
    Response<ResponseAPI> responseGrado = requestGrado.execute();
    return responseGrado.body();
  }

  public ResponseAPI getGradoConfianzaComunidada(ComunidadData comunidadData) throws IOException {
    GradoDeConfianzaService gradoDeConfianzaService = this.retrofit.create(GradoDeConfianzaService.class);
    Call<ResponseAPI> requestGrado = gradoDeConfianzaService.gradoDeConfianzaComunidad(comunidadData);
    Response<ResponseAPI> responseGrado = requestGrado.execute();
    return responseGrado.body();
  }
}
