package entity;

import exception.InvalidContentParamException;
/**
 * <h1>LooseThing</h1>
 *
 * Intermediate class
 * uniting loose objects
 */
public class LooseThing extends Thing {
    public LooseThing (int weight)
            throws IllegalArgumentException{
        super(weight);
    }

    public void pour(Cup cup)
            throws InvalidContentParamException {}
}