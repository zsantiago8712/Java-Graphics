package com.szs.javagraphics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para el manejo de archivos
 * @author Sebastian Castañeda
 **/
public class Files {

    /**
     * Lee archivos y guarda su contenido en un ArrayList
     * @param pathFile
     * @return ArrayList<String> (Los datos leidos del archivo)
     * @throws IOException
     */
    public ArrayList<String> readFile(String pathFile) throws IOException {
        try {
            ArrayList<String> lines = new ArrayList();
            Scanner data = new Scanner(new File(pathFile));
            String line = "";
            while (data.hasNext()){
                line = data.nextLine();
                if(!line.equals(""))
                    lines.add(line);
            }

            return lines;
        }catch(Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }
}
