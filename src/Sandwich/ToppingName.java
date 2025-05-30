package Sandwich;

public enum ToppingName {
    // Meats
    STEAK(ToppingType.MEAT, "Steak", 1.00, 2.00, 3.00),
    HAM(ToppingType.MEAT, "Ham", 1.00, 2.00, 3.00),
    SALAMI(ToppingType.MEAT, "Salami", 1.00, 2.00, 3.00),
    ROAST_BEEF(ToppingType.MEAT, "Roast Beef", 1.00, 2.00, 3.00),
    CHICKEN(ToppingType.MEAT, "Chicken", 1.00, 2.00, 3.00),
    BACON(ToppingType.MEAT, "Bacon", 1.00, 2.00, 3.00),

    // Cheeses
    AMERICAN(ToppingType.CHEESE, "American", 0.75, 1.50, 2.25),
    PROVOLONE(ToppingType.CHEESE, "Provolone", 0.75, 1.50, 2.25),
    CHEDDAR(ToppingType.CHEESE, "Cheddar", 0.75, 1.50, 2.25),
    SWISS(ToppingType.CHEESE, "Swiss", 0.75, 1.50, 2.25),

    // Regular Toppings
    LETTUCE(ToppingType.REGULAR, "Lettuce", 0, 0, 0),
    PEPPERS(ToppingType.REGULAR, "Peppers", 0, 0, 0),
    ONIONS(ToppingType.REGULAR, "Onions", 0, 0, 0),
    TOMATOES(ToppingType.REGULAR, "Tomatoes", 0, 0, 0),
    JALAPENOS(ToppingType.REGULAR, "Jalapenos", 0, 0, 0),
    CUCUMBERS(ToppingType.REGULAR, "Cucumbers", 0, 0, 0),
    PICKLES(ToppingType.REGULAR, "Pickles", 0, 0, 0),
    GUACAMOLE(ToppingType.REGULAR, "Guacamole", 0, 0, 0),
    MUSHROOMS(ToppingType.REGULAR, "Mushrooms", 0, 0, 0),

    // Sauces
    MAYO(ToppingType.SAUCE, "Mayo", 0, 0, 0),
    MUSTARD(ToppingType.SAUCE, "Mustard", 0, 0, 0),
    KETCHUP(ToppingType.SAUCE, "Ketchup", 0, 0, 0),
    RANCH(ToppingType.SAUCE, "Ranch", 0, 0, 0),
    THOUSAND_ISLANDS(ToppingType.SAUCE, "Thousand Islands", 0, 0, 0),
    VINAIGRETTE(ToppingType.SAUCE, "Vinaigrette", 0, 0, 0),

    // Sides
    AU_JUS(ToppingType.SIDE, "Au Jus", 0, 0, 0),
    SAUCE_SIDE(ToppingType.SIDE, "Sauce", 0, 0, 0);

    private final ToppingType type;
    private final String displayName;
    private final double fourInchPrice;
    private final double eightInchPrice;
    private final double twelveInchPrice;

    ToppingName(ToppingType type, String displayName, double fourInchPrice,
                double eightInchPrice, double twelveInchPrice) {
        this.type = type;
        this.displayName = displayName;
        this.fourInchPrice = fourInchPrice;
        this.eightInchPrice = eightInchPrice;
        this.twelveInchPrice = twelveInchPrice;
    }

    public ToppingType getType() {
        return type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice(SandwichSize size) {
        switch (size) {
            case FOUR_INCH:
                return fourInchPrice;
            case EIGHT_INCH:
                return eightInchPrice;
            case TWELVE_INCH:
                return twelveInchPrice;
            default:
                return 0;
        }
    }
}

