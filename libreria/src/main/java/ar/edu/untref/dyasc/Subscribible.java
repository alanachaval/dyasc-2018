package ar.edu.untref.dyasc;

public class Subscribible extends Producto {

    private int periodicidad;

    public Subscribible(float precio, int periodicidad) {
        super(precio);
        this.periodicidad = periodicidad;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

}
