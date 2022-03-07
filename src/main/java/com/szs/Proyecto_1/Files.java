package com.szs.Proyecto_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {


    private ArrayList<String> wordsToSearches = new ArrayList();
    private ArrayList<String> tweets = new ArrayList();

    public ArrayList<String> readFile(String pathFile) throws IOException {
        try {
            ArrayList lines = new ArrayList();
            Scanner data = new Scanner(new File(pathFile));
            while (data.hasNextLine())
                lines.add(data.nextLine());

            return lines;
        }catch(Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    public void setWordsToSearches(ArrayList wordsToSearches) {
        this.wordsToSearches = wordsToSearches;
    }

    public void setTweets(ArrayList tweets) {
        this.tweets = tweets;
    }

}
