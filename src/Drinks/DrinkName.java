package Drinks;

public enum DrinkName {
    COKE("Coke"),
    PEPSI("Pepsi"),
    SPRITE("Sprite"),
    DR_PEPPER("Dr Pepper"),
    ORANGE_SODA("Orange Soda"),
    ROOT_BEER("Root Beer"),
    LEMONADE("Lemonade"),
    ICED_TEA("Iced Tea"),
    WATER("Water");

    private final String displayName;

    DrinkName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

