package server.models.dominio.servicios;
import jakarta.persistence.*;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;

@Entity
//@Access(AccessType.PROPERTY)

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
