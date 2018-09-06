package ar.edu.untref.dyasc;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class Libreria {

    private Map<String, Cliente> clientes;
    
    public Libreria() {
        clientes = new HashMap<String, Cliente>();
    }
    
    public void RegistrarCliente(String direccion) {
        clientes.put(direccion, new Cliente(new Cuenta(), direccion));
    }
    
    public void Vender(String direccion, Producto producto, Year anio, Month mes) {
        Compra compra = new Compra(producto, anio, mes);
        clientes.get(direccion).getCuenta().AgregarCompra(compra);
    }
    
    public void Subscribir(String direccion, Subscribible subscribible, Year anio) {
        for(Month mes : Month.values()) {
            Subscripcion subscripcion = new Subscripcion(subscribible, anio, mes, Duracion.ANUAL);
            clientes.get(direccion).getCuenta().AgregarCompra(subscripcion);
        }
    }
    
    public void Subscribir(String direccion, Subscribible subscribible, Year anio, Month mes) {
        Subscripcion subscripcion = new Subscripcion(subscribible, anio, mes, Duracion.MENSUAL);
        clientes.get(direccion).getCuenta().AgregarCompra(subscripcion);
    }
    
    public float ObtenerCobro(Cliente cliente, Year anio) {
        float total = 0.0f;
        for (Compra compra : cliente.getCuenta().getCompras()) {
            if(compra.getAnio() == anio) {
                total += compra.getValor();
            }
        }
        return total;
    }
    
    public float ObtenerCobro(Cliente cliente, Month mes, Year anio) {
        float total = 0.0f;
        for (Compra compra : cliente.getCuenta().getCompras()) {
            if(compra.getAnio() == anio && compra.getMes() == mes) {
                total += compra.getValor();
            }
        }
        return total;
    }
    
}
