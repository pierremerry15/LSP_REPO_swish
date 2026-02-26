package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String inputFile = "data/products.csv";  // Input CSV file path
        String outputFile = "data/transformed_products.csv";  // Output CSV file path
        List<Product> products;

        try {
            // Step 1: Read products from CSV
            products = FileHandler.readCSV(inputFile);

            // Step 2: Apply transformations (discount, category update)
            for (Product product : products) {
                product.applyDiscount();
                product.updateCategory();
            }

            // Step 3: Write transformed products to CSV
            FileHandler.writeCSV(outputFile, products);

            System.out.println("ETL process complete.");
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}