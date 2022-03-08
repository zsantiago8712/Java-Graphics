package com.szs.javagraphics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

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
