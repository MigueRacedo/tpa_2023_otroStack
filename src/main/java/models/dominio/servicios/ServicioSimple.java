package models.dominio.servicios;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
