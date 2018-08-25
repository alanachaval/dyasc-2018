package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.parser.OpcionInvalidaException;
import ar.edu.untref.dyasc.parser.Parametros;
import ar.edu.untref.dyasc.parser.Parser;

public class Program {

    public static void main(String[] args) {

        Parametros parametros;

        try {
            Parser parser = new Parser();
            parametros = parser.ParseArgs(args);
        } catch (OpcionInvalidaException e) {
            System.out.println(e.getMessage());
            return;
        }

        Fibo fibo = new Fibo();
        long[] serie = fibo.generarSerie(parametros.getCantidadDeElementos());
        Formatter formatter = new Formatter();
        String resultado = formatter.arrayAString(serie, parametros.isHorizontal(), parametros.isDirecta(), parametros.isLista());
        System.out.println(resultado);

    }

}
