package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.excepciones.ProductoNoRegistradoException;

public class RepositorioDeProductos {

    private Map<String, Producto> productos;
    private Map<String, Subscribible> subscribibles;

    public RepositorioDeProductos() {
        productos = new HashMap<String, Producto>();
        subscribibles = new HashMap<String, Subscribible>();
    }

    public void registrarProducto(Producto producto) {
        productos.put(producto.getNombre(), producto);
    }

    public void registrarSubscribible(Subscribible producto) {
        subscribibles.put(producto.getNombre(), producto);
        productos.put(producto.getNombre(), producto);
    }

    public Producto getProducto(String nombre) throws ProductoNoRegistradoException {
        return getElemento(productos, nombre);
    }

    public Subscribible getSubscribible(String nombre) throws ProductoNoRegistradoException {
        return getElemento(subscribibles, nombre);
    }

    private <T> T getElemento(Map<String, T> mapa, String nombre) throws ProductoNoRegistradoException {
        T elemento = mapa.get(nombre);
        if (elemento == null) {
            throw new ProductoNoRegistradoException(nombre);
        }
        return elemento;
    }

}
