package seventeen.sealed;

public abstract sealed class Beverage implements Consumable permits Coffee, Tea{

    public static final double HEAT_VALUE = 200.5;

    private double temperature;

    public double getTemperature() {
        return this.temperature;
    }

    public void heatUp() {
        temperature = HEAT_VALUE;
    }

}
