package functional.bitrino;

import java.util.Arrays;
import java.util.function.BiFunction;

public class MyFunctions {

    public static void main(String[] args) {

        BiFunction<String, String, Integer> tryAdd = (s1, s2) -> {
            try {
                int int1 = Integer.parseInt(s1);
                int int2 = Integer.parseInt(s2);
                return int1 + int2;
            } catch (NumberFormatException exception) {
                System.out.println("One of the arguments can't be formatted as an integer number");
                return 0;
            }
        };

        System.out.println("Result of the BiFunction:");
        System.out.println(tryAdd.apply("10", "10"));
        System.out.println("With wrong arguments:");
        System.out.println(tryAdd.apply("t", "20"));

        TriFunction<Integer, Integer, Integer, Integer> addTri = (t, u, v) -> t + u + v;

        System.out.println("Result of my TriFunction:");
        System.out.println(addTri.apply(10, 20, 30));

        NoArgFunction<Integer[]> countTo10 = () -> new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Result of my NoArgFunction:");
        System.out.println(Arrays.asList(countTo10.apply()));
    }
}
