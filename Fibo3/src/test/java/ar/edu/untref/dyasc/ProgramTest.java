package ar.edu.untref.dyasc;

import org.junit.jupiter.api.Test;

public class ProgramTest {

	// Fibo3
	@Test
	void testEjemplovdsalidatxt5() throws Throwable {
		WritterTest.compararStream("fibo<5> guardado en salida.txt" + FormatterTest.LINE_SEPARATOR, () -> {
			Program.main(new String[] { "-o=vd", "-f=salida.txt", "5" });
		});
		WritterTest.compararArchivo("salida.txt",
				"fibo<5>:" + FormatterTest.LINE_SEPARATOR + "0" + FormatterTest.LINE_SEPARATOR + "1"
						+ FormatterTest.LINE_SEPARATOR + "1" + FormatterTest.LINE_SEPARATOR + "2"
						+ FormatterTest.LINE_SEPARATOR + "3");
	}

	@Test
	void testEjemplovds5() throws Throwable {
		WritterTest.compararStream("fibo<5>: 7" + FormatterTest.LINE_SEPARATOR, () -> {
			Program.main(new String[] { "-o=hd", "-m=s", "5" });
		});
	}

	@Test
	void testEjemplovdsalidatxts5() throws Throwable {
		WritterTest.compararStream("fibo<5> guardado en salida.txt" + FormatterTest.LINE_SEPARATOR, () -> {
			Program.main(new String[] { "-o=vd", "-f=salida.txt", "-m=s", "5" });
		});
		WritterTest.compararArchivo("salida.txt", "fibo<5>:" + FormatterTest.LINE_SEPARATOR + "7");
	}

	// Fibo2
	@Test
	void testEjemplovd5() throws Throwable {
		WritterTest.compararStream("fibo<5>:" + FormatterTest.LINE_SEPARATOR + "0" + FormatterTest.LINE_SEPARATOR + "1"
				+ FormatterTest.LINE_SEPARATOR + "1" + FormatterTest.LINE_SEPARATOR + "2" + FormatterTest.LINE_SEPARATOR
				+ "3" + FormatterTest.LINE_SEPARATOR, () -> {
					Program.main(new String[] { "-o=vd", "5" });
				});
	}

	@Test
	void testEjemplohi8() throws Throwable {
		WritterTest.compararStream("fibo<8>: 13 8 5 3 2 1 1 0" + FormatterTest.LINE_SEPARATOR, () -> {
			Program.main(new String[] { "-o=hi", "8" });
		});
	}

	@Test
	void testEjemplovi8() throws Throwable {
		WritterTest.compararStream("fibo<8>:" + FormatterTest.LINE_SEPARATOR + "13" + FormatterTest.LINE_SEPARATOR + "8"
				+ FormatterTest.LINE_SEPARATOR + "5" + FormatterTest.LINE_SEPARATOR + "3" + FormatterTest.LINE_SEPARATOR
				+ "2" + FormatterTest.LINE_SEPARATOR + "1" + FormatterTest.LINE_SEPARATOR + "1"
				+ FormatterTest.LINE_SEPARATOR + "0" + FormatterTest.LINE_SEPARATOR, () -> {
					Program.main(new String[] { "-o=vi", "8" });
				});
	}

	@Test
	void testEjemploxy8() throws Throwable {
		WritterTest.compararStream("Opciones no validas." + FormatterTest.LINE_SEPARATOR, () -> {
			Program.main(new String[] { "-o=xy", "8" });
		});
	}

	// Fibo
	@Test
	void testEjemplo8() throws Throwable {
		WritterTest.compararStream("fibo<8>: 0 1 1 2 3 5 8 13" + FormatterTest.LINE_SEPARATOR, () -> {
			Program.main(new String[] { "8" });
		});
	}

	@Test
	void testEjemplo5() throws Throwable {
		WritterTest.compararStream("fibo<5>: 0 1 1 2 3" + FormatterTest.LINE_SEPARATOR, () -> {
			Program.main(new String[] { "5" });
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
			esperado = "fibo<" + Integer.toString(i) + ">:" + FormatterTest.getSerieFibo(i, horizontal, directa)
					+ FormatterTest.LINE_SEPARATOR;
			args[1] = Integer.toString(i);
			WritterTest.compararStream(esperado, () -> {
				Program.main(args);
			});
		}
	}

}
