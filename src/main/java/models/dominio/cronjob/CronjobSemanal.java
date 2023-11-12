package models.dominio.cronjob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.DayOfWeek;

public class CronjobSemanal {
  public static void main(String[] args) {
    try {
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

      JobDetail jobDetail = JobBuilder.newJob(GenerarRankings.class)
          .withIdentity("generar rankings", "rankings")
          .build();

      Trigger trigger = TriggerBuilder.newTrigger()
          .withIdentity("generar", "rankings")
          .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(DayOfWeek.MONDAY.getValue(), 0, 0))
          .build();

      scheduler.scheduleJob(jobDetail, trigger);

      scheduler.start();

      Thread.sleep(10000); // Espera 10 segundos

      scheduler.shutdown();

    } catch (SchedulerException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
