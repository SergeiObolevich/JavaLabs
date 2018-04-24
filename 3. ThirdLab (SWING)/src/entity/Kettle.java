package entity;

import exception.InvalidContentParamException;
/**
 * <h1>Kettle</h1>
 *
 * Kettle is used to change cup's(Cup object)
 * pour method add water to cup.
 */
public class Kettle extends Thing {
    private static final int WATER_CAPACITY = 400;
    private static final int WATER_TEMPERATURE = 100;

    private int capacity;
    private int temperature;

    public Kettle(int temperature, int capacity, int weight)
            throws IllegalArgumentException{
        super(weight);
        if (temperature <= 0) {
            throw new IllegalArgumentException("The value of temperature can not be zero or negative!");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("The value of capacity can not be zero or negative!");
        }
        this.temperature = temperature;
        this.capacity = capacity;
    }

    public void fillWithWater(Cup cup)
            throws InvalidContentParamException {
        this.boil();
        this.pour(cup);
    }

    private void boil(){
        this.temperature = WATER_TEMPERATURE;
    }

    private void pour(Cup cup)
            throws InvalidContentParamException {
        cup.content.changeLiquidCapacity(cup.content.getWaterCapacity() + WATER_CAPACITY,
                cup.content.getMilkCapacity());
        cup.fill(cup.content);
    }
}