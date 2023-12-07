package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@ComponentScan(basePackages = {"server.models.datos","server.models.dominio","server.controllers","server.Services"}, basePackageClasses = {models.dominio.incidentes.Incidente.class, })
@EnableJpaRepositories(basePackages = "server.models.datos")
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
