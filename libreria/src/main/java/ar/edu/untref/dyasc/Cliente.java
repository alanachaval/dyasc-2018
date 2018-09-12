package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String direccion;
    private List<Compra> compras;

    public Cliente(String direccion) {
        this.compras = new ArrayList<Compra>();
        this.direccion = direccion;
    }

    public Iterable<Compra> getCompras() {
        return compras;
    }

    public String getDireccion() {
        return direccion;
    }

    public void agregarCompra(Compra compra) {
        this.compras.add(compra);
    }

}
