package ar.edu.untref.dyasc;

public class Fibo {

    // Maximo valor valido 91
    public long[] generarSerie(int cantidadDeElementos) {
        long[] resultado = new long[cantidadDeElementos];
        long a = 0;
        long b = 1;
        long temp = 0;

        for (int i = 0; i < cantidadDeElementos; i++) {
            resultado[i] = a;
            temp = a + b;
            a = b;
            b = temp;
        }

        return resultado;
    }

    public String arrayAString(long[] serie, boolean horizontal, boolean directa) {
        String separador;
        StringBuilder resultado = new StringBuilder();
        resultado.append("fibo<" + Integer.toString(serie.length) + ">:");
        if (horizontal) {
            separador = " ";
        } else {
            separador = "\n";
        }
        if (directa) {
            for (int i = 0; i < serie.length; i++) {
                resultado.append(separador + serie[i]);
            }
        } else {
            for (int i = serie.length - 1; i >= 0; i--) {
                resultado.append(separador + serie[i]);
            }
        }
        return resultado.toString();
    }

}
