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
    private Sugar sugar;
    private Milk.Coffee coffee;
    private Kettle kettle;
    private Milk milk;
    private Tea tea;

    public boolean addCoffee;
    public boolean addSugar;
    public boolean addTea;

    public Model() {
        cup = new Cup(700, new entity.Content(), 200);
        sugar = new Sugar(5);
        coffee = new Milk.Coffee("Крепкий", 5);
        kettle = new Kettle(10, 2000, 1000);
        milk = new Milk(900);
        tea = new Tea("Зелёный", 5);
        student = new Student("Sergei Obolevich", cup, coffee, sugar, kettle, tea, milk);

        this.addCoffee = false;
        this.addSugar = false;
        this.addTea = false;
    }

    public Model(String name, Cup cup, Sugar sugar, Milk.Coffee coffee, Kettle kettle, Milk milk, Tea tea)
            throws NullPointerException{
        this.cup = cup;
        this.sugar = sugar;
        this.coffee = coffee;
        this.kettle = kettle;
        this.milk = milk;
        this.tea = tea;
        student = new Student("Sergei Obolevich", cup, coffee, sugar, kettle, tea, milk);

        this.addCoffee = false;
        this.addSugar = false;
        this.addTea = false;
    }

    public void initializeCup() {
        this.cup = new Cup(700, new entity.Content(), 200);
    }
}