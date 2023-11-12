package models.dominio.georef.entidades;

import java.util.List;

public class ListadoDeProvincias {
    public int cantidad;
    public int inicio;
    public int total;
    public List<Provincia> provincias;

    public ListadoDeProvincias() {

    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

}
