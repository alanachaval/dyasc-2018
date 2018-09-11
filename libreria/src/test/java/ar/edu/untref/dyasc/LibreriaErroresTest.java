package ar.edu.untref.dyasc;

import org.junit.jupiter.api.Assertions;

import java.time.Month;
import java.time.Year;

import org.junit.jupiter.api.Test;

import ar.edu.untref.dyasc.excepciones.ProductoNoRegistradoException;

public class LibreriaErroresTest {

    @Test
    void CompraProductoNoRegistrado() throws ProductoNoRegistradoException {
        RepositorioDeProductos repositorio = new RepositorioDeProductos();
        Libreria libreria = new Libreria(repositorio);
        Producto producto = new Producto("Principito", 50.0f);
        repositorio.registrarProducto(producto);
        libreria.registrarCliente("direccion");
        
        Assertions.assertThrows(ProductoNoRegistradoException.class, () -> {
            libreria.vender("direccion", "NoEsElPrincipito", Year.of(2018), Month.SEPTEMBER);
        });
    }
}