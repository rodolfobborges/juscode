package seventeen.sealed;

public sealed interface Consumable permits Beverage {

    void consume();
}
