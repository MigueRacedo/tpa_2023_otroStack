package server.models.dominio.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import server.models.dominio.notificador.CuandoSuceden;
import server.models.dominio.notificador.ModoNotificacion;
import server.models.dominio.notificador.SinApuros;


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
