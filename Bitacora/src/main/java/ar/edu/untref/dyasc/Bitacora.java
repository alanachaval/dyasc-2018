package ar.edu.untref.dyasc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bitacora {

    private static Bitacora instancia = new Bitacora();

    private FileWriter streamSalida;
    private List<Salida> salidas;

    private Bitacora() {
        salidas = new ArrayList<Salida>();
        
        //Class.forName("arg0").newInstance();
        
        String nombreArchivo = System.getProperty("DESTINO_BITACORA");
        if (nombreArchivo != null) {
            File archivoSalida = new File(nombreArchivo);
            try {
                streamSalida = new FileWriter(archivoSalida, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Bitacora getInstancia() {
        return instancia;
    }

    public void registrarEvento(String mensaje) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaHora = localDateTime.format(dateTimeFormatter);
        String evento = fechaHora + " " + mensaje;
        if (streamSalida != null) {
            try {
                streamSalida.write(evento + System.lineSeparator());
                streamSalida.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(evento);
        }
    }

    public void Cerrar() {
        if (streamSalida != null) {
            try {
                streamSalida.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
