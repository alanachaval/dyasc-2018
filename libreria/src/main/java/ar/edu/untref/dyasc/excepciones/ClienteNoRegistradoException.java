package ar.edu.untref.dyasc.excepciones;

public class ClienteNoRegistradoException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -3303596243498775238L;

    public ClienteNoRegistradoException(String nombre) {
        super("El cliente " + nombre + " no esta registrado");
    }
}
