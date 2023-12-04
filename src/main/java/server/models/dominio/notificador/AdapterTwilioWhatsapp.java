package models.dominio.notificador;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import models.dominio.excepciones.NotificacionException;

public class AdapterTwilioWhatsapp implements AdapterWhatsapp{
    private static final PhoneNumber from = new PhoneNumber("whatsapp:+5491155136689");
    public static final String ACCOUNT_SID = "AC7471f2bc938c1a3d499ec776bb4bac84";
    public static final String AUTH_TOKEN = "4bf3879d3838b11094b98fb555bc7c77";
    @Override
    public void notificar(Notificacion notificacion) {
        String destinatario = notificacion.getDestinatario().getTelefono();
        if (notificacion.getMensaje() == null) {
            throw new NotificacionException("El cuerpo del mensaje es nulo, ingrese un cuerpo");
        }
        if (destinatario.isEmpty()) {
            throw new NotificacionException("El destinatario del mensaje está vacio, ingrese un destinatario");
        }
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber("whatsapp:" + destinatario),
                        from,
                        notificacion.getAsunto() + " - " + notificacion.getMensaje())
                .create();
        System.out.println("Se envio la notificacion por Whatsapp");
    }
}

