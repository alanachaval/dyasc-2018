package ar.edu.untref.dyasc;

public class SalidaFactory {

    public static Salida instanciarSalida(String destino) {
        Salida salida = null;
        if (destino.equals("CONSOLA")) {
            salida = new SalidaConsola();
        } else {
            salida = new SalidaArchivo(destino);
        }
        return salida;
    }

}
