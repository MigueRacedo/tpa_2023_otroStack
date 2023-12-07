package server.models.dominio.servicios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("simple")
public class ServicioSimple extends Servicio {


    @Override
    public Boolean esElMismoServicio(Servicio servicio)
    {
        if(servicio instanceof ServicioCompuesto) {
            return servicio.esElMismoServicio(this);
        }else{
            return this == servicio;
        }
    }

}
