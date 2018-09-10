package ar.edu.untref.dyasc;

public class ArticuloDeLibreria extends Producto {

    private static final float IVA = 0.21f;

    public ArticuloDeLibreria(String nombre, float precio) {
        super(nombre, precio);
    }

    @Override
    public float getPrecio() {
        return precio * (1.0f + IVA);
    }

}
