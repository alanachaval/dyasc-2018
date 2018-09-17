package ar.edu.untref.dyasc;

public class SalidaFactory {

    public static Salida instanciarSalida(String clase) {
        Salida salida = null;
        if (clase.equals("CONSOLA")) {
            salida = new SalidaConsola();
        } else {
            salida = new SalidaArchivo(clase);
        }
        return salida;
    }

}
