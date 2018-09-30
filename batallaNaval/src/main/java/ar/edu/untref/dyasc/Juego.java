package ar.edu.untref.dyasc;

public class Juego {
    
    private boolean[][] tablero; 
    
    public Juego() {
        tablero = new boolean[1][1];
    }

    public Impacto disparo(int x, int y) {
        if (tablero[x][y]) {
            tablero[x][y] = false;
            return Impacto.HUNDIDO;
        }
        return Impacto.AGUA;
    }

    public void agregarBote(int x, int y) {
        tablero[x][y] = true;
    }

}
