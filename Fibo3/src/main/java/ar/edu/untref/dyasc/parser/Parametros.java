package ar.edu.untref.dyasc.parser;

public class Parametros {

    private int cantidadDeElementos;
    private boolean horizontal;
    private boolean directa;

    public Parametros() {
        horizontal = true;
        directa = true;
    }

    public int getCantidadDeElementos() {
        return cantidadDeElementos;
    }

    public void setCantidadDeElementos(int cantidadDeElementos) {
        this.cantidadDeElementos = cantidadDeElementos;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean isDirecta() {
        return directa;
    }

    public void setDirecta(boolean directa) {
        this.directa = directa;
    }

}
