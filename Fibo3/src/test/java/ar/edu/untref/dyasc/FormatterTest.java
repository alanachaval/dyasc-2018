package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FormatterTest {

    public static final String LINE_SEPARATOR = System.lineSeparator();

    private static final String[] SERIE = new String[] { "0", "1", "1", "2", "3", "5", "8", "13", "21", "34", "55",
            "89", "144", "233", "377", "610", "987", "1597", "2584", "4181", "6765", "10946", "17711", "28657", "46368",
            "75025", "121393", "196418", "317811", "514229", "832040", "1346269", "2178309", "3524578", "5702887",
            "9227465", "14930352", "24157817", "39088169", "63245986", "102334155", "165580141", "267914296",
            "433494437", "701408733", "1134903170", "1836311903", "2971215073", "4807526976", "7778742049",
            "12586269025", "20365011074", "32951280099", "53316291173", "86267571272", "139583862445", "225851433717",
            "365435296162", "591286729879", "956722026041", "1548008755920", "2504730781961", "4052739537881",
            "6557470319842", "10610209857723", "17167680177565", "27777890035288", "44945570212853", "72723460248141",
            "117669030460994", "190392490709135", "308061521170129", "498454011879264", "806515533049393",
            "1304969544928657", "2111485077978050", "3416454622906707", "5527939700884757", "8944394323791464",
            "14472334024676221", "23416728348467685", "37889062373143906", "61305790721611591", "99194853094755497",
            "160500643816367088", "259695496911122585", "420196140727489673", "679891637638612258",
            "1100087778366101931", "1779979416004714189", "2880067194370816120" };

    @Test
    void testHorizontalDirecta() {
        compararSerie(true, true);
    }

    @Test
    void testHorizontalInversa() {
        compararSerie(true, false);
    }

    @Test
    void testVerticalDirecta() {
        compararSerie(false, true);
    }

    @Test
    void testVerticalInversa() {
        compararSerie(false, false);
    }

    private static void compararSerie(boolean horizontal, boolean directa) {
        Fibo fibo = new Fibo();
        Formatter formatter = new Formatter();
        long[] serie;
        String esperado;
        String obtenido;
        for (int i = 0; i <= FiboTest.MAX_VALIDO; i++) {
            esperado = "fibo<" + Integer.toString(i) + ">:" + getSerieFibo(i, horizontal, directa);
            serie = fibo.generarSerie(i);
            obtenido = formatter.arrayAString(serie, horizontal, directa, true);
            Assert.assertEquals(esperado, obtenido);
        }
    }

    public static String getSerieFibo(int n, boolean horizontal, boolean directa) {
        String separador;
        StringBuilder resultado = new StringBuilder();
        if (horizontal) {
            separador = " ";
        } else {
            separador = LINE_SEPARATOR;
        }
        if (directa) {
            for (int i = 0; i < n; i++) {
                resultado.append(separador + SERIE[i]);
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                resultado.append(separador + SERIE[i]);
            }
        }
        return resultado.toString();
    }

}
