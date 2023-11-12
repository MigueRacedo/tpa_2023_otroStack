package models.dominio.importador;

import models.dominio.entidades.EntidadPrestadora;
import models.dominio.entidades.OrganismoDeControl;

import java.util.List;

public interface Lector {
    List<EntidadPrestadora> cargarEntidadesPrestadoras(String ruta);
    List<OrganismoDeControl> cargarOrganismosDeControl(String ruta);
}
