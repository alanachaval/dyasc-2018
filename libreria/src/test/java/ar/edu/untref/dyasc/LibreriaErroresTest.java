package ar.edu.untref.dyasc;

import org.junit.jupiter.api.Assertions;

import java.time.Month;
import java.time.Year;

import org.junit.jupiter.api.Test;

import ar.edu.untref.dyasc.excepciones.ClienteNoRegistradoException;
import ar.edu.untref.dyasc.excepciones.ProductoNoRegistradoException;

public class LibreriaErroresTest {

    @Test
    void CompraProductoNoRegistrado() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Subscribible subscribible = new Subscribible("Gente", 50.0f, 4);
        repositorio.registrarProducto(subscribible);
        libreria.registrarCliente("direccion");

        Assertions.assertThrows(ProductoNoRegistradoException.class, () -> {
            libreria.vender("direccion", "NoEsLaGente", Year.of(2018), Month.SEPTEMBER);
        });

        Assertions.assertThrows(ProductoNoRegistradoException.class, () -> {
            libreria.subscribir("direccion", "NoEsLaGente", Year.of(2018), Month.SEPTEMBER);
        });

        Assertions.assertThrows(ProductoNoRegistradoException.class, () -> {
            libreria.subscribir("direccion", "NoEsLaGente", Year.of(2018));
        });
    }

    @Test
    void CompraClienteNoRegistrado() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Subscribible subscribible = new Subscribible("Gente", 50.0f, 4);
        repositorio.registrarProducto(subscribible);
        libreria.registrarCliente("direccion");

        Assertions.assertThrows(ClienteNoRegistradoException.class, () -> {
            libreria.vender("NoEsLaDireccion", "Gente", Year.of(2018), Month.SEPTEMBER);
        });

        Assertions.assertThrows(ClienteNoRegistradoException.class, () -> {
            libreria.subscribir("NoEsLaDireccion", "Gente", Year.of(2018), Month.SEPTEMBER);
        });

        Assertions.assertThrows(ClienteNoRegistradoException.class, () -> {
            libreria.subscribir("NoEsLaDireccion", "Gente", Year.of(2018));
        });
    }

    @Test
    void CalculoTotalClienteNoRegistrado() {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        libreria.registrarCliente("direccion");

        Assertions.assertThrows(ClienteNoRegistradoException.class, () -> {
            libreria.obtenerValorVentas("NoEsLaDireccion", Year.of(2018), Month.SEPTEMBER);
        });

        Assertions.assertThrows(ClienteNoRegistradoException.class, () -> {
            libreria.obtenerValorCompras("NoEsLaDireccion", Year.of(2018));
        });
    }
}