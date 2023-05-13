package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduceish {

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(numbers));

        // let's have the sum of all numbers
        BinaryOperator<Integer> getSum = (accumulate, x) -> {
            Integer result = accumulate + x;
            System.out.println("accumulate: " + accumulate + ", x: " + x + " result: " + result);
            return result;
        };

        System.out.println("original numbers");
        System.out.println(numbersList);
        System.out.println("sum: " + numbersList.stream().reduce(0, getSum));
        System.out.println("without initial value arg the result will be an Optional");
        System.out.println("sum: " + numbersList.stream().reduce(getSum));
    }
}
