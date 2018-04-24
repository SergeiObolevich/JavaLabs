package entity;

import exception.InvalidContentParamException;
/**
 * <h1>Sugar</h1>
 *
 * Sugar is used to change cup's(Cup object)
 * pour method add sugar to cup.
 */
public class Sugar extends Thing {
    public static final int SUGAR_CAPACITY = 1;

    public Sugar(int weight)
            throws IllegalArgumentException{
        super(weight);
    }

    public void pour(Cup cup)
            throws InvalidContentParamException {
        cup.content.changeSugarCubesNumber(cup.content.getSugarCubesNumber() + SUGAR_CAPACITY);
        cup.fill(cup.content);
    }
}