package Sandwich;

import java.util.ArrayList;
import java.util.List;

public class CustomizedSandwich {
    private BreadType breadType;
    private SandwichSize size;
    private List<Topping> toppings;
    private boolean isToasted;

    public CustomizedSandwich(BreadType breadType, SandwichSize size) {
        this.breadType = breadType;
        this.size = size;
        this.toppings = new ArrayList<>();
        this.isToasted = false;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    public double getPrice() {
        double total = size.getBasePrice();

        for (Topping topping : toppings) {
            total += topping.getPrice(size);
        }

        return total;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public SandwichSize getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size.getDisplayName()).append(" ");
        sb.append(breadType.getDisplayName()).append(" Sandwich");
        if (isToasted) {
            sb.append(" (Toasted)");
        }
        sb.append(" - $").append(String.format("%.2f", getPrice()));

        if (!toppings.isEmpty()) {
            sb.append("\n     Toppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                sb.append(toppings.get(i).toString());
                if (i < toppings.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        return sb.toString();
    }
}

