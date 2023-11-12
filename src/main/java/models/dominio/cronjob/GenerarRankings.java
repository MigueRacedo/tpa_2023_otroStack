package models.dominio.cronjob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GenerarRankings implements Job {

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    /*GeneradorDeRankingSemanal generador = GeneradorDeRankingSemanal.getInstance();
    generador.setRankingCantidadIncidentes(generador.generarRankingSegunCriterio(CriterioCantidadDeIncidentes.getInstance()));
    generador.setRankingCantAfectados(generador.generarRankingSegunCriterio(CriterioCantidadAfectados.getInstance()));
    generador.setRankingCantidadIncidentes(generador.generarRankingSegunCriterio(CriterioTiempoDeCierre.getInstance()));
    */System.out.println("¡Rankings generados!");
  }
}
