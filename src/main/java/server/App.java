package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableWebMvc
//@ComponentScan(basePackages = {"server.models.datos","server.models.dominio","server.controllers","server.Services"}, basePackageClasses = {models.dominio.incidentes.Incidente.class, })
@EnableJpaRepositories(basePackages = "server.models.datos")
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
