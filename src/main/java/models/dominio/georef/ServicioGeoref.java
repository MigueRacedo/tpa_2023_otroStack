package models.dominio.georef;

import models.datos.RepoLocalizaciones;
import models.dominio.georef.entidades.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ServicioGeoref {
    private static ServicioGeoref instancias = null;
    private static final String urlAPI = "https://apis.datos.gob.ar/georef/api/";
    private Retrofit retrofit;

    private ServicioGeoref() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioGeoref getInstance() {
        if(instancias == null) {
            instancias = new ServicioGeoref();
        }
        return instancias;
    }

    public List<Provincia> listaDeProvincias() throws IOException {
        GeorefService georefService = this.retrofit.create(GeorefService.class);
        Call<ListadoDeProvincias> requestProvinciasArg = georefService.provincias();
        Response<ListadoDeProvincias> responseProvinciasArg = requestProvinciasArg.execute();
        return responseProvinciasArg.body().provincias;
    }
    public Localizacion getLocalizacion(Double lat, Double lon) throws IOException{
        GeorefService georefService = this.retrofit.create(GeorefService.class);
        Call<UbicacionResponse> requestUbicacion = georefService.getLocalizacion(lat, lon,true, "estandar");
        Response<UbicacionResponse> responseUbicacion = requestUbicacion.execute();
        return this.toLocalizacion(responseUbicacion.body().getUbicacion());
    }
    public List<Departamento> listadoDeDepartamentos(String id) throws IOException {
        GeorefService georefService = this.retrofit.create(GeorefService.class);
        Call<ListadoDeDepartamentos> requestDepartamentosDeProvincia = georefService.departamentos(id, "estandar");
        Response<ListadoDeDepartamentos> responseDepartamentosDeProvincia = requestDepartamentosDeProvincia.execute();
        return responseDepartamentosDeProvincia.body().departamentos;
    }
    private Localizacion toLocalizacion(Ubicacion ubicacion){
        RepoLocalizaciones repoLocalizaciones = new RepoLocalizaciones();
        Localizacion loc = new Localizacion();
        loc.setProvincia(repoLocalizaciones.findProvinciaById(ubicacion.getProvincia_id()));
        loc.setDepartamento(repoLocalizaciones.findDepartamentoById(ubicacion.getDepartamento_id()));
        loc.setLat(ubicacion.getLat());
        loc.setLon(ubicacion.getLon());
        return loc;
    }
}
