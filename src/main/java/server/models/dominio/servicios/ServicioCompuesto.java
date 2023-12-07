package server.models.dominio.servicios;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("compuesto")
public class ServicioCompuesto extends Servicio{
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id")
    private List<Servicio> servicios = new ArrayList<>();

    public ServicioCompuesto(){}
    @Override
    public Boolean esElMismoServicio(Servicio servicio) {
        return this == servicio || servicios.stream().anyMatch(s -> s.esElMismoServicio(servicio));
    }

    public List<Servicio> getServicios() {
        return servicios;
    }
    public void agregarServicio(Servicio servicio){
        this.servicios.add(servicio);
    }

}
