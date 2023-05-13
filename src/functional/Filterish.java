package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Filterish {

    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // even predicate
        Predicate<Integer> takeEvens = (x) -> x % 2 == 0;

        List<Integer> evens =
                Arrays.stream(numbers)
                        .filter(takeEvens)
                        .toList();

        System.out.println("original numbers");
        System.out.println(Arrays.asList(numbers));
        System.out.println("just even numbers");
        System.out.println(evens);
    }
}
