package server.models.dominio.notificador;

import server.models.dominio.excepciones.NotificacionException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AdapterJavaEmail implements AdapterEmail{
    private final String usuario;
    private final String contrasenia;

    public AdapterJavaEmail(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    private Session abrirSesion() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp-mail.outlook.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");
        return Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario, contrasenia);
                    }
                });
    }

    private Message construirCorreo(Session session, String destinatario, String asunto, String cuerpo) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(usuario));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(destinatario)
        );
        message.setSubject(asunto);
        message.setText(cuerpo);
        return message;
    }

    @Override
    public void notificar(Notificacion notificacion) {
        String destinatario = notificacion.getDestinatario().getMail();
        if (destinatario.isEmpty()) {
            throw new NotificacionException("El destinario esta vacio, ingrese un destinario");
        }
        if (notificacion.getMensaje() == null) {
            throw new NotificacionException("El cuerpo del mensaje es nulo, ingrese un cuerpo");
        }

        Session session = abrirSesion();
        try {
            Message message = construirCorreo(session, destinatario, notificacion.getAsunto(), notificacion.getMensaje());
            Transport.send(message);
        } catch (MessagingException e) {
            throw new NotificacionException("Error al enviar la notificacion por mail");
        }
        System.out.println("Se envió el email");
    }
}
