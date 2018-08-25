package ar.edu.untref.dyasc.parser;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public Parametros ParseArgs(String[] args) throws OpcionInvalidaException {
        Map<String, IParametro> parsers = new HashMap<String, IParametro>();
        parsers.put("-o", new Direccion());
        parsers.put("-m", new Modo());
        parsers.put("-f", new Archivo());
        Parametros resultado = new Parametros();
        String[] parametro;
        for (int i = 0; i < args.length; i++) {
            parametro = args[i].split("=");
            if (parametro.length == 1) { // cantidadDeElementos no tiene =
                resultado.setCantidadDeElementos(Integer.parseInt(parametro[0]));
            } else {
                parsers.get(parametro[0]).GetParametro(resultado, parametro[1]);
            }
        }
        return resultado;
    }
}
