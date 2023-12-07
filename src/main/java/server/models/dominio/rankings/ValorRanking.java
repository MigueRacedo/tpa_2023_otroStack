package server.models.dominio.rankings;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.entidades.Entidad;
import server.models.dominio.trabajos.Persistente;


@Getter
@Entity
@Table(name = "detalle_ranking")
public class ValorRanking extends Persistente {
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidad_id", referencedColumnName = "id")
    private Entidad entidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ranking_id", referencedColumnName = "id")
    private Ranking ranking;
    @Setter
    @Column(name = "valor")
    private Double valor;
    public ValorRanking(){
    }
}
