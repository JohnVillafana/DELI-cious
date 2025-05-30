package UserInterface;

import Sandwich.*;
import java.util.Scanner;

public class BuildSandwich {

    public CustomizedSandwich buildSandwich() {
        System.out.println("\n" + ColorText.YELLOW + "=== BUILD YOUR SANDWICH ===" + ColorText.RESET);

        BreadType bread = selectBread();
        SandwichSize size = selectSize();

        CustomizedSandwich sandwich = new CustomizedSandwich(bread, size);

        addToppings(sandwich);

        String toasted = Main.getStringInput("\nWould you like your sandwich toasted? (yes/no): ");
        sandwich.setToasted(toasted.equalsIgnoreCase("yes"));

        System.out.println("\n" + ColorText.GREEN + "Sandwich added to order!" + ColorText.RESET);
        return sandwich;
    }

    private BreadType selectBread() {
        System.out.println("\nSelect bread type:");
        BreadType[] breads = BreadType.values();
        for (int i = 0; i < breads.length; i++) {
            System.out.println((i + 1) + ") " + breads[i].getDisplayName());
        }

        int choice = Main.getIntInput("Enter your choice: ");
        while (choice < 1 || choice > breads.length) {
            System.out.println("Invalid choice. Please try again.");
            choice = Main.getIntInput("Enter your choice: ");
        }

        return breads[choice - 1];
    }

    private SandwichSize selectSize() {
        System.out.println("\nSelect sandwich size:");
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i].getDisplayName() +
                    " - $" + String.format("%.2f", sizes[i].getBasePrice()));
        }

        int choice = Main.getIntInput("Enter your choice: ");
        while (choice < 1 || choice > sizes.length) {
            System.out.println("Invalid choice. Please try again.");
            choice = Main.getIntInput("Enter your choice: ");
        }

        return sizes[choice - 1];
    }

    private void addToppings(CustomizedSandwich sandwich) {
        System.out.println("\n" + ColorText.CYAN + "=== SELECT MEATS ===" + ColorText.RESET);
        System.out.println("(Press 0 when done)");
        addToppingsByType(sandwich, ToppingType.MEAT);

        System.out.println("\n" + ColorText.CYAN + "=== SELECT CHEESES ===" + ColorText.RESET);
        System.out.println("(Press 0 when done)");
        addToppingsByType(sandwich, ToppingType.CHEESE);

        System.out.println("\n" + ColorText.CYAN + "=== SELECT OTHER TOPPINGS ===" + ColorText.RESET);
        System.out.println("(Press 0 when done)");
        addToppingsByType(sandwich, ToppingType.REGULAR);

        System.out.println("\n" + ColorText.CYAN + "=== SELECT SAUCES ===" + ColorText.RESET);
        System.out.println("(Press 0 when done)");
        addToppingsByType(sandwich, ToppingType.SAUCE);
    }

    private void addToppingsByType(CustomizedSandwich sandwich, ToppingType type) {
        ToppingName[] allToppings = ToppingName.values();
        java.util.List<ToppingName> typeToppings = new java.util.ArrayList<>();

        for (ToppingName topping : allToppings) {
            if (topping.getType() == type) {
                typeToppings.add(topping);
            }
        }

        for (int i = 0; i < typeToppings.size(); i++) {
            ToppingName topping = typeToppings.get(i);
            String priceStr = "";
            if (type == ToppingType.MEAT || type == ToppingType.CHEESE) {
                priceStr = " - $" + String.format("%.2f", topping.getPrice(sandwich.getSize()));
            }
            System.out.println((i + 1) + ") " + topping.getDisplayName() + priceStr);
        }

        while (true) {
            int choice = Main.getIntInput("Select topping (0 to finish): ");
            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > typeToppings.size()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            ToppingName selectedTopping = typeToppings.get(choice - 1);

            boolean isExtra = false;
            if (type == ToppingType.MEAT || type == ToppingType.CHEESE) {
                String extra = Main.getStringInput("Would you like extra? (yes/no): ");
                isExtra = extra.equalsIgnoreCase("yes");
            }

            sandwich.addTopping(new Topping(selectedTopping, isExtra));
            System.out.println(ColorText.GREEN + "Added: " +
                    (isExtra ? "Extra " : "") + selectedTopping.getDisplayName() + ColorText.RESET);
        }
    }
}

