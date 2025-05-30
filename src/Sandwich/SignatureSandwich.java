package Sandwich;

public class SignatureSandwich extends CustomizedSandwich {
    private String name;

    public SignatureSandwich(String name, BreadType bread, SandwichSize size) {
        super(bread, size);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SignatureSandwich createBLT(SandwichSize size) {
        SignatureSandwich blt = new SignatureSandwich("BLT", BreadType.WHITE, size);
        blt.addTopping(new Topping(ToppingName.BACON, false));
        blt.addTopping(new Topping(ToppingName.CHEDDAR, false));
        blt.addTopping(new Topping(ToppingName.LETTUCE, false));
        blt.addTopping(new Topping(ToppingName.TOMATOES, false));
        blt.addTopping(new Topping(ToppingName.RANCH, false));
        blt.setToasted(true);
        return blt;
    }

    public static SignatureSandwich createPhillyCheesesteak(SandwichSize size) {
        SignatureSandwich philly = new SignatureSandwich("Philly Cheesesteak", BreadType.WHITE, size);
        philly.addTopping(new Topping(ToppingName.STEAK, false));
        philly.addTopping(new Topping(ToppingName.AMERICAN, false));
        philly.addTopping(new Topping(ToppingName.PEPPERS, false));
        philly.addTopping(new Topping(ToppingName.MAYO, false));
        philly.setToasted(true);
        return philly;
    }

    @Override
    public String toString() {
        return name + " - " + super.toString();
    }
}

