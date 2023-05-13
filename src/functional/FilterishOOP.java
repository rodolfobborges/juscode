package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterishOOP {


    public static List<String> getOnlyWordsWithLength(List<String> words, Integer length) {

        Predicate<String> byLength = s -> s.length() == length;
        return words.stream().filter(byLength).toList();
    }

    static Predicate<String> getByMaxLength(Integer maxLenth) {

        Function<Integer, Predicate<String>> lengthUpTo = (maxLength) -> {
            return (str) -> str.length() <= maxLength;
        };
        return lengthUpTo.apply(maxLenth);
    }

    public static List<String> getWordsWithLengthUntil(List<String> words, Integer maxLength) {

        return words.stream().filter(getByMaxLength(maxLength)).toList();
    }

    public static void main(String[] args) {

        String[] words = {"The", "dog", "bites", "its", "own", "tail"};
        System.out.println("words with length equals 4:");
        System.out.println(getOnlyWordsWithLength(Arrays.asList(words), 4));
        System.out.println("words with max length equals 4:");
        System.out.println(getWordsWithLengthUntil(Arrays.asList(words), 4));
    }
}
