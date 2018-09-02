package ar.edu.untref.dyasc;

import java.util.Date;

public class Subscripcion extends Compra {

    private static final float DESCUENTO_ANUAL = 0.2f;
    private Duracion duracion;

    public Subscripcion(Subscribible producto, Date fecha, Duracion duracion) {
        super(producto, fecha);
        this.duracion = duracion;
    }

    @Override
    public float getValor() {
        if (duracion == Duracion.ANUAL) {
            return producto.getPrecio() * ((Subscribible) producto).getPeriodicidad() * (1 - DESCUENTO_ANUAL);
        } else {
            return super.getValor() * ((Subscribible) producto).getPeriodicidad();
        }
    }

}
