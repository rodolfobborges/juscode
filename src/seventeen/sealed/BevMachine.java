package seventeen.sealed;

import java.util.Arrays;

public class BevMachine {

    public static void main(String[] args) {
        Beverage[] availableBevs = {new Tea(), new Coffee(true)};
        Arrays.stream(availableBevs).forEach(Consumable::consume);
    }
}
