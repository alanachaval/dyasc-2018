package ar.edu.untref.dyasc.parser;

public class Modo implements IParametro {

    @Override
    public void GetParametro(Parametros parametros, String value) throws OpcionInvalidaException {
        if (!value.substring(0, 1).equals("l") && !value.substring(0, 1).equals("s")) {
            throw new OpcionInvalidaException();
        }
        parametros.setLista(value.substring(0, 1).equals("l"));
    }
    
}
