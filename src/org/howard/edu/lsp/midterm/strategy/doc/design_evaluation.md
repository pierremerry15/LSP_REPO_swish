# Question 3: Design Evaluation - PriceCalculator

The original implementation of the `calculatePrice` method in the `PriceCalculator` class had several significant design flaws that made it difficult to maintain and scale.

### **1. Violation of the Open/Closed Principle**
The original code used a large `if-else` or `switch` block to handle different customer types (Regular, Member, Holiday). To add a new pricing category (like "Student" or "Black Friday"), a developer would have to manually modify the existing `PriceCalculator` class. This increases the risk of introducing bugs into the existing, working logic.

### **2. Lack of Flexibility (Hardcoded Logic)**
The pricing logic was hardcoded directly into the calculator. This meant the calculation behavior could not be swapped or changed at runtime. By refactoring to the **Strategy Pattern**, we decoupled the "what" (calculating a price) from the "how" (the specific discount math).

### **3. Improved Maintainability and Testing**
In the original design, testing a specific discount required running the entire calculator logic. In the new refactored design, each strategy (e.g., `HolidayPricing`, `VIPPricing`) lives in its own class. This makes the code much easier to unit test, read, and debug because each class has a **Single Responsibility**.