package Sandwich;

public enum ToppingType {
    MEAT("Meat"),
    CHEESE("Cheese"),
    REGULAR("Regular Topping"),
    SAUCE("Sauce"),
    SIDE("Side");

    private final String displayName;

    ToppingType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

