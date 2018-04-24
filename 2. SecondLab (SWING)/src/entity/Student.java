package entity;

import exception.InvalidContentParamException;

import java.util.ArrayList;
import java.util.List;
/**
 * <h1>Student</h1>
 *
 * Student class represents the logic of the program,
 * thus it serves as a controller, which connects all
 * other classes's functionality.
 */
public class Student {
    private String name;
    private List<Thing> thing;

    public Student (String name ,Cup cup, Coffee coffee, Sugar sugar, Kettle kettle)
            throws NullPointerException {
        if (cup == null) {
            throw new NullPointerException("The value of cup param can not be null!");
        }
        if (coffee == null) {
            throw new NullPointerException("The value of coffee param can not be null!");
        }
        if (sugar == null) {
            throw new NullPointerException("The value of sugar param can not be null!");
        }
        if (kettle == null) {
            throw new NullPointerException("The value of kettle param can not be null!");
        }
        if (name.isEmpty() || name == null) {
            throw new NullPointerException("The value of name param can not be null or empty!");
        }

        this.name = name;

        this.thing = new ArrayList<Thing>();
        thing.add(cup);
        thing.add(coffee);
        thing.add(sugar);
        thing.add(kettle);
    }

    public String getName() {
        return this.name;
    }
    /**
     * This method is used to configure the pane
     * for the program to be able to interact with user
     * @param cup This is the Cup object, which can be modified
     *             in this method (depending on the values of other params).
     * @param sugar This is the Sugar object, which help to modify Cup object
     * @param coffee This is the Coffee object, which help to modify Cup object
     * @param kettle This is the Kettle object, which help to modify Cup object
     * @param addCoffee allows/restricts cutting(reducing length) the Blank object
     * @param addSugar allows/restricts smoothing(reducing width) the Blank object
     * @param addWater allows/restricts screwing the Blank object
     * @return void.
     * @throws InvalidContentParamException
     * @see Cup
     * @see Sugar
     * @see Coffee
     * @see Kettle
     */
    public void makeCoffee(Cup cup, Sugar sugar, Coffee coffee, Kettle kettle,
                           boolean addCoffee, boolean addSugar, boolean addWater)
            throws InvalidContentParamException {
        if(addCoffee) {
            ((Coffee) thing.get(1)).pour(cup);
        }
        if(addSugar) {
            ((Sugar) thing.get(2)).pour(cup);
        }
        if(addWater) {
            try {
                ((Kettle) thing.get(3)).fillWithWater(cup);
            } catch (InvalidContentParamException exception) {
                if (cup.content.getCoffeeSponsNumber() <= 5 && addCoffee) {
                    ((Coffee) thing.get(1)).pour(cup);
                }
                if (cup.content.getSugarCubesNumber() <= 5 && addSugar) {
                    ((Sugar) thing.get(2)).pour(cup);
                }
                throw exception;
            }
        }
    }
}