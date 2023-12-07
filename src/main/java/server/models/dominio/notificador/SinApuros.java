package server.models.dominio.notificador;

import server.models.dominio.usuario.Usuario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SinApuros implements ModoNotificacion{
    public void notificar(Notificacion notificacion){
        //notificacion.getDestinatario().agregarNotificacion(notificacion);
    }

    public void notificarPendientes(Usuario usuario) { //Hay que agregar un tarea que ejecute el método
        if (usuario.getHorarios().stream().map(h->h.getHorario()).toList().contains(LocalTime.now())) {
            List<Notificacion> notificaciones = this.incidentesEn24Horas(usuario);
            notificaciones.stream().forEach((n -> n.notificar()));
            //usuario.getNotificacionesPendientes().clear(); //TODO ver si es un clear o actualizar el estado de las notificaciones
        }
    }
    public List<Notificacion> incidentesEn24Horas(Usuario usuario) {
        LocalDateTime ahora = LocalDateTime.now();
        List<Notificacion> notificacionesAux = new ArrayList<>();
        /*for(Notificacion notificacion : usuario.getNotificacionesPendientes()) {
            LocalDateTime apertura = notificacion.getFecha();
            LocalDateTime limite = apertura.minusHours(24);
            if(limite.isAfter(ahora)) {
                notificacionesAux.add(notificacion);
            }
        }*/
        return notificacionesAux;
    }
}
