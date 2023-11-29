package controllers;

import Services.IncidentesService;
import models.dominio.incidentes.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class IncidentesController {

  @Autowired
  private IncidentesService incidentesService;

  @GetMapping("/incidentes")
  public String index(Model model) {
    List<Incidente> incidentes = this.incidentesService.getIncidentes();
    model.addAttribute("incidentes",incidentes);
    return "incidentes";
  }
}
