package server.models.dominio.notificador;

public class CuandoSuceden implements ModoNotificacion {
    @Override
    public void notificar(Notificacion notificacion) {
        notificacion.notificar();
    }
}
