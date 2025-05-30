package Sandwich;

public class Topping {
    private ToppingName name;
    private boolean isExtra;

    public Topping(ToppingName name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public ToppingName getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public double getPrice(SandwichSize size) {
        double basePrice = name.getPrice(size);
        if (isExtra) {
            if (name.getType() == ToppingType.MEAT) {
                return basePrice * 0.5;
            } else if (name.getType() == ToppingType.CHEESE) {
                return basePrice * 0.3;
            }
        }
        return basePrice;
    }

    @Override
    public String toString() {
        return (isExtra ? "Extra " : "") + name.getDisplayName();
    }
}

