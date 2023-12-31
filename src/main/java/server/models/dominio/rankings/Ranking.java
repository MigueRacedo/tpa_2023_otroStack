package server.models.dominio.rankings;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ranking")
public class Ranking extends Persistente {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @OneToMany(mappedBy = "ranking", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<ValorRanking> valorRankings;
}
