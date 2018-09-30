package ar.edu.untref.dyasc;

public class Juego {

    private boolean[][] tablero;

    public Juego() {
        tablero = new boolean[3][1];
    }

    public Impacto disparo(int x, int y) {
        if (tablero[x][y]) {
            tablero[x][y] = false;
            if (checkearHundido(x, y)) {
                return Impacto.HUNDIDO;
            } else {
                return Impacto.IMPACTO;
            }

        }
        return Impacto.AGUA;
    }

    public void agregarBote(int x, int y) {
        tablero[x][y] = true;
    }

    public void agregarBarco(int x, int y, boolean horizontal) {
        for (int i = 0; i < 3; i++) {
            tablero[x][y] = true;
            if (horizontal) {
                x++;
            } else {
                y++;
            }
        }
    }

    private boolean checkearHundido(int x, int y) {
        boolean izquierda = x > 0 && tablero[x - 1][y];
        boolean derecha = x < tablero.length - 1 && tablero[x + 1][y];
        boolean arriba = y > 0 && tablero[x][y - 1];
        boolean abajo = y < tablero[0].length - 1 && tablero[x][y + 1];
        return !izquierda && !derecha && !arriba && !abajo;
    }

}
