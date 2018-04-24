package entity;

import exception.InvalidContentParamException;
/**
 * <h1>Milk</h1>
 *
 * Milk is used to change cup's(Cup object)
 * pour method add milk to cup.
 */
public class Milk extends Thing {
    private static final int MILK_CAPACITY = 200;
    public Milk (int weight)
            throws IllegalArgumentException{
        super(weight);
    }

    public void pour(Cup cup)
            throws InvalidContentParamException {
        cup.content.changeLiquidCapacity(cup.content.getWaterCapacity(),
                cup.content.getMilkCapacity() + MILK_CAPACITY);
        cup.fill(cup.content);
    }

    public static class Coffee extends LooseThing {
        private static final int COFFEE_CAPACITY = 1;
        private String taste;

        public Coffee(String taste, int weight)
                throws IllegalArgumentException{
            super(weight);
            if(taste.isEmpty() || taste == null) {
                throw new IllegalArgumentException("The value of taste param can not be null or empty!");
            }
            this.taste = taste;
        }

        public void pour(Cup cup)
                throws InvalidContentParamException {
            cup.content.changeCoffeeSponsNumber(cup.content.getCoffeeSponsNumber() + COFFEE_CAPACITY);
            cup.fill(cup.content);
        }
    }
}