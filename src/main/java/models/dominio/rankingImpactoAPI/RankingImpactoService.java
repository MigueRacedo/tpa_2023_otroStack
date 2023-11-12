package models.dominio.rankingImpactoAPI;

import models.dominio.rankingImpactoAPI.entidades.RequestEntidadDTO;
import models.dominio.rankingImpactoAPI.entidades.ResponseEntidadDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RankingImpactoService {

  @POST("CambiarCNF/{nuevoCnf}")
  Call<String> cambiarCNF(@Path("nuevoCnf") int valor);

  @POST("GenerarRanking")
  Call<ResponseEntidadDTO> generarRanking(@Body RequestEntidadDTO requestEntidadDTO);
}
