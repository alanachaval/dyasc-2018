package ar.edu.untref.dyasc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writter {

    public void escribirResultado(String archivo, String resultado) {
        if (archivo == null) {
            System.out.println(resultado);
        } else {
            File file = new File(archivo);
            try {
                file.createNewFile();
                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(resultado);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
