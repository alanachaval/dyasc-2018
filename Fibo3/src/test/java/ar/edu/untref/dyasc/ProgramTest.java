package ar.edu.untref.dyasc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ProgramTest {

    @Test
    void testEjemplovd5() {
        String[] args = new String[] { "-o=vd", "5" };
        String esperado = "fibo<5>:\n0\n1\n1\n2\n3\n";
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Program.main(args);
        Assert.assertEquals(esperado, byteArrayOutputStream.toString());
    }

    @Test
    void testEjemplohi8() {
        String[] args = new String[] { "-o=hi", "8" };
        String esperado = "fibo<8>: 13 8 5 3 2 1 1 0\n";
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Program.main(args);
        Assert.assertEquals(esperado, byteArrayOutputStream.toString());
    }

    @Test
    void testEjemplovi8() {
        String[] args = new String[] { "-o=vi", "8" };
        String esperado = "fibo<8>:\n13\n8\n5\n3\n2\n1\n1\n0\n";
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Program.main(args);
        Assert.assertEquals(esperado, byteArrayOutputStream.toString());
    }

    @Test
    void testEjemploxy8() {
        String[] args = new String[] { "-o=xy", "8" };
        String esperado = "Opciones no validas.\n";
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Program.main(args);
        Assert.assertEquals(esperado, byteArrayOutputStream.toString());
    }

    @Test
    void testEjemplo8() {
        String[] args = new String[] { "8" };
        String esperado = "fibo<8>: 0 1 1 2 3 5 8 13\n";
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Program.main(args);
        Assert.assertEquals(esperado, byteArrayOutputStream.toString());
    }

    @Test
    void testConsolaHorizontalDirecta() {
        compararSerieConsola(true, true);
    }

    @Test
    void testConsolaHorizontalInversa() {
        compararSerieConsola(true, false);
    }

    @Test
    void testConsolaVerticalDirecta() {
        compararSerieConsola(false, true);
    }

    @Test
    void testConsolaVerticalInversa() {
        compararSerieConsola(false, false);
    }

    private static void compararSerieConsola(boolean horizontal, boolean directa) {
        String[] args = new String[2];
        args[0] = "-o=";
        if (horizontal) {
            args[0] += "h";
        } else {
            args[0] += "v";
        }
        if (directa) {
            args[0] += "d";
        } else {
            args[0] += "i";
        }
        String esperado;
        ByteArrayOutputStream byteArrayOutputStream;
        for (int i = 0; i <= FiboTest.MAX_VALIDO; i++) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(byteArrayOutputStream));
            esperado = "fibo<" + Integer.toString(i) + ">:" + FormatterTest.getSerieFibo(i, horizontal, directa) + "\n";
            args[1] = Integer.toString(i);
            Program.main(args);
            Assert.assertEquals(esperado, byteArrayOutputStream.toString());
        }
    }

}
