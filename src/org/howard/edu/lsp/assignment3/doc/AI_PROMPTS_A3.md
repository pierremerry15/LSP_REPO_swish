# AI Prompts for Assignment 3

### Prompt 1: How can I make my existing ETL pipeline more object-oriented?

**Question**: Hey, I need help turning my current ETL pipeline (from Assignment 2) into something more object-oriented. How should I break it down into separate classes?

**Answer**: To make your ETL pipeline object-oriented, you’ll want to divide the logic into multiple classes where each class has a specific responsibility. I suggest creating:

1. **Product Class**: This would represent each product, encapsulating all its properties (`ProductID`, `Name`, `Price`, `Category`) and behaviors like applying discounts and updating categories.
   
2. **FileHandler Class**: This class would handle reading and writing CSV files. It would be responsible for parsing the input file and writing the transformed data to an output file.

3. **Main Class**: This would coordinate the process by calling methods from the other classes. It could read the data, apply transformations to each product, and then save the results.

By splitting the responsibilities like this, you’ll achieve clear separation of concerns, making the code more maintainable and testable.

---

### Prompt 2: How can I handle CSV reading and writing in Java?

**Question**: I need a way to read data from a CSV file in Java and write the transformed data back to a new CSV file. Can you suggest the best approach?

**Answer**: Here's how you can handle CSV reading and writing:

1. Use **`BufferedReader`** to read each line of the CSV file.
2. Split each line into fields based on the comma delimiter.
3. Create a `Product` object for each valid row, which holds the product’s details.
4. After transforming the data (e.g., applying discounts, changing categories), use **`BufferedWriter`** to write the transformed rows to a new CSV file.

You can create a helper class like `FileHandler` that manages the reading and writing. It could take care of parsing the CSV into `Product` objects and writing them back out after transformation.

---

### Prompt 3: What should I include in my `Product` class to handle transformations like discounts?

**Question**: How should I set up a `Product` class to handle price transformations, like applying discounts, and updating product categories?

**Answer**: Your `Product` class should include:

1. **Attributes**: 
   - `ProductID`, `Name`, `Price`, and `Category` to store the product's data.
   
2. **Methods for Transformations**:
   - `applyDiscount()`: If the product’s category is "Electronics", apply a 10% discount to the price.
   - `updateCategory()`: If the price is greater than $500 for an "Electronics" product, change the category to "Premium Electronics".
   - `getPriceRange()`: Based on the price, return a category like "Low", "Medium", "High", or "Premium".

Additionally, you can use the `toCSV()` method to convert the product back into a CSV-friendly format after applying all transformations.

---

### Prompt 4: How should I structure the `Main` class to tie everything together?

**Question**: What’s the best way to structure my `Main` class so it coordinates reading, transforming, and writing the data?

**Answer**: Your `Main` class should:

1. **Read the Input**: Use `FileHandler.readCSV()` to read in the product data from the `products.csv` file.
   
2. **Apply Transformations**: Loop through each product in the list and call the methods `applyDiscount()` and `updateCategory()` for each one.

3. **Write the Output**: After all transformations are applied, use `FileHandler.writeCSV()` to save the updated products to a new file, `transformed_products.csv`.

This keeps the `Main` class focused on orchestrating the overall ETL process while delegating the heavy lifting (like file handling and product transformations) to the other classes.

---

### Prompt 5: How do I ensure my program works the same as Assignment 2 while making it more object-oriented?

**Question**: I want to make sure that my new object-oriented design does the same thing as my original Assignment 2 solution. How can I test to confirm the behavior is the same?

**Answer**: You can verify that **Assignment 3** works the same as **Assignment 2** by:

1. **Testing with the same input data**: Use the same `products.csv` file from **Assignment 2** and compare the output (`transformed_products.csv`) with the output from your **Assignment 2** solution.
   
2. **Edge Cases**: Make sure to test with empty files, missing files, and files with invalid data (like non-numeric values in the `Price` field). Ensure the program handles these cases gracefully without crashing.

3. **Manually verify transformations**: Check that the discount, category update, and price range assignments are applied as expected in the new code, just like they were in **Assignment 2**.

By running these tests, you can confirm that the new object-oriented design maintains the same functionality as the original, non-object-oriented version.

---

### Prompt 6: How do I organize my reflection on the object-oriented changes?

**Question**: Can you help me write a reflection comparing my old approach to the new object-oriented design?

**Answer**: Your reflection should focus on the following:

1. **Differences in Design**: Explain how the refactored code is now divided into separate classes like `Product`, `FileHandler`, and `Main`. Contrast this with your previous **Assignment 2** solution, where everything was handled in a single class.
   
2. **Object-Oriented Benefits**: Discuss how the new design is more modular, easier to maintain, and easier to test. Highlight the use of **encapsulation** (e.g., keeping product data and transformations inside the `Product` class), **separation of concerns** (each class does one thing), and **methods** (e.g., applying transformations and writing to files).

3. **Testing**: Explain how you tested the new solution to ensure it works as expected by comparing it to the original **Assignment 2** implementation.

---

Let me know if you need further changes or help with any of these sections!