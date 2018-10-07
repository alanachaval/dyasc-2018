package ar.edu.untref.dyasc;

public class Juego {

    private Tablero tablero;

    public Juego(int longitud) {
        tablero = new Tablero(longitud);
    }

    public Impacto disparo(int x, int y) {
        return tablero.disparo(x, y);
    }

    public void agregarBote(int x, int y) {
        tablero.agregarEmbarcacion(x, y, true, 1);
    }

    public void agregarCrucero(int x, int y, boolean horizontal) {
        tablero.agregarEmbarcacion(x, y, horizontal, 3);
    }
}
