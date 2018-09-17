package ar.edu.untref.dyasc;

import java.io.IOException;

public class SalidaConsola implements Salida {

    @Override
    public void registrarEvento(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void close() throws IOException {
    }

}
