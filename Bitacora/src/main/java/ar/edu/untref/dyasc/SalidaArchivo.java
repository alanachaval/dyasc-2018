package ar.edu.untref.dyasc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo implements Salida {

    private FileWriter streamSalida;

    public SalidaArchivo(String nombreArchivo) {
        File archivoSalida = new File(nombreArchivo);
        try {
            streamSalida = new FileWriter(archivoSalida, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registrarEvento(String mensaje) throws IOException {
        streamSalida.write(mensaje + System.lineSeparator());
        streamSalida.flush();
    }

    @Override
    public void close() throws IOException {
        streamSalida.close();
    }

}
