package ar.edu.untref.dyasc;

import java.time.Month;
import java.time.Year;

public class Subscripcion extends Compra {

    private static final float DESCUENTO_ANUAL = 0.2f;
    private Duracion duracion;

    public Subscripcion(Subscribible producto, Year anio, Month mes, Duracion duracion) {
        super(producto, anio, mes);
        this.duracion = duracion;
    }

    @Override
    public float getValor() {
        if (duracion == Duracion.ANUAL) {
            return producto.getPrecio() * ((Subscribible) producto).getPeriodicidad() * (1.0f - DESCUENTO_ANUAL);
        } else {
            return super.getValor() * ((Subscribible) producto).getPeriodicidad();
        }
    }

}
