package models.dominio.notificador;
public class Whatsapp implements MedioNofiticacion {
  private AdapterWhatsapp adapterWhatsapp = new AdapterTwilioWhatsapp();
  @Override
  public void notificar(Notificacion notificacion) {
    this.adapterWhatsapp.notificar(notificacion);
  }

  public void setAdapterWhatsapp(AdapterWhatsapp adapterWhatsapp) {
    this.adapterWhatsapp = adapterWhatsapp;
  }
}
