# DELI-cious POS System

**Advanced Java OOP - Capstone 2**

A comprehensive Point of Sale system for a delicatessen, demonstrating advanced Object-Oriented Programming concepts including inheritance, polymorphism, encapsulation, and composition in a real-world business application.

[![Java](https://img.shields.io/badge/Java-11-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5-green.svg)](https://junit.org/junit5/)

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [OOP Concepts Demonstrated](#oop-concepts-demonstrated)
- [System Architecture](#system-architecture)
- [Class Diagram](#class-diagram)
- [Installation & Setup](#installation--setup)
- [Usage](#usage)
- [Application Screenshots](#application-screenshots)
- [Interesting Code Examples](#interesting-code-examples)
- [Testing](#testing)
- [Future Enhancements](#future-enhancements)
- [Development Process](#development-process)

## 🏪 Overview

DELI-cious addresses the real-world business problem of modernizing order management for a custom sandwich shop. The system replaces manual paper-based ordering with an automated console application that handles:

- **Custom sandwich building** with dynamic pricing
- **Signature sandwich options** (BLT, Philly Cheese Steak)
- **Additional items** (drinks and chips)
- **Professional receipt generation** with detailed breakdowns
- **Real-time order management** and total calculation

This project showcases practical application of advanced OOP principles in solving genuine business challenges.

## ✨ Features

### 🥪 Customized Sandwiches
- Choose bread type, size (4", 8", 12")
- Select meats, cheeses, regular toppings, sauces
- Option to mark any meat or cheese as "extra" (adds additional cost)
- Toasted or untoasted options

### 🍽️ Signature Sandwiches
- Pre-configured popular options (BLT, Philly Cheese Steak)
- Fully customizable while maintaining signature base
- Demonstrates inheritance with specialized behavior

### 🥤 Drinks and Chips
- Multiple drink sizes with size-based pricing
- Various chip flavors at fixed pricing
- Seamless integration with order totals

### 🧾 Professional Receipt Generation
- Itemized receipts with detailed breakdowns
- Automatic timestamp and unique order numbering
- Saved to `receipts/` folder as `yyyyMMdd-HHmmss.txt`

### 🔧 Advanced Features
- **Polymorphic pricing system** - Each item type calculates costs differently
- **Real-time order totals** - Dynamic price updates as items are added
- **Input validation** - Robust error handling prevents crashes
- **Extensible architecture** - Easy to add new menu items or features

## 🏗️ OOP Concepts Demonstrated

### 1. **Inheritance**
```java
// Signature sandwiches inherit from base Sandwich class
public class BLTSandwich extends Sandwich {
    public BLTSandwich(Size size) {
        super(new Bread(Bread.Type.WHITE), size);
        // Inherits all sandwich behaviors, adds specific toppings
        addTopping(new MeatTopping("Bacon"));
        addTopping(new RegularTopping("Lettuce"));
    }
}
```

### 2. **Polymorphism**
```java
// Same method call, different behavior based on topping type
public double calculatePrice() {
    return toppings.stream()
        .mapToDouble(topping -> topping.getPrice(size)) // Polymorphic call
        .sum();
}
// MeatTopping.getPrice() → $1-3 based on size
// RegularTopping.getPrice() → Always $0 (free)
```

### 3. **Encapsulation**
```java
public class Order {
    private List<Sandwich> sandwiches; // Private data
    
    // Controlled access with validation
    public void addSandwich(Sandwich sandwich) {
        if (sandwich != null) sandwiches.add(sandwich);
    }
    
    // Defensive copying prevents external modification
    public List<Sandwich> getSandwiches() {
        return new ArrayList<>(sandwiches);
    }
}
```

### 4. **Composition**
```java
// Order HAS-A collection of different item types
public class Order {
    private List<Sandwich> sandwiches; // HAS-A relationship
    private List<Drink> drinks;        // HAS-A relationship
    private List<Chips> chips;         // HAS-A relationship
}
```

## 🏛️ System Architecture

### Package Structure
```
src/main/java/com/deliciouspos/
├── models/              # Business entities
│   ├── signatures/      # Specialized sandwich types
│   ├── Sandwich.java    # Core sandwich functionality
│   ├── Order.java       # Order management
│   ├── Topping.java     # Abstract topping base class
│   └── ...             # Other model classes
├── services/           # Business logic layer
│   └── ReceiptService.java
├── ui/                 # User interface layer
│   ├── utils/          # Input validation utilities
│   └── ...            # Screen classes
└── Main.java          # Application entry point
```

### Design Patterns Used
- **Strategy Pattern** - Different pricing strategies for topping types
- **Template Method** - Abstract Topping class with concrete implementations
- **Service Layer** - Business logic separation from UI
- **Builder Pattern** - Step-by-step sandwich construction

## 📊 Class Diagram

![Class Diagram](path/to/your/class-diagram-image.png)

*Comprehensive UML class diagram showing inheritance relationships, composition structures, and method signatures across all system components.*

## 🚀 Installation & Setup

### Prerequisites
- Java 11+, Maven 3.6+, Git

### Quick Start
```bash
git clone https://github.com/yourusername/DELI-cious.git
cd DELI-cious
mvn clean package
java -jar target/deli-cious-1.0.0.jar
```

### Development
```bash
mvn clean compile  # Build project
mvn test          # Run tests
mvn exec:java -Dexec.mainClass="com.deliciouspos.Main"  # Run directly
```

## 💻 Usage

### Basic Workflow
1. **Start Application** - Launch from home screen
2. **Create New Order** - Begin order process
3. **Add Items** - Build sandwiches, select drinks/chips
4. **Customize** - Modify toppings, portions, and options
5. **Review Order** - Check items and pricing
6. **Checkout** - Generate and save receipt

### Sample Order Process
```
Welcome to DELI-cious!
1) New Order
2) Exit

> 1

Order Management
================
Items in order: 0
Current total: $0.00

1) Add Sandwich
2) Add Drink  
3) Add Chips
4) Checkout
5) Cancel Order

> 1 (Add custom 8" sandwich with bacon and cheddar)
> 2 (Add large Coke)
> 4 (Checkout - generates receipt)
```

## 📸 Application Screenshots

### Home Screen
![Home Screen](path/to/home-screen.png)
*Clean main menu interface with navigation options*

### Order Management
![Order Screen](path/to/order-screen.png)
*Order building interface showing current items and running total*

### Sandwich Builder
![Sandwich Builder](path/to/sandwich-builder.png)
*Step-by-step sandwich customization process*

### Checkout Process
![Checkout Screen](path/to/checkout-screen.png)
*Detailed order summary with itemized pricing*

### Receipt Generation
![Receipt Sample](path/to/receipt-sample.png)
*Professional formatted receipt with complete order details*

## 🎯 Interesting Code Examples

### Dynamic Pricing System
```java
public class Order {
    public String getReceiptId() {
        // Polymorphic toString() calls across different item types
        StringBuilder receipt = new StringBuilder();
        
        for (MenuItem item : items) {
            receipt.append(String.format("%-30s $%6.2f\n", 
                item.toString(), item.getPrice())); // Polymorphic toString()
        }
        
        return receipt.toString();
    }
}
```

**Why This Code is Interesting:**
This demonstrates polymorphism in action within the Order class. The system maintains a list of items, all implementing the MenuItem interface, yet each with different toString() and getPrice() implementations. The Order class can process Drinks, Sandwiches, or SignatureSandwiches uniformly without type checking, showcasing clean polymorphic design that makes the system extensible and maintainable.

### Polymorphic Pricing Strategy
```java
// Abstract strategy definition
public abstract class Topping {
    public abstract double getPrice(Sandwich.Size size);
}

// Concrete strategy implementations
public class MeatTopping extends Topping {
    private static final double[] PRICES = {1.00, 2.00, 3.00};
    
    @Override
    public double getPrice(Sandwich.Size size) {
        return PRICES[size.ordinal()];
    }
}

public class RegularTopping extends Topping {
    @Override
    public double getPrice(Sandwich.Size size) {
        return 0.0; // Always free
    }
}
```

## 🧪 Testing

### Test Coverage
- **Unit Tests** - Core business logic validation
- **Integration Tests** - Component interaction verification
- **Pricing Tests** - Polymorphic calculation accuracy
- **Input Validation Tests** - Error handling verification

### Running Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=SandwichTest

# Generate test coverage report
mvn jacoco:report
```

### Key Test Examples
```java
@Test
void testPolymorphicPricing() {
    Sandwich sandwich = new Sandwich(bread, Size.EIGHT_INCH);
    sandwich.addTopping(new MeatTopping("Bacon"));      // $2.00
    sandwich.addTopping(new RegularTopping("Lettuce")); // $0.00
    
    assertEquals(9.00, sandwich.calculatePrice()); // $7.00 base + $2.00 bacon
}
```

## 🚀 Future Enhancements

### Immediate Improvements
- **Database Integration** - Replace file-based storage with persistent data
- **Web Interface** - REST API with responsive web frontend
- **Payment Processing** - Credit card and cash handling integration

### Medium-term Features
- **Multi-location Support** - Corporate chain management
- **Customer Accounts** - Order history and loyalty programs
- **Inventory Management** - Stock tracking and automated reordering
- **Analytics Dashboard** - Sales reporting and trend analysis

### Advanced Capabilities
- **Mobile Applications** - Native iOS/Android apps
- **AI Recommendations** - Machine learning for personalized suggestions
- **Cloud Deployment** - Scalable microservices architecture
- **Third-party Integrations** - Delivery services and payment platforms

## 🛠️ Development Process

### Version Control Strategy
- **GitFlow Methodology** - Feature branches, development, and main branches
- **Meaningful Commits** - Descriptive commit messages following conventional format
- **Code Reviews** - Pull request workflow for quality assurance

### Quality Assurance
- **JUnit Testing** - Comprehensive test suite with high coverage
- **Maven Build Process** - Automated compilation and packaging
- **Error Handling** - Graceful failure recovery and user-friendly messages
- **Input Validation** - Robust protection against invalid user input

### Technical Highlights
- **Java 8+ Features** - Streams, lambda expressions, and functional programming
- **Design Patterns** - Professional application of established patterns
- **Clean Architecture** - Separation of concerns and modular design
- **Professional Documentation** - Comprehensive code comments and README

### Development Journey & Repository Management

During development, I encountered initial repository setup challenges that required a fresh start to ensure proper project structure and build configuration. However, the development process demonstrated consistent professional practices:

#### Initial Development Phase
![Initial Repository](screenshots/initial-repo.png)
*Early development showing meaningful commit history with 25+ commits and proper feature-based development*

#### Repository Restart & Final Implementation
![Final Repository](screenshots/final-repo.png)
*Clean repository structure after resolving setup issues, maintaining the same codebase with improved organization*

**Development Challenges Overcome:**
- **Maven Configuration Issues** - Initial pom.xml structure needed refinement for proper dependency management
- **Package Organization** - Restructured packages for better separation of concerns
- **Build Process** - Resolved compilation and testing pipeline issues
- **Git Workflow** - Established proper branching strategy and commit conventions

**Key Development Insights:**
- **Iterative Improvement** - Learned the importance of proper project setup before extensive development
- **Version Control Best Practices** - Maintained meaningful commit messages throughout development cycles
- **Code Consistency** - Core business logic and OOP implementation remained consistent across repository iterations
- **Professional Standards** - Demonstrated ability to restart and reorganize when necessary for project success

The final implementation maintains all original functionality and OOP design principles while benefiting from improved project structure and build configuration.

---

## 📄 License

This project is part of an academic capstone program demonstrating advanced Java programming concepts and professional software development practices.

## 🤝 Acknowledgments

- **Advanced Java OOP Course** - Foundational concepts and architectural patterns
- **Industry Best Practices** - Clean code principles and design patterns
- **Open Source Community** - Tools and frameworks that made this project possible

---

**Built with ❤️ and ☕ as a demonstration of practical Object-Oriented Programming mastery**