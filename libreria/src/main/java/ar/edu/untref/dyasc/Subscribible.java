package ar.edu.untref.dyasc;

public class Subscribible extends Producto {

    private int periodicidad;

    public Subscribible(String nombre, float precio, int periodicidad) {
        super(nombre, precio);
        this.periodicidad = periodicidad;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

}
