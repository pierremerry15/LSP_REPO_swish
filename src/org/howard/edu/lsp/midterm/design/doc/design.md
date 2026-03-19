# Question 2: Redesign (CRC Cards)

**Class: Order**
- **Responsibilities**: Stores customer info, item details, and price.
- **Collaborators**: None.

**Class: OrderProcessor**
- **Responsibilities**: Orchestrates the workflow. Delegates tax calculation and file storage.
- **Collaborators**: TaxCalculator, OrderRepository, EmailService.

**Class: TaxCalculator**
- **Responsibilities**: Calculates tax for an Order based on current rates (0.07).
- **Collaborators**: Order.

**Class: OrderRepository**
- **Responsibilities**: Saves Order data to a persistent text file.
- **Collaborators**: Order.