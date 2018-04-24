package entity;

import exception.InvalidContentParamException;
/**
 * <h1>Tea</h1>
 *
 * Tea is used to change cup's(Cup object)
 * pour method add Tea to cup.
 */
public class Tea extends LooseThing {
    private static final int TEA_CAPACITY = 1;
    private String variety;

    public Tea(String variety, int weight)
            throws IllegalArgumentException{
        super(weight);
        if(variety.isEmpty() || variety == null) {
            throw new IllegalArgumentException("The value of taste param can not be null or empty!");
        }
        this.variety = variety;
    }

    public void pour(Cup cup)
            throws InvalidContentParamException {
        cup.content.changeTeaSponsNumber(cup.content.getTeaSponsNumber() + TEA_CAPACITY);
        cup.fill(cup.content);
    }
}