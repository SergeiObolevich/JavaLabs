package entity;

import exception.InvalidContentParamException;
/**
 * <h1>Coffee</h1>
 *
 * Coffee is used to change cup's(Cup object)
 * pour method add coffee to cup.
 */
public class Coffee extends Thing {
    public static final int COFFEE_CAPACITY = 1;
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