package ar.edu.untref.dyasc.parser;

public class Archivo implements IParametro {
    
    @Override
    public void GetParametro(Parametros parametros, String value) throws OpcionInvalidaException {
        parametros.setArchivo(value);
    }
}
