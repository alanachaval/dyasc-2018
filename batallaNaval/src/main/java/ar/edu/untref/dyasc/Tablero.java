package ar.edu.untref.dyasc;

public class Tablero {

    private Casillero[][] casilleros;

    /**
     * Crea el tablero
     * 
     * @param longitud longitud del tablero (cuadrado)
     */
    public Tablero(int longitud) {
        casilleros = new Casillero[longitud][longitud];
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[0].length; j++) {
                casilleros[i][j] = Casillero.AGUA;
            }
        }
    }

    /**
     * Agrega una embarcacion sobre el tablero
     * 
     * @param x          : posicion x inicial del barco
     * @param y          : posicion y inicial del barco
     * @param horizontal : si el barco continua en sentido horizontal
     * @param longitud   : cantidad de casilleros que ocupa el barco
     * @return : si se pudo crear (si es falso significa que esta fuera del tablero
     *         o adyacente a otro barco)
     */
    public boolean agregarEmbarcacion(int x, int y, boolean horizontal, int longitud) {
        Contador contador = crearContador(x, y, horizontal);
        contador = crearContador(x, y, horizontal);
        for (int i = 0; i < longitud; i++) {
            casilleros[contador.getX()][contador.getY()] = Casillero.OCUPADO;
            contador.incrementar();
        }
        return true;
    }

    /**
     * realiza un disparo sobre el tablero
     * 
     * @param x : posicion x en el tablero
     * @param y : posicion y en el tablero
     * @return AGUA si fallo, TOCADO si impacto pero no hundio un barco y HUNDIDO si
     *         lo hundio
     */
    public Impacto disparo(int x, int y) {
        if (casilleros[x][y] == Casillero.AGUA) {
            return Impacto.AGUA;
        }
        casilleros[x][y] = Casillero.IMPACTADO;
        boolean horizontal = !((y > 0 && casilleros[x][y - 1] != Casillero.AGUA)
                || (y < casilleros[0].length - 1 && casilleros[x][y + 1] != Casillero.AGUA));
        boolean destruido = true;
        int longitud = 1;
        Contador contadorInicio = crearContador(x, y, horizontal);
        Contador contadorFin = crearContador(x, y, horizontal);

        while (contadorInicio.getVariable() > 0
                && casilleros[contadorInicio.getX()][contadorInicio.getY()] != Casillero.AGUA) {
            contadorInicio.decrementar();
            longitud++;
        }
        if (casilleros[contadorInicio.getX()][contadorInicio.getY()] == Casillero.AGUA) {
            contadorInicio.incrementar();
            longitud--;
        }

        while (contadorFin.getVariable() < casilleros.length - 1
                && casilleros[contadorFin.getX()][contadorFin.getY()] != Casillero.AGUA) {
            contadorFin.incrementar();
            longitud++;
        }
        if (casilleros[contadorFin.getX()][contadorFin.getY()] == Casillero.AGUA) {
            contadorFin.decrementar();
            longitud--;
        }

        for (int i = 0; i < longitud; i++) {
            destruido = destruido && casilleros[contadorInicio.getX()][contadorInicio.getY()] == Casillero.IMPACTADO;
            contadorInicio.incrementar();
        }
        if (destruido) {
            for (int i = 0; i < longitud; i++) {
                contadorInicio.decrementar();
                casilleros[contadorInicio.getX()][contadorInicio.getY()] = Casillero.AGUA;
            }
            return Impacto.HUNDIDO;
        }

        return Impacto.TOCADO;
    }

    private Contador crearContador(int x, int y, boolean horizontal) {
        Contador contador;
        if (horizontal) {
            contador = new ContadorHorizontal(x, y);
        } else {
            contador = new ContadorVertical(x, y);
        }
        return contador;
    }

    private enum Casillero {
        AGUA, OCUPADO, IMPACTADO
    }
}
