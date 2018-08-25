package ar.edu.untref.dyasc;

public class Formatter {

    public String arrayAString(long[] serie, boolean horizontal, boolean directa, boolean lista) {
        String separador;
        StringBuilder resultado = new StringBuilder();
        resultado.append("fibo<" + Integer.toString(serie.length) + ">:");
        if (!lista) {
            long[] suma = new long[1];
            suma[0] = 0;
            for (int i = 0; i < serie.length; i++) {
                suma[0] += serie[i];
            }
            serie = suma;
        }
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
