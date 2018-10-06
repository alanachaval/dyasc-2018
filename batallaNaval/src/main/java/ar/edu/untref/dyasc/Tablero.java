package ar.edu.untref.dyasc;

public class Tablero {

    private Casillero[][] casilleros;

    public Tablero() {
        casilleros = new Casillero[3][1];
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[0].length; j++) {
                casilleros[i][j] = Casillero.AGUA;
            }
        }
    }

    public void agregarEmbarcacion(int x, int y, boolean horizontal, int longitud) {
        for (int i = 0; i < longitud; i++) {
            if (horizontal) {
                casilleros[x + i][y] = Casillero.OCUPADO;
            } else {
                casilleros[x][y + i] = Casillero.OCUPADO;
            }
        }
    }

    public Impacto disparo(int x, int y) {
        if (casilleros[x][y] == Casillero.AGUA) {
            return Impacto.AGUA;
        }
        casilleros[x][y] = Casillero.IMPACTADO;
        int inicioX = x;
        int inicioY = y;
        int longitud = 1;
        boolean horizontal = !((y > 0 && casilleros[x][y - 1] != Casillero.AGUA)
                || (y < casilleros[0].length - 1 && casilleros[x][y + 1] != Casillero.AGUA));
        boolean destruido = true;
        if (horizontal) {
            while (inicioX > 0 && casilleros[inicioX - 1][y] != Casillero.AGUA) {
                inicioX--;
                longitud++;
            }
            while (x < casilleros.length - 1 && casilleros[x + 1][y] != Casillero.AGUA) {
                x++;
                longitud++;
            }
            for (int i = inicioX; i < longitud; i++) {
                destruido = destruido && casilleros[i][y] == Casillero.IMPACTADO;
            }
            if (destruido) {
                for (int i = inicioX; i < longitud; i++) {
                    casilleros[i][y] = Casillero.AGUA;
                }
                return Impacto.HUNDIDO;
            }
        } else {
            while (inicioY > 0 && casilleros[x][inicioY - 1] != Casillero.AGUA) {
                inicioY--;
                longitud++;
            }
            while (y < casilleros[0].length - 1 && casilleros[x][y + 1] != Casillero.AGUA) {
                y++;
                longitud++;
            }
            for (int i = inicioY; i < longitud; i++) {
                destruido = destruido && casilleros[i][y] == Casillero.IMPACTADO;
            }
            if (destruido) {
                for (int i = inicioY; i < longitud; i++) {
                    casilleros[i][y] = Casillero.AGUA;
                }
                return Impacto.HUNDIDO;
            }
        }
        return Impacto.TOCADO;
    }

    private enum Casillero {
        AGUA, OCUPADO, IMPACTADO
    }
}
