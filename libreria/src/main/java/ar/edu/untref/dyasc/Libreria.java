package ar.edu.untref.dyasc;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class Libreria {

    private Map<String, Cliente> clientes;
    private RepositorioDeProductos repositorio;

    public Libreria(RepositorioDeProductos repositorio) {
        clientes = new HashMap<String, Cliente>();
        this.repositorio = repositorio;
    }

    public void RegistrarCliente(String direccion) {
        clientes.put(direccion, new Cliente(new Cuenta(), direccion));
    }

    public void Vender(String direccion, String producto, Year anio, Month mes) {
        Compra compra = new Compra(repositorio.GetProducto(producto), anio, mes);
        clientes.get(direccion).getCuenta().AgregarCompra(compra);
    }

    public void Subscribir(String direccion, String subscribible, Year anio) {
        for (Month mes : Month.values()) {
            Subscripcion subscripcion = new Subscripcion(repositorio.GetSubscribible(subscribible), anio, mes,
                    Duracion.ANUAL);
            clientes.get(direccion).getCuenta().AgregarCompra(subscripcion);
        }
    }

    public void Subscribir(String direccion, String subscribible, Year anio, Month mes) {
        Subscripcion subscripcion = new Subscripcion(repositorio.GetSubscribible(subscribible), anio, mes,
                Duracion.MENSUAL);
        clientes.get(direccion).getCuenta().AgregarCompra(subscripcion);
    }

    public float ObtenerCobro(String direccion, Year anio) {
        Cliente cliente = clientes.get(direccion);
        float total = 0.0f;
        for (Compra compra : cliente.getCuenta().getCompras()) {
            if (compra.getAnio().equals(anio)) {
                total += compra.getValor();
            }
        }
        return total;
    }

    public float ObtenerCobro(String direccion, Year anio, Month mes) {
        Cliente cliente = clientes.get(direccion);
        float total = 0.0f;
        for (Compra compra : cliente.getCuenta().getCompras()) {
            if (compra.getAnio().equals(anio) && compra.getMes().equals(mes)) {
                total += compra.getValor();
            }
        }
        return total;
    }

}
