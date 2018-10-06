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

    @Test
    public void hundeAlBoteDeUnDisparo() {
        Juego juego = new Juego();

        juego.agregarBote(0, 0);
        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.HUNDIDO, impacto);
    }

    @Test
    public void aguaLuegoDeHundirUnBote() {
        Juego juego = new Juego();

        juego.agregarBote(0, 0);
        juego.disparo(0, 0);
        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.AGUA, impacto);
    }

    @Test
    public void tocadoAlDispararAlCrucero() {
        Juego juego = new Juego();

        juego.agregarCrucero(0, 0, true);
        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.TOCADO, impacto);
    }

    @Test
    public void tocadoAlDispararAlCruceroEnLaMismaPosicionDosVeces() {
        Juego juego = new Juego();

        juego.agregarCrucero(0, 0, true);
        juego.disparo(0, 0);
        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.TOCADO, impacto);
    }

    @Test
    public void hundidoLuegoDeImpactarAlCruceroEnTodasSusPosiciones() {
        Juego juego = new Juego();

        juego.agregarCrucero(0, 0, true);
        juego.disparo(0, 0);
        juego.disparo(1, 0);
        Impacto impacto = juego.disparo(2, 0);

        Assert.assertEquals(Impacto.HUNDIDO, impacto);
    }

}
