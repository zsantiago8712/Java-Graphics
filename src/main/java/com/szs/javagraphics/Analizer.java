package com.szs.javagraphics;

import java.util.ArrayList;

/**
 * Clase para analizar y limpiar los datos de un arrayList
 * @author Santiago Zamora
 */
public class Analizer {

    /**
     * Limpia los Strings de links y de carácteres especiales
     * @param tweets
     * @return ArraList<String>
     */
    public ArrayList<String> cleanTweets(ArrayList<String> tweets) {

        ArrayList<String>cleanTweets = new ArrayList<String>();

        for (String tweet : tweets){
            tweet = tweet.replaceAll("https?://\\S+\\s?", "");
            tweet = tweet.replaceAll("\\W", " ");
            cleanTweets.add(tweet);
        }

        return cleanTweets;
    }

    /**
     * Cuenta la repetición de palabras en los Strings guardados en el ArrayList
     * @param tweets
     * @param wordsToFind
     * @return int[] -> numero de veces que se encontro las palabras
     */
    public int[] countWordsInTweet(ArrayList<String> tweets, ArrayList<String> wordsToFind) {

        int[] numberOfWords = new int[wordsToFind.size()];
        int index = 0;
        for(String tweet : tweets){
            for(String wordToFind : wordsToFind){
                if(tweet.contains(wordToFind)) {

                    String[] words = tweet.split(" ");
                    for(String word : words){
                        if(word.equals(wordToFind))
                            numberOfWords[index]++;
                    }

                }

                index++;
            }
            index = 0;
        }

        return numberOfWords;
    }
}
