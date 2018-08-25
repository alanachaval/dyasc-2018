package ar.edu.untref.dyasc.parser;

public class Direccion implements IParametro {

    @Override
    public void GetParametro(Parametros parametros, String value) throws OpcionInvalidaException {
        parametros.setHorizontal(this.getHorizontal(value));
        parametros.setDirecta(this.getDirecta(value));
    }

    private boolean getHorizontal(String value) throws OpcionInvalidaException {
        if (!value.substring(0, 1).equals("h") && !value.substring(0, 1).equals("v")) {
            throw new OpcionInvalidaException();
        }
        return value.substring(0, 1).equals("h");
    }

    private boolean getDirecta(String value) throws OpcionInvalidaException {
        if (!value.substring(1, 2).equals("d") && !value.substring(1, 2).equals("i")) {
            throw new OpcionInvalidaException();
        }
        return value.substring(1, 2).equals("d");
    }

}
