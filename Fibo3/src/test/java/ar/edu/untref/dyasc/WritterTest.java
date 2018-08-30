package ar.edu.untref.dyasc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import ar.edu.untref.dyasc.parser.OpcionInvalidaException;

public class WritterTest {

	private Writter writter;

	@BeforeEach
	public void setUpBeforeEach() throws Exception {
		writter = new Writter();
	}

	@Test
	void testStream() throws Throwable {
		String mensaje = "fibo<5>:" + FormatterTest.LINE_SEPARATOR + "0" + FormatterTest.LINE_SEPARATOR + "1"
				+ FormatterTest.LINE_SEPARATOR + "1" + FormatterTest.LINE_SEPARATOR + "2" + FormatterTest.LINE_SEPARATOR
				+ "3";
		compararStream(mensaje + FormatterTest.LINE_SEPARATOR, () -> {
			writter.escribirResultado(null, mensaje);
		});
	}

	@Test
	void testArchivo() throws OpcionInvalidaException, IOException {
		String archivo = "salida.txt";
		String esperado = "fibo<5>:\\n0\\n1\\n1\\n2\\n3\\n";
		writter.escribirResultado(archivo, esperado);
		compararArchivo(archivo, esperado);
	}

	@Test
	void testMensajeArchivo() throws Throwable {
		String archivo = "salida.txt";
		String esperado = "fibo<5>:\\n0\\n1\\n1\\n2\\n3\\n";
		compararStream("fibo<5> guardado en salida.txt" + FormatterTest.LINE_SEPARATOR, () -> {
			writter.escribirResultado(archivo, esperado);
		});
	}

	public static void compararStream(String esperado, Executable executable) throws Throwable {
		ByteArrayOutputStream byteArrayOutputStream;
		byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
		executable.execute();
		Assert.assertEquals(esperado, byteArrayOutputStream.toString());
	}

	public static void compararArchivo(String archivo, String esperado) throws IOException {
		String obtenido = readFile(archivo, Charset.defaultCharset());
		Assert.assertEquals(esperado, obtenido);
	}

	private static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
