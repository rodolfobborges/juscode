package seventeen.sealed;

public final class Coffee extends Beverage {

    private final boolean wannaCream;

    public Coffee(boolean wannaCream) {
        this.wannaCream = wannaCream;
    }

    public void addCream() {
        System.out.println("Adding cream to the coffee...");
    }

    @Override
    public void consume() {
        if (wannaCream) {
            addCream();
        }
    }
}
