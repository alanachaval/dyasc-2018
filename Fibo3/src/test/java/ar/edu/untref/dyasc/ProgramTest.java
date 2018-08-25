package ar.edu.untref.dyasc;

import org.junit.jupiter.api.Test;

public class ProgramTest {

    @Test
    void testEjemplovd5() throws Throwable {
        WritterTest.compararStream("fibo<5>:\n0\n1\n1\n2\n3\n", () -> {
            Program.main(new String[] { "-o=vd", "5" });
        });
    }

    @Test
    void testEjemplohi8() throws Throwable {
        WritterTest.compararStream("fibo<8>: 13 8 5 3 2 1 1 0\n", () -> {
            Program.main(new String[] { "-o=hi", "8" });
        });
    }

    @Test
    void testEjemplovi8() throws Throwable {
        WritterTest.compararStream("fibo<8>:\n13\n8\n5\n3\n2\n1\n1\n0\n", () -> {
            Program.main(new String[] { "-o=vi", "8" });
        });
    }

    @Test
    void testEjemploxy8() throws Throwable {
        WritterTest.compararStream("Opciones no validas.\n", () -> {
            Program.main(new String[] { "-o=xy", "8" });
        });
    }

    @Test
    void testEjemplo8() throws Throwable {
        WritterTest.compararStream("fibo<8>: 0 1 1 2 3 5 8 13\n", () -> {
            Program.main(new String[] { "8" });
        });
    }

    @Test
    void testConsolaHorizontalDirecta() throws Throwable {
        compararSerieConsola(true, true);
    }

    @Test
    void testConsolaHorizontalInversa() throws Throwable {
        compararSerieConsola(true, false);
    }

    @Test
    void testConsolaVerticalDirecta() throws Throwable {
        compararSerieConsola(false, true);
    }

    @Test
    void testConsolaVerticalInversa() throws Throwable {
        compararSerieConsola(false, false);
    }

    private void compararSerieConsola(boolean horizontal, boolean directa) throws Throwable {
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
        for (int i = 0; i <= FiboTest.MAX_VALIDO; i++) {
            esperado = "fibo<" + Integer.toString(i) + ">:" + FormatterTest.getSerieFibo(i, horizontal, directa) + "\n";
            args[1] = Integer.toString(i);
            WritterTest.compararStream(esperado, () -> {
                Program.main(args);
            });
        }
    }

}
