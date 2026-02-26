package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.*;

public class FileHandler {

    public static List<Product> readCSV(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;  // Skip the header row
                }
                String[] fields = line.trim().split(",");
                if (fields.length == 4) {  // Ensure the row has exactly 4 fields
                    try {
                        int productID = Integer.parseInt(fields[0].trim());
                        double price = Double.parseDouble(fields[2].trim());
                        String name = fields[1].trim();
                        String category = fields[3].trim();
                        products.add(new Product(productID, name, price, category));
                    } catch (NumberFormatException e) {
                        // Skip rows with invalid number format
                    }
                }
            }
        }
        return products;
    }

    public static void writeCSV(String filePath, List<Product> products) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ProductID,Name,Price,Category,PriceRange\n");
            for (Product product : products) {
                writer.write(product.toCSV());
                writer.newLine();
            }
        }
    }
}