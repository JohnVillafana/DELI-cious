# DELI-cious Sandwich Shop

A console-based Java application that simulates a deli sandwich ordering system. Users can build customized sandwiches, choose from signature sandwich options, and add drinks, chips, and sides to their orders. The app calculates pricing based on size, extras, and provides a printed receipt with detailed breakdowns.

## Class Diagram

![Class Diagram](screenshots/class-diagram.png)

## Features

### Customized Sandwiches
- Choose bread type, size (4", 8", 12")
- Select meats, cheeses, regular toppings, sauces
- Option to mark any meat or cheese as "extra" (adds additional cost)

### Signature Sandwiches
Choose from preset options like:
- **BLT**: 8" white bread, bacon, cheddar, lettuce, tomatoes, ranch (toasted)
- **Philly Cheesesteak**: 8" white bread, steak, American cheese, peppers, mayo (toasted)

Select bread type, size, and toasted or not

### Drinks and Chips
- Select from predefined drink options
- Drinks vary by size (small, medium, large)
- Chips are a fixed cost

### Receipt Generation
- Each order generates a clear, itemized receipt
- Displays ingredients with prices and extra charges
- Automatically saved in the `receipts` folder with timestamp: `yyyyMMdd-hhmmss.txt`

## Extra Implemented Features

- Users can now select from a list of Signature Sandwiches when placing an order
- Each order is assigned a unique, incrementing Order Number within a single session
- Chip and drink names have been clearly defined and included for better user selection
- During sandwich customization, users can opt to skip any category (e.g., meats, cheeses, sauces) by choosing "none"
- Added color to the user interface for better visibility of different sections
- Allow users to choose bread type, and size for signature sandwich
- Used Streams, Inheritance, Interfaces, and Polymorphism

## Technology Stack and Tools

### Languages and Frameworks
- **Java**: Core programming language used to build the application
- **Maven**: Project management and build tool used to manage dependencies and organize the project structure

### IDE and Version Control
- **IntelliJ IDEA Community Edition**: Primary development environment used for writing and testing code
- **Git Bash & GitHub**: Version control system used to track changes and collaborate

## Screens

### HomeScreen and New Order Screen
![Home Screen](screenshots/home-screen.png)
![New Order](screenshots/new-order.png)

### BuildSandwich Screen
- **Choosing Bread Type and Size**
  ![Bread Selection](screenshots/bread-selection.png)
- **Choosing Meat, Regular Toppings, and Cheese**
  ![Toppings Selection](screenshots/toppings-selection.png)
- **Choosing Sauce and Toasted option**
  ![Sauce Selection](screenshots/sauce-selection.png)

### Signature Sandwich ordering Screen
![Signature Sandwich](screenshots/signature-sandwich.png)

### Ordering Drinks, Chips, and sides
- **Sides**
  ![Sides](screenshots/sides.png)
- **Drinks**
  ![Drinks](screenshots/drinks.png)
- **Chips**
  ![Chips](screenshots/chips.png)

### Checkout Screen and Receipt
![Checkout Screen](screenshots/checkout.png)
![Receipt](screenshots/receipt.png)

## Interesting Piece of Code

```java
public String getMeats() {
    StringBuilder s = new StringBuilder();
    r.append("==== Order #").append(orderNumber).append(" ====\n");
    r.append("Time: ").append(formattedTime).append("\n\n");
    
    for (Meats116 item : items) {
        r.append(item.toString()).append("\n\n"); // Polymorphic toString()
    }
    
    r.append("================\n");
    r.append("Total: $%.2f\n", getTotal());
    r.append("================\n");
    
    return r.toString();
}
```

This code demonstrates polymorphism where each item (sandwich, drink, chip) implements its own `toString()` method, allowing the receipt to display different items uniformly while maintaining their unique characteristics.



## Project Structure

```
DELI-cious/
├── src/
│   ├── Chips/
│   │   ├── Chip.java
│   │   └── ChipName.java
│   ├── Drinks/
│   │   ├── Drink.java
│   │   ├── DrinkName.java
│   │   └── DrinkSize.java
│   ├── Sandwich/
│   │   ├── BreadType.java
│   │   ├── CustomizedSandwich.java
│   │   ├── SandwichSize.java
│   │   ├── SignatureSandwich.java
│   │   ├── Topping.java
│   │   ├── ToppingName.java
│   │   └── ToppingType.java
│   └── UserInterface/
│       ├── BuildSandwich.java
│       ├── ColorText.java
│       ├── Main.java
│       ├── Order.java
│       ├── OrderChips.java
│       ├── OrderDrink.java
│       └── OrderManager.java
├── receipts/
├── screenshots/
├── .gitignore
├── README.md
└── pom.xml
```

## Object-Oriented Design Principles

- **Encapsulation**: All classes use private fields with public getters/setters
- **Inheritance**: `SignatureSandwich` extends `CustomizedSandwich`
- **Polymorphism**: Different menu items implement common interfaces
- **Abstraction**: Complex operations are hidden behind simple method calls

## Contributors

- John Villafana - [GitHub](https://github.com/JohnVillafana)

## License

This project is licensed under the MIT License - see the LICENSE file for details.
