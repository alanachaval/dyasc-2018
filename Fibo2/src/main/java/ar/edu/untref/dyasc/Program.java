package ar.edu.untref.dyasc;

public class Program {

    public static void main(String[] args) {

        Fibo fibo = new Fibo();
        long[] serie = fibo.generarSerie(Integer.parseInt(args[0]));
        String resultado = fibo.arrayAString(serie, true, true);
        System.out.println(resultado);

    }

}
