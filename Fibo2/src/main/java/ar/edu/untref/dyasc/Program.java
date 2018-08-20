package ar.edu.untref.dyasc;

public class Program {

    public static void main(String[] args) {

        Fibo fibo = new Fibo();
        String resultado = fibo.generarSerie(Integer.parseInt(args[0]));
        System.out.println(resultado);

    }

}
