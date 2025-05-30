package UserInterface;

import UserInterface.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderManager {
    private Order currentOrder;
    private BuildSandwich sandwichBuilder;
    private OrderDrink drinkOrder;
    private OrderChips chipsOrder;

    public OrderManager() {
        this.sandwichBuilder = new BuildSandwich();
        this.drinkOrder = new OrderDrink();
        this.chipsOrder = new OrderChips();
    }

    public void startNewOrder() {
        currentOrder = new Order();

        while (true) {
            displayOrderScreen();
            int choice = Main.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    currentOrder.addSandwich(sandwichBuilder.buildSandwich());
                    break;
                case 2:
                    currentOrder.addDrink(drinkOrder.orderDrink());
                    break;
                case 3:
                    currentOrder.addChips(chipsOrder.orderChips());
                    break;
                case 4:
                    checkout();
                    return;
                case 0:
                    System.out.println("\nOrder cancelled. Returning to main menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayOrderScreen() {
        System.out.println("\n" + ColorText.BLUE + "=================================");
        System.out.println("       Current Order");
        System.out.println("=================================" + ColorText.RESET);

        if (!currentOrder.getSandwiches().isEmpty()) {
            System.out.println(ColorText.YELLOW + "Sandwiches: " + currentOrder.getSandwiches().size() + ColorText.RESET);
        }
        if (!currentOrder.getDrinks().isEmpty()) {
            System.out.println(ColorText.YELLOW + "Drinks: " + currentOrder.getDrinks().size() + ColorText.RESET);
        }
        if (!currentOrder.getChips().isEmpty()) {
            System.out.println(ColorText.YELLOW + "Chips: " + currentOrder.getChips().size() + ColorText.RESET);
        }

        System.out.println("\n1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.println("=================================");
    }

    private void checkout() {
        if (currentOrder.getSandwiches().isEmpty() &&
                currentOrder.getDrinks().isEmpty() &&
                currentOrder.getChips().isEmpty()) {
            System.out.println("\nYour order is empty!");
            return;
        }

        System.out.println("\n" + ColorText.GREEN + "=== ORDER SUMMARY ===" + ColorText.RESET);
        System.out.println(currentOrder.generateReceipt());

        String confirm = Main.getStringInput("Confirm order? (yes/no): ");
        if (confirm.equalsIgnoreCase("yes")) {
            saveReceipt();
            System.out.println(ColorText.GREEN + "\nOrder placed successfully!" + ColorText.RESET);
            System.out.println("Thank you for your order!");
        } else {
            System.out.println("\nOrder cancelled.");
        }
    }

    private void saveReceipt() {
        try {
            File receiptsDir = new File("receipts");
            if (!receiptsDir.exists()) {
                receiptsDir.mkdir();
            }

            String fileName = "receipts/" + currentOrder.getFileName();
            FileWriter writer = new FileWriter(fileName);
            writer.write(currentOrder.generateReceipt());
            writer.close();

            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}

