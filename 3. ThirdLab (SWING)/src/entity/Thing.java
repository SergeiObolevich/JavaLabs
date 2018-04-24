package entity;
/**
 * <h1>Thing</h1>
 *
 * Thing class serves as a
 * container class for all other
 * things, which are defined
 * in this program.
 */
public abstract class Thing {
    private int weight;

    public Thing (int weight)
            throws IllegalArgumentException{
        if (weight <= 0) {
            throw new IllegalArgumentException("The value of weight can not be zero or negative!");
        }
        this.weight = weight;
    }
}