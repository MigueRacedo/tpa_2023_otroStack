package server.Services;

import models.datos.RepoDeIncidentes;
import models.dominio.incidentes.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentesService {

  @Autowired
  RepoDeIncidentes repoDeIncidentes;

  public List<Incidente> getIncidentes() {
    return repoDeIncidentes.findAll();
  }
}
