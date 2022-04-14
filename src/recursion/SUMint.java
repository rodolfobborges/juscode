package recursion;

public class SUMint {

    static int sumNumbersUntil(int number) {

        if (number == 0 || number == 1) {
            return number;
        }
        return number + sumNumbersUntil(number-1);
    }

    public static void main(String[] args) {

        System.out.println(SUMint.sumNumbersUntil(5));
    }
}
