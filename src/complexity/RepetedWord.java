package complexity;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepetedWord {

    private static final Logger logger = Logger.getGlobal();

    /**
     * if text "dog banana orange boat dog" return "dog"
     * Complexity: O(n)
     *
     */
    public static String getMostRepeatedWord3(String text) {
        String[] words = text.split(" ");
        Map<String, Integer> map = new HashMap<>(words.length);
        int operations = 0;

        for (String word : words) {
            operations++;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        logger.log(Level.INFO, "Total Operations => {0}", Integer.toString(operations));
        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    /**
     * if text "dog banana orange boat dog" return "dog"
     * Complexity: O(n log n)
     */
    public static String getMostRepeatedWord2(String text) {

        String[] words = text.split(" ");
        String wordMoreMatched = "";
        String lastWord = "";
        int wordMatches = 0;
        int maxMatches = 0;
        int operations = 0;

        Arrays.sort(words);
        operations++;

        for (int i = 0; i < words.length; i++) {
            operations++;

            if (words[i].equals(lastWord)) {
                wordMatches++;

                if (wordMatches > maxMatches) {
                    maxMatches = wordMatches;
                    wordMoreMatched = lastWord;
                }
                continue;
            }

            operations++;

            if (i+1 < words.length
                    && Arrays.binarySearch(words, i+1, words.length-1, words[i]) != -1) {
                wordMatches = 1;
                lastWord = words[i];
            }
        }

        logger.log(Level.INFO, "Total Operations => {0}", Integer.toString(operations));
        return wordMoreMatched;
    }


    /**
     * if text "dog banana orange boat dog" return "dog"
     * Complexity: quadratic time O(n²)
     */
    public static String getMostRepeatedWord1(String text) {

        String[] words = text.split(" ");
        String wordMoreMatched = "";
        int wordMatches = 0;
        int maxMatches = 0;
        int operations = 0;

        for (String word : words) {

            for (String wordToCompare : words) {

                if (word.equals(wordToCompare)) {
                    wordMatches++;
                }
                operations++;
            }

            if (wordMatches > maxMatches) {
                maxMatches = wordMatches;
                wordMoreMatched = word;
            }
            operations++;

            wordMatches = 0;
        }

        logger.log(Level.INFO, "Total Operations => {0}", Integer.toString(operations));
        return wordMoreMatched;
    }

    public static void main(String[] args) {

        String words = "dog dog dog dog dog banana orange boat dog dog";
        StringBuilder text = new StringBuilder(words);
        for (int i = 0; i < 9999; i++) {
            text.append(" ");
            text.append(words);
        }

        logger.log(Level.INFO, "Total of words => {0}", Integer.toString(text.toString().split(" ").length));

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        logger.log(Level.INFO, "Method 1 - word: {0}", getMostRepeatedWord1(text.toString()));
        endTime = System.currentTimeMillis();
        logger.log(Level.INFO, "took {0} ms", Long.toString(endTime - startTime));

        startTime = System.currentTimeMillis();
        logger.log(Level.INFO, "Method 2 - word: {0}", getMostRepeatedWord2(text.toString()));
        endTime = System.currentTimeMillis();
        logger.log(Level.INFO, "took {0} ms", Long.toString(endTime - startTime));

        startTime = System.currentTimeMillis();
        logger.log(Level.INFO, "Method 3 - word: {0}", getMostRepeatedWord3(text.toString()));
        endTime = System.currentTimeMillis();
        logger.log(Level.INFO, "took {0} ms", Long.toString(endTime - startTime));
    }
}
