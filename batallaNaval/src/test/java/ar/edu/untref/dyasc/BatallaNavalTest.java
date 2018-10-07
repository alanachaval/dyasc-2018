package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void disparoAlAgua() {
        Juego juego = new Juego(1);

        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.AGUA, impacto);
    }

    @Test
    public void hundeAlBoteDeUnDisparo() {
        Juego juego = new Juego(1);

        juego.agregarBote(0, 0);
        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.HUNDIDO, impacto);
    }

    @Test
    public void aguaLuegoDeHundirUnBote() {
        Juego juego = new Juego(1);

        juego.agregarBote(0, 0);
        juego.disparo(0, 0);
        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.AGUA, impacto);
    }

    @Test
    public void tocadoAlDispararAlCrucero() {
        Juego juego = new Juego(3);

        juego.agregarCrucero(0, 0, true);
        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.TOCADO, impacto);
    }

    @Test
    public void tocadoAlDispararAlCruceroEnLaMismaPosicionDosVeces() {
        Juego juego = new Juego(3);

        juego.agregarCrucero(0, 0, true);
        juego.disparo(0, 0);
        Impacto impacto = juego.disparo(0, 0);

        Assert.assertEquals(Impacto.TOCADO, impacto);
    }

    @Test
    public void hundidoLuegoDeImpactarAlCruceroEnTodasSusPosiciones() {
        Juego juego = new Juego(3);

        juego.agregarCrucero(0, 0, true);
        juego.disparo(0, 0);
        juego.disparo(1, 0);
        Impacto impacto = juego.disparo(2, 0);

        Assert.assertEquals(Impacto.HUNDIDO, impacto);
    }

    @Test
    public void noPermitirAgregarBarcoEnLugarOcupado() {
        Juego juego = new Juego(3);
        juego.agregarCrucero(0, 0, true);

        boolean creado = juego.agregarCrucero(0, 0, true);

        Assert.assertFalse(creado);
    }

    @Test
    public void permitirAgregarBarcoEnLugarLibre() {
        Juego juego = new Juego(3);
        juego.agregarCrucero(0, 0, true);

        boolean creado = juego.agregarCrucero(0, 2, true);

        Assert.assertTrue(creado);
    }

    @Test
    public void noPermitirAgregarBarcoAdyacenteAOtro() {
        Juego juego = new Juego(3);
        juego.agregarCrucero(0, 0, true);

        boolean creado = juego.agregarCrucero(0, 1, true);

        Assert.assertFalse(creado);
    }

    @Test
    public void noPermitirAgregarBarcoFueraDelTablero() {
        Juego juego = new Juego(3);

        boolean creado = juego.agregarCrucero(1, 0, true);

        Assert.assertFalse(creado);
    }

    @Test
    public void noPermitirAgregarBarcoEnPosicionNegativaDelTablero() {
        Juego juego = new Juego(3);

        boolean creado = juego.agregarCrucero(-1, 0, true);

        Assert.assertFalse(creado);
    }

}
