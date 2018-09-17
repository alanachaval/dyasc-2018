package ar.edu.untref.dyasc;

public class SalidaConsola implements Salida {

    @Override
    public void registrarEvento(String mensaje) {

        System.out.println(mensaje);
    }

}
