package Chips;

public enum ChipName {
    PLAIN("Plain"),
    BBQ("BBQ"),
    SOUR_CREAM_ONION("Sour Cream & Onion"),
    SALT_VINEGAR("Salt & Vinegar"),
    JALAPENO("Jalapeno"),
    CHEDDAR("Cheddar"),
    DORITOS("Doritos"),
    FRITOS("Fritos"),
    PRETZELS("Pretzels");

    private final String displayName;

    ChipName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

