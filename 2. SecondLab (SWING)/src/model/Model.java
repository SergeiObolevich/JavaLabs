package model;

import entity.*;
/**<h1>Model</h1>
 *
 * The Model class represents the program data
 * structure, which is being manipulated by the
 * user with the help of GUI class.
 * <p>
 * The data fields are not sealed in order to ease
 * the manipulation with them, because they either will be changing
 * throughout the program execution, or their methods are
 * used very often during the session.
 * </p>
 */
public class Model {
    public Student student;
    public Cup cup;
    public Sugar sugar;
    public Coffee coffee;
    public Kettle kettle;

    public boolean addCoffee;
    public boolean addSugar;
    public boolean addWater;

    public Model() {
        cup = new Cup(500, new entity.Content(), 200);
        sugar = new Sugar(5);
        coffee = new Coffee("Крепкий", 5);
        kettle = new Kettle(10, 2000, 1000);
        student = new Student("Sergei Obolevich", cup, coffee, sugar, kettle);

        this.addCoffee = true;
        this.addSugar = true;
        this.addWater = true;
    }

    public Model(String name, Cup cup, Sugar sugar, Coffee coffee, Kettle kettle)
            throws NullPointerException{
        this.cup = cup;
        this.sugar = sugar;
        this.coffee = coffee;
        this.kettle = kettle;
        student = new Student("Sergei Obolevich", cup, coffee, sugar, kettle);

        this.addCoffee = true;
        this.addSugar = true;
        this.addWater = true;
    }

    public void initializeCoffeeCup() {
        this.cup = new Cup(500, new entity.Content(), 200);
    }
}