package server.models.dominio.servicios;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;

@Entity
//@Access(AccessType.PROPERTY)

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
