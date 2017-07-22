public class Main {
    
    public static void main(String[] args) {
        System.out.println(scrabble("ladilmy", "daily"));
        System.out.println(scrabble("eerriin", "eerie"));
        System.out.println(scrabble("orrpgma", "program"));
        System.out.println(scrabble("orppgma", "program"));
        
        System.out.println(scrabble("pizza??", "pizzazz"));
        System.out.println(scrabble("piizza?", "pizzazz"));
        System.out.println(scrabble("a??????", "program"));
        System.out.println(scrabble("b??????", "program"));
    } 
    
    public static boolean scrabble(String jumble, String word) {
        boolean isScrabble = true;
        int wildCards = 0;
        
        for (char c : jumble.toCharArray()) {
            if (c == '?') {
                wildCards++;
            }
        }
        
        for (char c : word.toCharArray()) {
            if (jumble.contains(c + "")) {
                jumble = jumble.replaceFirst(c + "", "");
            } else {
                if (wildCards != 0) {
                    wildCards--;
                } else {
                    isScrabble = false;
                    break;
                }
            }
        }
        
        return isScrabble;
    }
}
