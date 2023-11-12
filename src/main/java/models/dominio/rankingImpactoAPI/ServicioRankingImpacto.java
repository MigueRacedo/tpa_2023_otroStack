package models.dominio.rankingImpactoAPI;

import models.dominio.rankingImpactoAPI.entidades.RequestEntidadDTO;
import models.dominio.rankingImpactoAPI.entidades.ResponseEntidadDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioRankingImpacto {
  private static ServicioRankingImpacto instancias = null;
  private static final String urlAPI = "http://localhost:8080/RankingImpactoIncidentes/";

  private Retrofit retrofit;

  private ServicioRankingImpacto() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(urlAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static ServicioRankingImpacto getInstance() {
    if(instancias == null) {
      instancias = new ServicioRankingImpacto();
    }
    return instancias;
  }

  public String CambiarCoeficiente(int valor) throws IOException {
    RankingImpactoService rankingImpactoService = this.retrofit.create(RankingImpactoService.class);
    Call<String> requestCambio = rankingImpactoService.cambiarCNF(valor);
    Response<String> responseCambio = requestCambio.execute();
    return responseCambio.body();
  }

  public ResponseEntidadDTO generarRanking(RequestEntidadDTO requestEntidadDTO) throws IOException {
    RankingImpactoService rankingImpactoService = this.retrofit.create(RankingImpactoService.class);
    Call<ResponseEntidadDTO> requestRanking = rankingImpactoService.generarRanking(requestEntidadDTO);
    Response<ResponseEntidadDTO> responseRanking = requestRanking.execute();
    return responseRanking.body();
  }
}
