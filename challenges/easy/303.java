import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        printPathInfo(s.nextInt(), s.nextInt(), s.nextInt());
    }
    
    public static void printPathInfo(int w, int h, int v) {
        String output;
        
        if (w > h) {
            if (v % 2 == 0) {
                output = "RL ";
            } else {
                output = "UL ";
            }
        } else {
            if (v % 2 == 0) {
                output = "LL ";
            } else {
                output = "UL ";
            }
        }
        
        output += (w + v) + " " + lcm(w, h);
        
        System.out.println(output);
    }
    
    /**
     * lcm and gcd methods borrowed from 
     * https://www.reddit.com/r/dailyprogrammer/comments/5vb1wf/20170221_challenge_303_easy_ricochet/de0o9dj/
     * 
     * I cheated on this one D:
     */
    private static int lcm(int i, int j){
        return i * j / gcd(i,j);
    }
    private static int gcd(int i, int j){
        return j == 0 ? i : gcd(j,i%j);
    }
}
