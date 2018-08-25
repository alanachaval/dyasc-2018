package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FiboTest {

    public static final int MAX_VALIDO = 91;
    private static final long[] SERIE = new long[] { 0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l, 21l, 34l, 55l, 89l, 144l, 233l,
            377l, 610l, 987l, 1597l, 2584l, 4181l, 6765l, 10946l, 17711l, 28657l, 46368l, 75025l, 121393l, 196418l,
            317811l, 514229l, 832040l, 1346269l, 2178309l, 3524578l, 5702887l, 9227465l, 14930352l, 24157817l,
            39088169l, 63245986l, 102334155l, 165580141l, 267914296l, 433494437l, 701408733l, 1134903170l, 1836311903l,
            2971215073l, 4807526976l, 7778742049l, 12586269025l, 20365011074l, 32951280099l, 53316291173l, 86267571272l,
            139583862445l, 225851433717l, 365435296162l, 591286729879l, 956722026041l, 1548008755920l, 2504730781961l,
            4052739537881l, 6557470319842l, 10610209857723l, 17167680177565l, 27777890035288l, 44945570212853l,
            72723460248141l, 117669030460994l, 190392490709135l, 308061521170129l, 498454011879264l, 806515533049393l,
            1304969544928657l, 2111485077978050l, 3416454622906707l, 5527939700884757l, 8944394323791464l,
            14472334024676221l, 23416728348467685l, 37889062373143906l, 61305790721611591l, 99194853094755497l,
            160500643816367088l, 259695496911122585l, 420196140727489673l, 679891637638612258l, 1100087778366101931l,
            1779979416004714189l, 2880067194370816120l };

    @Test
    void compararSerie() {
        Fibo fibo = new Fibo();
        long[] serie;
        long[] esperado;
        for (int i = 0; i <= FiboTest.MAX_VALIDO; i++) {
            esperado = getSerieFibo(i);
            serie = fibo.generarSerie(i);
            Assert.assertArrayEquals(esperado, serie);
        }
    }

    public static long[] getSerieFibo(int n) {
        long[] resultado = new long[n];
        System.arraycopy(SERIE, 0, resultado, 0, n);
        return resultado;
    }

}
