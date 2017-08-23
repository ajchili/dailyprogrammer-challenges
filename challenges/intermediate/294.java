import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static final int[] LETTER_VALUE = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    public static ArrayList<String> words = new ArrayList<>();
    
    public static void main(String[] args) {
        getWords();
        highest("vepredequi");
    }
    
    public static void getWords() {
        Scanner s = null;
        try {
            s = new Scanner(new File("res/enable1.txt"));
        } catch (FileNotFoundException ex) {
            
        }
        
        while (s.hasNext()) {
            words.add(s.next());
        }
    }
    
    public static void highest(String jumble) {
        ArrayList<String> possibleWords = new ArrayList<>(words);
        ArrayList<String> useableWords = new ArrayList<>();
        int wordsChecked = 0;
        int originalSize = possibleWords.size();
        
        for (String word : words) {
            wordsChecked++;
            if (wordsChecked % (originalSize / 100) == 0) {
                //System.out.println("Processing words... (" + ((wordsChecked * 100) / originalSize) + "/100)");
            }
            
            String possibleWord = word;
            if (possibleWord.length() <= jumble.length()) {
                for (char c : jumble.toCharArray()) {
                    if (possibleWord.length() > 0) {
                        if (possibleWord.contains("" + c)) {
                            possibleWord = possibleWord.substring(0, possibleWord.indexOf(c)) + possibleWord.substring(possibleWord.indexOf(c) + 1);
                            
                            if (possibleWord.length() == 0) {
                                useableWords.add(word);
                                break;
                            }
                        }
                    } else {
                        useableWords.add(word);
                        break;
                    }
                }
            }
        }
        
        int highestScore = 0;
        String highestWord = "";
        for (String word : useableWords) {
            int score = 0;
            
            for (int i = 0; i < word.length(); i++) {
                score += LETTER_VALUE[word.charAt(i) - 97] * (i + 1);
            }
            
            if (score > highestScore) {
                highestScore = score;
                highestWord = word;
            }
        }
        
        System.out.println(highestScore + " : " + highestWord);
    }
}
