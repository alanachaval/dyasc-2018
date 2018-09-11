package ar.edu.untref.dyasc;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.excepciones.ClienteNoRegistradoException;
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

    public void vender(String direccion, String producto, Year anio, Month mes)
            throws ProductoNoRegistradoException, ClienteNoRegistradoException {
        Cliente cliente = getCliente(direccion);
        Compra compra = new Compra(repositorio.getProducto(producto), anio, mes);
        cliente.agregarCompra(compra);
    }

    public void subscribir(String direccion, String subscribible, Year anio)
            throws ProductoNoRegistradoException, ClienteNoRegistradoException {
        Cliente cliente = getCliente(direccion);
        for (Month mes : Month.values()) {
            Subscripcion subscripcion = new Subscripcion(repositorio.getSubscribible(subscribible), anio, mes,
                    Duracion.ANUAL);
            cliente.agregarCompra(subscripcion);
        }
    }

    public void subscribir(String direccion, String subscribible, Year anio, Month mes)
            throws ProductoNoRegistradoException, ClienteNoRegistradoException {
        Cliente cliente = getCliente(direccion);
        Subscripcion subscripcion = new Subscripcion(repositorio.getSubscribible(subscribible), anio, mes,
                Duracion.MENSUAL);
        cliente.agregarCompra(subscripcion);
    }

    public float obtenerCobro(String direccion, Year anio) throws ClienteNoRegistradoException {
        Cliente cliente = getCliente(direccion);
        float total = 0.0f;
        for (Compra compra : cliente.getCompras()) {
            if (compra.getAnio().equals(anio)) {
                total += compra.getValor();
            }
        }
        return total;
    }

    public float obtenerCobro(String direccion, Year anio, Month mes) throws ClienteNoRegistradoException {
        Cliente cliente = getCliente(direccion);
        float total = 0.0f;
        for (Compra compra : cliente.getCompras()) {
            if (compra.getAnio().equals(anio) && compra.getMes().equals(mes)) {
                total += compra.getValor();
            }
        }
        return total;
    }

    private Cliente getCliente(String direccion) throws ClienteNoRegistradoException {
        Cliente cliente = clientes.get(direccion);
        if (cliente == null) {
            throw new ClienteNoRegistradoException(direccion);
        }
        return cliente;
    }

}
