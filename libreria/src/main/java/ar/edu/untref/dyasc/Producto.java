package ar.edu.untref.dyasc;

public class Producto {

    private String nombre;
    protected float precio;
    
    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public float getPrecio() {
        return precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
}
