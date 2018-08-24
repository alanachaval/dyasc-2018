package ar.edu.untref.dyasc;

public class Program {

    public static void main(String[] args) {

        int cantidadDeElementos;
        boolean horizontal;
        boolean directa;
        if (args.length == 2) {
            if (args[0].length() != 5 || !args[0].substring(0, 3).equals("-o=")
                    || (!args[0].substring(3, 4).equals("h") && !args[0].substring(3, 4).equals("v"))
                    || (!args[0].substring(4, 5).equals("d") && !args[0].substring(4, 5).equals("i"))) {
                System.out.print("Opciones no validas.");
                return;
            }
            horizontal = args[0].substring(3, 4).equals("h");
            directa = args[0].substring(4, 5).equals("d");
            cantidadDeElementos = Integer.parseInt(args[1]);
        } else {
            cantidadDeElementos = Integer.parseInt(args[0]);
            horizontal = true;
            directa = true;
        }

        Fibo fibo = new Fibo();
        long[] serie = fibo.generarSerie(cantidadDeElementos);
        String resultado = fibo.arrayAString(serie, horizontal, directa);
        System.out.print(resultado);

    }

}
