package ar.edu.untref.dyasc.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModoTest {

    private Modo modo;
    private Parametros parametros;

    @BeforeEach
    public void setUpBeforeEach() throws Exception {
        parametros = new Parametros();
        modo = new Modo();
    }

    @Test
    void testLista() throws OpcionInvalidaException {
        comparar("l", true);
    }

    @Test
    void testSuma() throws OpcionInvalidaException {
        comparar("s", false);
    }

    @Test
    void testOpcionInvalida() {
        assertThrows(OpcionInvalidaException.class, () -> {
            modo.GetParametro(parametros, "x");
        });
    }

    private void comparar(String value, boolean lista) throws OpcionInvalidaException {
        modo.GetParametro(parametros, value);
        Assert.assertEquals(lista, parametros.isLista());
    }

}
