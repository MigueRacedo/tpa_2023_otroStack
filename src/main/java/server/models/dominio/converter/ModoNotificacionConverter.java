package models.dominio.converter;

import models.dominio.notificador.CuandoSuceden;
import models.dominio.notificador.ModoNotificacion;
import models.dominio.notificador.SinApuros;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ModoNotificacionConverter  implements AttributeConverter<ModoNotificacion, String> {
    @Override
    public String convertToDatabaseColumn(ModoNotificacion modoNotificacion) {
        String modo = "Ninguno";
        if(modoNotificacion !=null){
            modo = modoNotificacion.getClass().getName().toString();
            String[] medioSeparadoPorPuntos = modo.split("\\.");
            modo = medioSeparadoPorPuntos[medioSeparadoPorPuntos.length - 1];
        }
        return modo;
    }

    @Override
    public ModoNotificacion convertToEntityAttribute(String s) {
        ModoNotificacion modo;
        switch (s) {
            case "CuandoSuceden":
                modo = new CuandoSuceden();
                break;
            case "SinApuros":
                modo = new SinApuros();
                break;
            default:
                modo = null;
                break;
        }
        return modo;
    }
}
