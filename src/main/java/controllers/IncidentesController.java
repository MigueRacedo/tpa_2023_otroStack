package controllers;

import Services.IncidentesService;
import models.dominio.incidentes.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incidentes/usuario/")
public class IncidentesController {

  @Autowired
  private IncidentesService incidentesService;

  @GetMapping("/{id}")
  public List<Incidente> index(@PathVariable Long idUsuario) {
    return this.incidentesService.getIncidentes(idUsuario);
  }
}
