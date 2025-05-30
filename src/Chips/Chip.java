package Chips;

public class Chip {
    private ChipName name;
    private static final double PRICE = 1.50;

    public Chip(ChipName name) {
        this.name = name;
    }

    public ChipName getName() {
        return name;
    }

    public double getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return name.getDisplayName() + " - $" + String.format("%.2f", getPrice());
    }
}

