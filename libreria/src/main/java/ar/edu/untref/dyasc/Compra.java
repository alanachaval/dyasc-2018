package ar.edu.untref.dyasc;

import java.util.Date;

public class Compra {

    private static final float DESCUENTO_CLIENTE = 0.5f;
    protected Producto producto;
    private Date fecha;

    public Compra(Producto producto, Date fecha) {
        this.producto = producto;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getValor() {
        return producto.getPrecio() * (1 - DESCUENTO_CLIENTE);
    }

}
