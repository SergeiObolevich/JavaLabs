package entity;

import exception.InvalidContentParamException;
/**
 * <h1>Water</h1>
 *
 * Water is used to change cup's(Cup object)
 * pour method add water to cup.
 */
public class Kettle extends Thing {
    public static final int WATER_CAPACITY = 100;
    public static final int WATER_TEMPERATURE = 100;

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

    public void boil(){
        this.temperature = WATER_TEMPERATURE;
    }

    public void pour(Cup cup)
            throws InvalidContentParamException {
        cup.content.changeWaterCapacity(cup.content.getWaterCapacity() + WATER_CAPACITY);
        cup.fill(cup.content);
    }
}