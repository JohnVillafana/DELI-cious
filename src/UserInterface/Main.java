package UserInterface;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static OrderManager orderManager = new OrderManager();

    public static void main(String[] args) {
        while (true) {
            displayHomeScreen();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    orderManager.startNewOrder();
                    break;
                case 0:
                    System.out.println("\nThank you for visiting DELI-cious! Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("\n" + ColorText.GREEN + "=================================");
        System.out.println("    DELI-cious SANDWICHES");
        System.out.println("=================================" + ColorText.RESET);
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.println("=================================");
    }

    public static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

