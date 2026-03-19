# Design Evaluation: OrderProcessor

The original implementation violated several core object-oriented principles:

1. **Single Responsibility Principle (SRP) Violation**: The `OrderProcessor` class was a "God Object." It handled data storage, tax calculation, file I/O, and email—all in one place.
2. **Encapsulation Violation**: Fields like `customerName` and `price` were public, allowing external classes to modify the internal state directly.
3. **Maintainability Issues**: Business logic (like the 0.07 tax rate) was hardcoded, making it difficult to update without changing the core class.