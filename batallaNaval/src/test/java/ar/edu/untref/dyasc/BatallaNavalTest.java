package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void disparoAlAgua() {
        Juego juego = new Juego();
        
        Impacto impacto = juego.disparo(0, 0);
        
        Assert.assertEquals(Impacto.AGUA, impacto);
    }

}
