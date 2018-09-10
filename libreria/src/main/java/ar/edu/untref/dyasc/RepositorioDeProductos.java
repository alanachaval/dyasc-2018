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

    public void RegistrarProducto(Producto producto) {
        productos.put(producto.getNombre(), producto);
    }

    public void RegistrarSubscribible(Subscribible producto) {
        subscribibles.put(producto.getNombre(), producto);
        productos.put(producto.getNombre(), producto);
    }

    public Producto GetProducto(String nombre) {
        return productos.get(nombre);
    }

    public Subscribible GetSubscribible(String nombre) {
        return subscribibles.get(nombre);
    }

}
