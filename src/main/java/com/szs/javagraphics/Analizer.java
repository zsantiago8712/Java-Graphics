package com.szs.javagraphics;

import java.util.ArrayList;

public class Analizer {

    public ArrayList<String> cleanTweets(ArrayList<String> tweets) {

        ArrayList<String>cleanTweets = new ArrayList<String>();

        for (String tweet : tweets){
            tweet = tweet.replaceAll("\\W", " ");
            cleanTweets.add(tweet);
        }

        return cleanTweets;
    }

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
