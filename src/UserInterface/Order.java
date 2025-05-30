package UserInterface;

import Sandwich.CustomizedSandwich;
import Drinks.Drink;
import Chips.Chip;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<CustomizedSandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;
    private LocalDateTime orderTime;
    private double totalPrice;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
        this.totalPrice = 0.0;
    }

    public void addSandwich(CustomizedSandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chip chip) {
        chips.add(chip);
    }

    public double calculateTotal() {
        totalPrice = 0.0;

        for (CustomizedSandwich sandwich : sandwiches) {
            totalPrice += sandwich.getPrice();
        }

        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }

        for (Chip chip : chips) {
            totalPrice += chip.getPrice();
        }

        return totalPrice;
    }

    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        receipt.append("=================================\n");
        receipt.append("       DELI-cious Receipt\n");
        receipt.append("=================================\n");
        receipt.append("Date: ").append(orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");

        if (!sandwiches.isEmpty()) {
            receipt.append("SANDWICHES:\n");
            for (int i = 0; i < sandwiches.size(); i++) {
                receipt.append("  ").append(i + 1).append(". ").append(sandwiches.get(i).toString()).append("\n");
            }
            receipt.append("\n");
        }

        if (!drinks.isEmpty()) {
            receipt.append("DRINKS:\n");
            for (Drink drink : drinks) {
                receipt.append("  - ").append(drink.toString()).append("\n");
            }
            receipt.append("\n");
        }

        if (!chips.isEmpty()) {
            receipt.append("CHIPS:\n");
            for (Chip chip : chips) {
                receipt.append("  - ").append(chip.toString()).append("\n");
            }
            receipt.append("\n");
        }

        receipt.append("---------------------------------\n");
        receipt.append("TOTAL: $").append(String.format("%.2f", calculateTotal())).append("\n");
        receipt.append("=================================\n");

        return receipt.toString();
    }

    public String getFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return orderTime.format(formatter) + ".txt";
    }

    public List<CustomizedSandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chip> getChips() {
        return chips;
    }
}

