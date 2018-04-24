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
    private int milkCapacity;
    private int teaSponsNumber;

    public Content() {
        this.coffeeSponsNumber = 0;
        this.sugarCubesNumber = 0;
        this.waterCapacity = 0;
        this.milkCapacity = 0;
        this.teaSponsNumber = 0;
    }

    public Content(int coffeeSponsNumber, int sugarCubesNumber, int waterCapacity, int milkCapacity, int teaSponsNumber)
            throws InvalidContentParamException {
        if (coffeeSponsNumber > 4) {
            throw new InvalidContentParamException("Too much coffee my friend!");
        }
        if (sugarCubesNumber > 4) {
            throw new InvalidContentParamException("Too much sugar my friend!");
        }
        if (waterCapacity + milkCapacity > 600) {
            throw new InvalidContentParamException("Cup capacity is limited my friend!");
        }
        if (teaSponsNumber > 4) {
            throw new InvalidContentParamException("Too much tea my friend!");
        }

        this.coffeeSponsNumber = coffeeSponsNumber;
        this.sugarCubesNumber = sugarCubesNumber;
        this.waterCapacity = waterCapacity;
        this.milkCapacity = milkCapacity;
        this.teaSponsNumber = teaSponsNumber;
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

    public int getMilkCapacity() {
        return this.milkCapacity;
    }

    public int getTeaSponsNumber() {
        return  this.teaSponsNumber;
    }

    public void changeCoffeeSponsNumber(int coffeeSponsNumber)
            throws InvalidContentParamException {
        if (coffeeSponsNumber > 4) {
            throw new InvalidContentParamException("Too much coffee my friend!");
        }
        this.coffeeSponsNumber = coffeeSponsNumber;
    }

    public void changeSugarCubesNumber(int sugarCubesNumber)
            throws InvalidContentParamException {
        if (sugarCubesNumber > 4) {
            throw new InvalidContentParamException("Too much sugar my friend!");
        }
        this.sugarCubesNumber = sugarCubesNumber;
    }

    public void changeTeaSponsNumber(int teaSponsNumber)
            throws InvalidContentParamException {
        if (teaSponsNumber > 4) {
            throw new InvalidContentParamException("Too much tea my friend!");
        }
        this.teaSponsNumber = teaSponsNumber;
    }

    public void changeLiquidCapacity (int waterCapacity, int milkCapacity)
            throws InvalidContentParamException {
        if (waterCapacity + milkCapacity > 600) {
            throw new InvalidContentParamException("Cup capacity is limited my friend!");
        }
        this.waterCapacity = waterCapacity;
        this.milkCapacity = milkCapacity;
    }
}