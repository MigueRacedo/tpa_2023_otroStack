package server.models.dominio.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import server.models.dominio.notificador.Email;
import server.models.dominio.notificador.MedioNofiticacion;
import server.models.dominio.notificador.Whatsapp;


@Converter(autoApply = true)
public class MedioNotificacionConverter  implements AttributeConverter<MedioNofiticacion, String> {
    @Override
    public String convertToDatabaseColumn(MedioNofiticacion medioNotificacion) {
        String medio = "Ninguno";
        if(medioNotificacion !=null){
            medio = medioNotificacion.getClass().getName().toString();
            String[] medioSeparadoPorPuntos = medio.split("\\.");
            medio = medioSeparadoPorPuntos[medioSeparadoPorPuntos.length - 1];
        }
        return medio;
    }

    @Override
    public MedioNofiticacion convertToEntityAttribute(String s) {
        MedioNofiticacion medio;
        switch (s) {
            case "Whatsapp":
                medio = new Whatsapp();
                break;
            case "Email":
                medio = new Email();
                break;
            default:
                medio = null;
                break;
        }
        return medio;
    }
}
