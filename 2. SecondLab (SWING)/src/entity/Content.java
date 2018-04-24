package entity;

import exception.InvalidContentParamException;
/**
 * <h1>Content</h1>
 *
 * Content class is used to store information
 * about cup(Cup object).
 * It is the attribute of the Cup class.
 */
public class Content {
    private int coffeeSponsNumber;
    private int sugarCubesNumber;
    private int waterCapacity;

    public Content() {
        this.coffeeSponsNumber = 0;
        this.sugarCubesNumber = 0;
        this.waterCapacity = 0;
    }

    public Content(int coffeeSponsNumber, int sugarCubesNumber, int waterCapacity)
            throws InvalidContentParamException {
        if (coffeeSponsNumber > 5) {
            throw new InvalidContentParamException("Too much coffee my friend!");
        }
        if (sugarCubesNumber > 5) {
            throw new InvalidContentParamException("Too much sugar my friend!");
        }
        if (waterCapacity > 500) {
            throw new InvalidContentParamException("Cup capacity is limited my friend!");
        }

        this.coffeeSponsNumber = coffeeSponsNumber;
        this.sugarCubesNumber = sugarCubesNumber;
        this.waterCapacity = waterCapacity;
    }

    public int getCoffeeSponsNumber() {
        return this.coffeeSponsNumber;
    }

    public int getSugarCubesNumber() {
        return this.sugarCubesNumber;
    }

    public int getWaterCapacity() {
        return this.waterCapacity;
    }

    public void changeCoffeeSponsNumber(int coffeeSponsNumber)
            throws InvalidContentParamException {
        if (coffeeSponsNumber > 5) {
            throw new InvalidContentParamException("Too much coffee my friend!");
        }
        this.coffeeSponsNumber = coffeeSponsNumber;
    }

    public void changeSugarCubesNumber(int sugarCubesNumber)
            throws InvalidContentParamException {
        if (sugarCubesNumber > 5) {
            throw new InvalidContentParamException("Too much sugar my friend!");
        }
        this.sugarCubesNumber = sugarCubesNumber;
    }

    public void changeWaterCapacity (int waterCapacity)
            throws InvalidContentParamException {
        if (waterCapacity > 500) {
            throw new InvalidContentParamException("Cup capacity is limited my friend!");
        }
        this.waterCapacity = waterCapacity;
    }
}