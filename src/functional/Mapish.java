package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Mapish {

    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // times two function
        Function<Integer, Integer> timesTwo = (x) -> x * 2;

        // map
        List<Integer> doubledNumbers =
                Arrays.asList(numbers)
                        .stream()
                        .map(timesTwo)
                        .toList();

        System.out.println("original numbers:");
        System.out.println(Arrays.asList(numbers));
        System.out.println("doubled numbers:");
        System.out.print(doubledNumbers);
    }
}
