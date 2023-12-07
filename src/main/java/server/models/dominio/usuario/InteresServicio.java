package server.models.dominio.usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import server.models.dominio.servicios.Servicio;

import java.io.Serializable;

@Entity
@Table(name = "servicios_de_interes")
@IdClass(InteresServicio.class)
public class InteresServicio implements Serializable {
    @Id
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;
    @Id
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Condicion condicion;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        usuario.agregarServicioDeInteres(this);
    }
}
