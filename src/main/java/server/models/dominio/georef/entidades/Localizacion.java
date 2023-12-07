package server.models.dominio.georef.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.trabajos.Persistente;


@Setter
@Getter
@Entity
@Table(name = "Localizacion")
public class Localizacion extends Persistente {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    @Column(name = "latitud")
    private Double lat;
    @Column(name = "longitud")
    private Double lon;

    public boolean esIgualA(Localizacion u) {
        return (this.provincia.getNombre() == u.getProvincia().getNombre() && this.departamento.getNombre() == u.getDepartamento().getNombre())
               || this.provincia.getNombre() == u.getProvincia().getNombre() && (this.departamento == null || u.getDepartamento() == null);
    }
    public Boolean esCercana(Localizacion u){
        return u.departamento.getNombre() == this.departamento.getNombre();
    }

}
