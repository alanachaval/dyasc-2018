package ar.edu.untref.dyasc;

public class Fibo {

    // Maximo valor valido 91
    public String generarSerie(int cantidadDeElementos) {
        long a = 0;
        long b = 1;
        long temp = 0;
        StringBuilder resultado = new StringBuilder();
        resultado.append("Fibo<" + Integer.toString(cantidadDeElementos) + ">:");

        for (int i = 0; i < cantidadDeElementos; i++) {
            resultado.append(" " + Long.toString(a));
            temp = a + b;
            a = b;
            b = temp;
        }

        return resultado.toString();
    }
    
}
