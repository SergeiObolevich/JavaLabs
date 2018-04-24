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

    public Student (String name , Cup cup, Milk.Coffee coffee, Sugar sugar, Kettle kettle, Tea tea, Milk milk)
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
        if (tea == null) {
            throw new NullPointerException("The value of tea param can not be null!");
        }
        if (milk == null) {
            throw new NullPointerException("The value of milk param can not be null!");
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
        thing.add(tea);
        thing.add(milk);
    }

    public String getName() {
        return this.name;
    }
    /**
     * This method is used to configure the pane
     * for the program to be able to interact with user
     * @param cup This is the Cup object, which can be modified
     *             in this method (depending on the values of other params).
     * @param addCoffee allows/restricts change the coffee spons number in  the Cup object
     * @param addSugar allows/restricts change the sugar cubes number in the Cup object
     * @param addTea allows/restricts change the tea spons number in  the Cup object
     * @return void.
     * @throws InvalidContentParamException
     * @see Cup
     */
    public void makeCoffee(Cup cup, boolean addCoffee, boolean addSugar, boolean addTea)
            throws InvalidContentParamException {
        if(addTea) {
            throw new IllegalArgumentException("You can't add tea to coffee my friend!");
        }
        if (!addCoffee && !addSugar) {
            throw new IllegalArgumentException("Please choose something my friend!");
        }
        if(addCoffee) {
            ((Milk.Coffee) thing.get(1)).pour(cup);
        }
        else if (!addCoffee && cup.content.getCoffeeSponsNumber() < 1) {
            throw new IllegalArgumentException("Coffee without coffee it not very good my friend!");
        }
        if(addSugar) {
            ((Sugar) thing.get(2)).pour(cup);
        }
        if (cup.content.getWaterCapacity() != 400) {
            ((Kettle) thing.get(3)).fillWithWater(cup);
        }
    }
    /**
     * This method is used to configure the pane
     * for the program to be able to interact with user
     * @param cup This is the Cup object, which can be modified
     *             in this method (depending on the values of other params).
     * @param addCoffee allows/restricts change the coffee spons number in  the Cup object
     * @param addSugar allows/restricts change the sugar cubes number in the Cup object
     * @param addTea allows/restricts change the tea spons number in  the Cup object
     * @return void.
     * @throws InvalidContentParamException
     * @see Cup
     */
    public void makeTea(Cup cup, boolean addTea, boolean addSugar, boolean addCoffee)
            throws InvalidContentParamException {
        if(addCoffee) {
            throw new IllegalArgumentException("You can't add coffee to tea my friend!");
        }
        if(addTea) {
            ((Tea) thing.get(4)).pour(cup);
        }
        if (!addTea && !addSugar) {
            throw new IllegalArgumentException("Please choose something my friend!");
        }
        else if (!addTea && cup.content.getTeaSponsNumber() < 1) {
            throw new IllegalArgumentException("Tea without tea it not very good my friend!");
        }
        if(addSugar) {
            ((Sugar) thing.get(2)).pour(cup);
        }
        if (cup.content.getWaterCapacity() != 400) {
            ((Kettle) thing.get(3)).fillWithWater(cup);
        }
    }
    /**
     * This method is used to configure the pane
     * for the program to be able to interact with user
     * @param cup This is the Cup object, which can be modified
     *             in this method (depending on the values of other params).
     * @param addCoffee allows/restricts change the coffee spons number in  the Cup object
     * @param addSugar allows/restricts change the sugar cubes number in the Cup object
     * @param addTea allows/restricts change the tea spons number in  the Cup object
     * @return void.
     * @throws InvalidContentParamException
     * @see Cup
     */
    public void makeCoffeeWithMilk(Cup cup, boolean addCoffee, boolean addSugar, boolean addTea)
            throws InvalidContentParamException {
        if (addTea) {
            throw new IllegalArgumentException("You can't add tea to coffee my friend!");
        }
        if (!addCoffee && !addSugar) {
            throw new IllegalArgumentException("Please choose something my friend!");
        }
        if (addCoffee) {
            ((Milk.Coffee) thing.get(1)).pour(cup);
        }
        else if (!addCoffee && cup.content.getCoffeeSponsNumber() < 1) {
            throw new IllegalArgumentException("Coffee without coffee it not very good my friend!");
        }
        if(addSugar) {
            ((Sugar) thing.get(2)).pour(cup);
        }
        if (cup.content.getWaterCapacity() != 400 && cup.content.getMilkCapacity() != 200) {
            ((Kettle) thing.get(3)).fillWithWater(cup);
            ((Milk) thing.get(5)).pour(cup);
        }
    }
}