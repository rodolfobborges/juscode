package recursion;

import java.util.Arrays;

public class Product {

    static int findProductOf(int[] numbers) {

        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        return numbers[numbers.length-1] * findProductOf(Arrays.copyOf(numbers, numbers.length-1));
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,4,5};
        System.out.println(findProductOf(numbers));
    }
}
