package ar.edu.untref.dyasc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Libreria {

    private Map<String, Cliente> clientes;
    private Date fechaActual;
    
    public Libreria() {
        clientes = new HashMap<String, Cliente>();
    }
    
    public void Vender(String direccion, Producto producto) {
        Compra compra = new Compra(producto, fechaActual);
        clientes.get(direccion).getCuenta().AgregarCompra(compra);
    }
    
    public void Vender(String direccion, Subscribible subscribible, Duracion duracion) {
        Subscripcion subscripcion = new Subscripcion(subscribible, fechaActual, duracion);
        clientes.get(direccion).getCuenta().AgregarCompra(subscripcion);
    }
    
}
