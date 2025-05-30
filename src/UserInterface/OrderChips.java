package UserInterface;

import Chips.*;

public class OrderChips {

    public Chip orderChips() {
        System.out.println("\n" + ColorText.YELLOW + "=== ORDER CHIPS ===" + ColorText.RESET);

        System.out.println("\nSelect chip type:");
        ChipName[] chips = ChipName.values();
        for (int i = 0; i < chips.length; i++) {
            System.out.println((i + 1) + ") " + chips[i].getDisplayName() + " - $1.50");
        }

        int choice = Main.getIntInput("Enter your choice: ");
        while (choice < 1 || choice > chips.length) {
            System.out.println("Invalid choice. Please try again.");
            choice = Main.getIntInput("Enter your choice: ");
        }

        Chip chip = new Chip(chips[choice - 1]);
        System.out.println("\n" + ColorText.GREEN + "Chips added to order!" + ColorText.RESET);

        return chip;
    }
}

