package ar.edu.untref.dyasc;

import java.time.Month;
import java.time.Year;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LibreriaTest {

    @Test
    void CalculoTotalSinCompras() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        libreria.RegistrarCliente("direccion");
        
        float cobro = libreria.ObtenerCobro("direccion", Year.of(2018));
        
        Assert.assertEquals(0.0f, cobro, Float.MIN_NORMAL);
    }

    @Test
    void CalculoTotalConUnaCompra() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Producto producto = new Producto("Principito", 50.0f);
        repositorio.RegistrarProducto(producto);
        libreria.RegistrarCliente("direccion");
        
        libreria.Vender("direccion", "Principito", Year.of(2018), Month.SEPTEMBER);
        float cobro = libreria.ObtenerCobro("direccion", Year.of(2018));
        
        //50 * 0.95 = 47.5
        Assert.assertEquals(47.5f, cobro, Float.MIN_NORMAL);
    }
}
