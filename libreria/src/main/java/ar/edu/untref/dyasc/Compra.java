package ar.edu.untref.dyasc;

import java.time.Month;
import java.time.Year;

public class Compra {

    private static final float DESCUENTO_CLIENTE = 0.5f;
    protected Producto producto;
    private Year anio;
    private Month mes;

    public Compra(Producto producto, Year anio, Month mes) {
        this.producto = producto;
        this.anio = anio;
        this.mes = mes;
    }

    public Year getAnio() {
        return anio;
    }

    public Month getMes() {
        return mes;
    }

    public float getValor() {
        return producto.getPrecio() * (1 - DESCUENTO_CLIENTE);
    }

}
