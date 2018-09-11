package ar.edu.untref.dyasc.excepciones;

public class ProductoNoRegistradoException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 3036370448789067276L;

    public ProductoNoRegistradoException(String nombre) {
        super("El producto " + nombre + " no esta registrado");
    }

}
