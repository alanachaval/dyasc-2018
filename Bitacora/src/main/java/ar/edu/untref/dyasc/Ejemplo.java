package ar.edu.untref.dyasc;

public class Ejemplo {

    public static void main(String[] args) {

        Bitacora bitacora = Bitacora.getInstancia();

        bitacora.registrarEvento("Iniciando ejecución");

        bitacora.registrarEvento("Finalizando ejecución");

        bitacora.close();
    }

}
