package models.dominio.importador;

import models.dominio.entidades.EntidadPrestadora;
import models.dominio.entidades.OrganismoDeControl;

import java.util.List;

public class Importador {
    private static Importador instancia = null;
    private Importador(){}
    public static Importador getInstance(){
        if(instancia == null) {
            instancia = new Importador();
        }
        return instancia;
    }
    public List<EntidadPrestadora> importarEntidadesPrestadoras(String ruta, Lector lector){
        return lector.cargarEntidadesPrestadoras(ruta);
    }
    public List<OrganismoDeControl> importarOrganismosDeControl(String ruta, Lector lector){
        return lector.cargarOrganismosDeControl(ruta);
    }
}
