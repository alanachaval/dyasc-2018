package ar.edu.untref.dyasc;

import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bitacora implements Closeable {

    private static Bitacora instancia = new Bitacora();

    private List<Salida> salidas;

    private Bitacora() {
        salidas = new ArrayList<Salida>();
        String bitacoraDestino = System.getProperty("bitacora.destino");
        String[] destinos;
        if (bitacoraDestino != null) {
            destinos = bitacoraDestino.split(",");
            for (String destino : destinos) {
                destino = destino.trim();
                if (!destino.isEmpty()) {
                    salidas.add(SalidaFactory.instanciarSalida(destino));
                }
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
        for (Salida salida : salidas) {
            try {
                salida.registrarEvento(evento);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        for (Salida salida : salidas) {
            try {
                salida.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
