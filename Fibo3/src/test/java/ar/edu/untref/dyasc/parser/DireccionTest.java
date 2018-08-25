package ar.edu.untref.dyasc.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DireccionTest {

    private Direccion direccion;
    private Parametros parametros;

    @BeforeEach
    public void setUpBeforeEach() throws Exception {
        parametros = new Parametros();
        direccion = new Direccion();
    }

    @Test
    void testHorizontalDirecta() throws OpcionInvalidaException {
        comparar("hd", true, true);
    }

    @Test
    void testHorizontalInversa() throws OpcionInvalidaException {
        comparar("hi", true, false);
    }

    @Test
    void testVerticalDirecta() throws OpcionInvalidaException {
        comparar("vd", false, true);
    }

    @Test
    void testVerticalInversa() throws OpcionInvalidaException {
        comparar("vi", false, false);
    }

    @Test
    void testOpcionInvalida() {
        assertThrows(OpcionInvalidaException.class, () -> {
            direccion.GetParametro(parametros, "xy");
        });
    }

    private void comparar(String value, boolean horizontal, boolean directa) throws OpcionInvalidaException {
        direccion.GetParametro(parametros, value);
        Assert.assertEquals(horizontal, parametros.isHorizontal());
        Assert.assertEquals(directa, parametros.isDirecta());
    }

}
