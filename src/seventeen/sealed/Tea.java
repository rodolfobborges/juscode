package seventeen.sealed;

public final class Tea extends Beverage {

    private void stir() {
        System.out.println("Stiring tea...");
    }

    @Override
    public void consume() {
        stir();
    }
}
