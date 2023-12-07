package server.models.dominio.trabajos;

import lombok.Getter;
import jakarta.persistence.*;

@MappedSuperclass
@Getter
public abstract class Persistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
