package ar.edu.untref.dyasc;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.excepciones.ProductoNoRegistradoException;

public class Libreria {

    private Map<String, Cliente> clientes;
    private RepositorioDeProductos repositorio;

    public Libreria(RepositorioDeProductos repositorio) {
        clientes = new HashMap<String, Cliente>();
        this.repositorio = repositorio;
    }

    public void registrarCliente(String direccion) {
        clientes.put(direccion, new Cliente(direccion));
    }

    public void vender(String direccion, String producto, Year anio, Month mes) throws ProductoNoRegistradoException {
        Compra compra = new Compra(repositorio.getProducto(producto), anio, mes);
        clientes.get(direccion).agregarCompra(compra);
    }

    public void subscribir(String direccion, String subscribible, Year anio) throws ProductoNoRegistradoException {
        for (Month mes : Month.values()) {
            Subscripcion subscripcion = new Subscripcion(repositorio.getSubscribible(subscribible), anio, mes,
                    Duracion.ANUAL);
            clientes.get(direccion).agregarCompra(subscripcion);
        }
    }

    public void subscribir(String direccion, String subscribible, Year anio, Month mes) throws ProductoNoRegistradoException {
        Subscripcion subscripcion = new Subscripcion(repositorio.getSubscribible(subscribible), anio, mes,
                Duracion.MENSUAL);
        clientes.get(direccion).agregarCompra(subscripcion);
    }

    public float obtenerCobro(String direccion, Year anio) {
        Cliente cliente = clientes.get(direccion);
        float total = 0.0f;
        for (Compra compra : cliente.getCompras()) {
            if (compra.getAnio().equals(anio)) {
                total += compra.getValor();
            }
        }
        return total;
    }

    public float obtenerCobro(String direccion, Year anio, Month mes) {
        Cliente cliente = clientes.get(direccion);
        float total = 0.0f;
        for (Compra compra : cliente.getCompras()) {
            if (compra.getAnio().equals(anio) && compra.getMes().equals(mes)) {
                total += compra.getValor();
            }
        }
        return total;
    }

}
