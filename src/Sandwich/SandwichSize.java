package Sandwich;

public enum SandwichSize {
    FOUR_INCH(4, "4\"", 5.50),
    EIGHT_INCH(8, "8\"", 7.00),
    TWELVE_INCH(12, "12\"", 8.50);

    private final int inches;
    private final String displayName;
    private final double basePrice;

    SandwichSize(int inches, String displayName, double basePrice) {
        this.inches = inches;
        this.displayName = displayName;
        this.basePrice = basePrice;
    }

    public int getInches() {
        return inches;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getBasePrice() {
        return basePrice;
    }
}

