package complexity;


public class NonRepeatedCharacter {

    /**
     * given a String this function should return the first non-repeated character
     * Example: if "rodolfo borges" then should return 'd'
     */
    public char getFirstNonRepeatedCharacter(String input) {
        char firstNonRepeatedChar = ' ';
        char[] characters = input.toCharArray();
        for (char chari : characters) {
            int count = 0;
            for (char charj : characters) {
                if (chari == charj) {
                    count++;
                }
            }
            if (count == 1) {
                firstNonRepeatedChar = chari;
                break;
            }
        }
        return firstNonRepeatedChar;
    }

    public static void main(String[] args) {
        System.out.println(new NonRepeatedCharacter().getFirstNonRepeatedCharacter("rodolfo borges"));
        System.out.println(new NonRepeatedCharacter().getFirstNonRepeatedCharacter("dddddddoooooooooooog"));
    }
}
