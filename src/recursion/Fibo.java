package recursion;

public class Fibo {

    static int calcFibonacciFor(int number) {

        if (number == 1 || number == 0) {
            return number;
        }
        return calcFibonacciFor(number-1) + calcFibonacciFor(number-2);
    }

    public static void main(String[] args) {
        System.out.println(calcFibonacciFor(3));
    }
}
