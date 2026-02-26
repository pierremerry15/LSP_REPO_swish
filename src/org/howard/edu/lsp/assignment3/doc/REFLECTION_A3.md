# Reflection on Assignment 2 vs. Assignment 3

## 1. Design Differences

For Assignment 2, the ETL pipeline was designed in a procedural manner, where all the logic was packed into a single class. Everything — from reading the input file to transforming the data and writing it to the output file — was handled in a single `main` method. While this design got the job done, it was a bit cumbersome. The code wasn’t easily maintainable, and it was hard to reuse parts of the pipeline for future work.

In Assignment 3, I made the decision to switch to an **object-oriented** design. Instead of having one large method do everything, I broke the pipeline down into three distinct classes:
- **`Extraction`**: This class is responsible for reading the input data from the CSV file and handling edge cases, like missing files or invalid data entries. It’s focused entirely on gathering the raw data.
- **`Transformation`**: Here, I applied all the necessary transformations. This included modifying the product names (e.g., converting them to uppercase), adjusting prices, and calculating new fields like the price range for each product. This class is where the heavy lifting of the logic happens.
- **`Loading`**: Finally, this class takes the transformed data and writes it to a new CSV file. This class focuses solely on the output, keeping it separate from the rest of the pipeline.

This new design brings a more structured and **modular approach**, which makes the code easier to understand and maintain. Each class has a specific responsibility, which follows the **principle of separation of concerns**. This is a much cleaner and more scalable solution compared to the procedural approach of Assignment 2.

## 2. Object-Oriented Principles Used

In redesigning the pipeline, I applied several core object-oriented principles that helped improve the structure and clarity of the program:

- **Encapsulation**: Each class hides its internal workings. For example, the logic for file reading and writing is contained within the `Extraction` and `Loading` classes. These classes don’t expose unnecessary details, and other parts of the program don’t need to worry about how the file operations are performed.
  
- **Separation of Concerns**: By dividing the pipeline into three classes, I ensured that each part of the process — reading data, transforming it, and writing it — was handled by a separate class. This reduces complexity in each class and makes it easier to maintain or extend one part of the pipeline without affecting the others.
  
- **Reusability**: The new structure makes it easy to reuse the individual classes for future projects. For instance, I could easily reuse the `Extraction` class if I needed to extract data from another source, or modify the `Transformation` class to handle different types of data transformations without disturbing the rest of the code.
  
- **Abstraction**: The details of how data is read, transformed, and written are abstracted away in the respective classes. For someone using the code, they only need to know how to call the classes and methods, not how they work internally.

## 3. How It Works the Same

Despite the shift to an object-oriented design, the functionality of the pipeline remains exactly the same as it was in Assignment 2. The core tasks — reading the input file, transforming the data, and writing the output — are all still handled, but now in a more organized way.

I tested the new pipeline by using the same input file, `data/products.csv`, and compared the output against what I had in Assignment 2. The transformed data in `data/transformed_products.csv` matched perfectly. I also tested edge cases, like missing files and invalid rows, and ensured the error handling worked just as it did before.

The **behavior is identical**, but the structure is cleaner, more organized, and easier to expand in the future. For example, if I need to add new transformations or support a different file format, I can easily modify or add a class without having to touch the other parts of the pipeline.

## 4. Final Thoughts

Overall, the redesign makes the pipeline more maintainable and scalable, which is especially useful if this code were to be extended or reused in future projects. By adopting **object-oriented principles**, the code is more **modular**, **flexible**, and **testable**. Each part of the pipeline now handles a specific task, and the separation of concerns ensures that changes in one part (e.g., modifying the transformation logic) won’t affect the rest of the code.

This approach also makes it easier to **debug** and **extend** the pipeline. For example, if I want to add additional transformation rules in the future, I can simply update the `Transformation` class without worrying about the rest of the pipeline. Similarly, if I need to change the file format or the way files are read and written, I can do so in the `Extraction` and `Loading` classes without touching the transformation logic.

In conclusion, while the results are the same as Assignment 2, the code is now much **cleaner**, **easier to understand**, and **ready for f