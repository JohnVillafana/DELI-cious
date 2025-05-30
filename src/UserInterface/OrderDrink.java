package UserInterface;

import Drinks.*;

public class OrderDrink {

    public Drink orderDrink() {
        System.out.println("\n" + ColorText.BLUE + "=== ORDER DRINK ===" + ColorText.RESET);

        DrinkSize size = selectSize();
        DrinkName flavor = selectFlavor();

        Drink drink = new Drink(flavor, size);
        System.out.println("\n" + ColorText.GREEN + "Drink added to order!" + ColorText.RESET);

        return drink;
    }

    private DrinkSize selectSize() {
        System.out.println("\nSelect drink size:");
        DrinkSize[] sizes = DrinkSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i].getDisplayName() +
                    " - $" + String.format("%.2f", sizes[i].getPrice()));
        }

        int choice = Main.getIntInput("Enter your choice: ");
        while (choice < 1 || choice > sizes.length) {
            System.out.println("Invalid choice. Please try again.");
            choice = Main.getIntInput("Enter your choice: ");
        }

        return sizes[choice - 1];
    }

    private DrinkName selectFlavor() {
        System.out.println("\nSelect drink flavor:");
        DrinkName[] flavors = DrinkName.values();
        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i].getDisplayName());
        }

        int choice = Main.getIntInput("Enter your choice: ");
        while (choice < 1 || choice > flavors.length) {
            System.out.println("Invalid choice. Please try again.");
            choice = Main.getIntInput("Enter your choice: ");
        }

        return flavors[choice - 1];
    }
}

