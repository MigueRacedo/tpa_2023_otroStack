package server.models.dominio.notificador;

import lombok.Setter;

@Setter
public class Email implements MedioNofiticacion {

  private final AdapterEmail adapterEmail = new AdapterJavaEmail("grupo2.dds2023@outlook.com", "grupo2dds");
  @Override
  public void notificar(Notificacion notificacion) {
    this.adapterEmail.notificar(notificacion);
  }
}
