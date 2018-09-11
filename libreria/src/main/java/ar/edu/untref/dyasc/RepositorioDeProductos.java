package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;

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

    public Producto getProducto(String nombre) {
        return productos.get(nombre);
    }

    public Subscribible getSubscribible(String nombre) {
        return subscribibles.get(nombre);
    }

}
