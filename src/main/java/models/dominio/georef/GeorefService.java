package models.dominio.georef;

import models.dominio.georef.entidades.ListadoDeDepartamentos;
import models.dominio.georef.entidades.ListadoDeProvincias;
import models.dominio.georef.entidades.UbicacionResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeorefService {
    @GET("provincias")
    Call<ListadoDeProvincias> provincias();
    @GET("departamentos")
    Call<ListadoDeDepartamentos> departamentos(@Query("provincia") String idProvincia, @Query("campos") String campos);
    @GET("ubicacion")
    Call<UbicacionResponse> getLocalizacion(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("aplanar") boolean aplanar,
            @Query("campos") String campos
    );
}
