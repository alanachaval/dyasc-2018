package ar.edu.untref.dyasc.parser;

public class Parametros {

    private int cantidadDeElementos;
    private boolean horizontal;
    private boolean directa;
    private boolean lista;
    private String archivo;

    public Parametros() {
        horizontal = true;
        directa = true;
        lista = true;
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

    public boolean isLista() {
        return lista;
    }

    public void setLista(boolean lista) {
        this.lista = lista;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

}
