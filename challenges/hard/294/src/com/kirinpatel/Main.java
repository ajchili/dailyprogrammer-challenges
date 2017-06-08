/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kirinpatel
 */
public class Main {
    
    
    
    public static final int[] LETTER_VALUE = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private static String chars = "sd?zeioao?mluvepesceinfxt?wyiru?ie?giator?t??nuefje?l?odndrotpewlgoobiinysagacaqski?aeh?rbhaervtnl?m";
    public static ArrayList<String> words = new ArrayList<>();
    public static ArrayList<String> useableWords = new ArrayList<>();
    public static String tiles = "";
    
    public static void main(String[] args) {
        getWords();
        getTiles();
        highest(tiles);
    }
    
    public static void getTiles() {
        Random r = new Random();
        while (tiles.length() < 10) {
            if (r.nextBoolean()) {
                tiles += chars.charAt(0);
                chars = chars.substring(1);
            } else {
                tiles += chars.charAt(chars.length() - 1);
                chars = chars.substring(0, chars.length() - 2);
            }
        }
    }
    
    public static void getWords() {
        Scanner s = null;
        try {
            s = new Scanner(new File("../enable1.txt"));
        } catch (FileNotFoundException ex) {
            
        }
        
        while (s.hasNext()) {
            words.add(s.next());
        }
    }
    
    public static boolean determineIfPossible(String word, String possibleWord, String jumble, char c, int iteration) {
        int index = jumble.indexOf(c);
        for (int i = 0; i < jumble.length(); i++)
            if (i != index) {
                char d = jumble.charAt(i);
                if (possibleWord.length() > 1 * iteration)
                    if (possibleWord.contains("" + d)) {
                        possibleWord = possibleWord.substring(0, possibleWord.indexOf(d)) + possibleWord.substring(possibleWord.indexOf(d) + 1);

                        if (possibleWord.length() == 1 * iteration)
                            return true;
                    } else if (d == '?')
                        if (determineIfPossible(word, possibleWord, jumble, c, iteration + 1)) {
                            useableWords.add(word);
                            break;
                        }
                else
                    return true;
            }
        return false;
    }
    
    public static void highest(String jumble) {
        ArrayList<String> possibleWords = new ArrayList<>(words);
        
        for (String word : words) {
            String possibleWord = word;
            if (possibleWord.length() <= jumble.length())
                for (char c : jumble.toCharArray())
                    if (possibleWord.length() > 0)
                        if (possibleWord.contains("" + c)) {
                            possibleWord = possibleWord.substring(0, possibleWord.indexOf(c)) + possibleWord.substring(possibleWord.indexOf(c) + 1);
                            
                            if (possibleWord.length() == 0) {
                                useableWords.add(word);
                                break;
                            }
                        } else if (c == '?')
                            if (determineIfPossible(word, possibleWord, jumble, c, 1)) {
                                useableWords.add(word);
                                break;
                            }
                    else {
                        useableWords.add(word);
                        break;
                    }
        }
        
        int highestScore = 0;
        String highestWord = "";
        for (String word : useableWords) {
            int score = 0;
            
            for (int i = 0; i < word.length(); i++)
                score += LETTER_VALUE[word.charAt(i) - 97] * (i + 1);
            
            if (score > highestScore) {
                highestScore = score;
                highestWord = word;
            }
        }
        
        System.out.println(highestScore + " : " + highestWord + " : " + tiles);
    }
}
