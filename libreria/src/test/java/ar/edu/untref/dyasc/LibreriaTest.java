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

        // 50 * 0.95 = 47.5
        Assert.assertEquals(47.5f, cobro, Float.MIN_NORMAL);
    }

    @Test
    void CalculoTotalConUnaSuscripcionMensual() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Subscribible producto = new Subscribible("Gente", 50.0f, 4);
        repositorio.RegistrarSubscribible(producto);
        libreria.RegistrarCliente("direccion");

        libreria.Subscribir("direccion", "Gente", Year.of(2018), Month.SEPTEMBER);
        float cobro = libreria.ObtenerCobro("direccion", Year.of(2018));

        // 50 * 0.95 * 4 = 190
        Assert.assertEquals(190.0f, cobro, Float.MIN_NORMAL);
    }

    @Test
    void CalculoTotalConUnaSuscripcionAnual() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Subscribible producto = new Subscribible("Gente", 50.0f, 4);
        repositorio.RegistrarSubscribible(producto);
        libreria.RegistrarCliente("direccion");

        libreria.Subscribir("direccion", "Gente", Year.of(2018));
        float cobro = libreria.ObtenerCobro("direccion", Year.of(2018));

        // 50 * 0.8 * 4 * 12 = 1920
        Assert.assertEquals(1920.0f, cobro, Float.MIN_NORMAL);
    }

    @Test
    void CalculoMesConUnaCompra() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Producto producto = new Producto("Principito", 50.0f);
        repositorio.RegistrarProducto(producto);
        libreria.RegistrarCliente("direccion");

        libreria.Vender("direccion", "Principito", Year.of(2018), Month.SEPTEMBER);
        float cobro = libreria.ObtenerCobro("direccion", Year.of(2018), Month.SEPTEMBER);

        // 50 * 0.95 = 47.5
        Assert.assertEquals(47.5f, cobro, Float.MIN_NORMAL);
    }

    @Test
    void CalculoMesConUnaCompraEnOtroMes() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Producto producto = new Producto("Principito", 50.0f);
        repositorio.RegistrarProducto(producto);
        libreria.RegistrarCliente("direccion");

        libreria.Vender("direccion", "Principito", Year.of(2018), Month.AUGUST);
        float cobro = libreria.ObtenerCobro("direccion", Year.of(2018), Month.SEPTEMBER);

        Assert.assertEquals(0.0f, cobro, Float.MIN_NORMAL);
    }

    @Test
    void CalculoMesConUnaCompraDeOtroCliente() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Producto producto = new Producto("Principito", 50.0f);
        repositorio.RegistrarProducto(producto);
        libreria.RegistrarCliente("direccion");
        libreria.RegistrarCliente("Otradireccion");

        libreria.Vender("Otradireccion", "Principito", Year.of(2018), Month.SEPTEMBER);
        float cobro = libreria.ObtenerCobro("direccion", Year.of(2018), Month.SEPTEMBER);

        Assert.assertEquals(0.0f, cobro, Float.MIN_NORMAL);
    }

    @Test
    void CalculoMesConUnaCompraDeVariosClientes() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Producto producto = new Producto("Principito", 50.0f);
        Subscribible subscribible = new Subscribible("Gente", 50.0f, 4);
        repositorio.RegistrarProducto(producto);
        repositorio.RegistrarSubscribible(subscribible);
        String direccion = "direccion";
        libreria.RegistrarCliente(direccion);
        String otraDireccion = "otraDireccion";
        libreria.RegistrarCliente(otraDireccion);

        libreria.Vender(direccion, "Principito", Year.of(2018), Month.SEPTEMBER);
        libreria.Subscribir(otraDireccion, "Gente", Year.of(2018), Month.SEPTEMBER);
        float cobroCliente = libreria.ObtenerCobro(direccion, Year.of(2018), Month.SEPTEMBER);
        float cobroOtroCliente = libreria.ObtenerCobro(otraDireccion, Year.of(2018), Month.SEPTEMBER);

        // 50 * 0.95 = 47.5
        Assert.assertEquals(47.5f, cobroCliente, Float.MIN_NORMAL);
        // 50 * 0.95 * 4 = 190
        Assert.assertEquals(190.0f, cobroOtroCliente, Float.MIN_NORMAL);
    }

    @Test
    void CalculoMesesConComprasDeVariosClientes() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        String principito = "Principito";
        Producto producto = new Producto(principito, 50.0f);
        String gente = "Gente";
        Subscribible subscribible = new Subscribible(gente, 50.0f, 4);
        repositorio.RegistrarProducto(producto);
        repositorio.RegistrarSubscribible(subscribible);
        String cronica = "Cronica";
        subscribible = new Subscribible(cronica, 10.0f, 30);
        repositorio.RegistrarSubscribible(subscribible);
        String lapiz = "Lapiz";
        producto = new ArticuloDeLibreria(lapiz, 5.0f);
        repositorio.RegistrarProducto(producto);
        String direccion = "direccion";
        libreria.RegistrarCliente(direccion);
        String otraDireccion = "otraDireccion";
        libreria.RegistrarCliente(otraDireccion);

        libreria.Vender(direccion, principito, Year.of(2018), Month.AUGUST);
        libreria.Subscribir(direccion, cronica, Year.of(2018), Month.SEPTEMBER);
        libreria.Vender(direccion, cronica, Year.of(2018), Month.OCTOBER);
        libreria.Vender(direccion, lapiz, Year.of(2018), Month.OCTOBER);
        libreria.Subscribir(otraDireccion, gente, Year.of(2018), Month.AUGUST);
        libreria.Subscribir(otraDireccion, gente, Year.of(2018), Month.SEPTEMBER);
        libreria.Subscribir(otraDireccion, gente, Year.of(2018), Month.OCTOBER);
        libreria.Subscribir(otraDireccion, cronica, Year.of(2018));
        float cobroCliente = libreria.ObtenerCobro(direccion, Year.of(2018), Month.AUGUST);
        cobroCliente += libreria.ObtenerCobro(direccion, Year.of(2018), Month.SEPTEMBER);
        cobroCliente += libreria.ObtenerCobro(direccion, Year.of(2018), Month.OCTOBER);
        float cobroOtroCliente = libreria.ObtenerCobro(otraDireccion, Year.of(2018), Month.AUGUST);
        cobroOtroCliente += libreria.ObtenerCobro(otraDireccion, Year.of(2018), Month.SEPTEMBER);
        cobroOtroCliente += libreria.ObtenerCobro(otraDireccion, Year.of(2018), Month.OCTOBER);

        // principito: 50 * 0.95 = 47.5
        // cronica (Subscripcion Septiembre): 10 * 0.95 * 30 = 285
        // cronica (Venta Octubre): 10 * 0.95 = 9.5
        // lapiz: 5 * 1.21 * 0.95 = 5,7475
        // total: 47.5 + 285 + 9.5 + 5,7475 = 347.7475
        Assert.assertEquals(347.7475f, cobroCliente, Float.MIN_NORMAL);
        // gente: 50 * 4 * 3 * 0.95 = 570
        // cronica : 10 * 0.8 * 30 * 3 = 720
        // total: 570 + 720 = 1290
        Assert.assertEquals(1290.0f, cobroOtroCliente, Float.MIN_NORMAL);
    }
}
