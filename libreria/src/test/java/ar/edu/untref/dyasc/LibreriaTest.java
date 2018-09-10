package ar.edu.untref.dyasc;

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
}
