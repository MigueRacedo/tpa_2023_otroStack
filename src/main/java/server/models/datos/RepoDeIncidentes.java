package server.models.datos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.dominio.incidentes.Incidente;

@Repository
public interface RepoDeIncidentes extends JpaRepository<Incidente, Long> {

}
