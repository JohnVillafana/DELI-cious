package Drinks;

public class Drink {
    private DrinkName name;
    private DrinkSize size;

    public Drink(DrinkName name, DrinkSize size) {
        this.name = name;
        this.size = size;
    }

    public DrinkName getName() {
        return name;
    }

    public DrinkSize getSize() {
        return size;
    }

    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String toString() {
        return size.getDisplayName() + " " + name.getDisplayName() +
                " - $" + String.format("%.2f", getPrice());
    }
}

