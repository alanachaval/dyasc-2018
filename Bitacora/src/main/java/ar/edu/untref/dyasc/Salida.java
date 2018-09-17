package ar.edu.untref.dyasc;

import java.io.Closeable;
import java.io.IOException;

public interface Salida extends Closeable {

    public void registrarEvento(String mensaje) throws IOException;

}
