package LSP_REPO_swish.org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ETLPipeline {

    public static void main(String[] args) {
        String inputFile = "data/products.csv";
        String outputFile = "data/transformed_products.csv";

        List<String[]> transformedRows = new ArrayList<>();
        int rowsRead = 0, rowsTransformed = 0, rowsSkipped = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                rowsRead++;
                String[] fields = line.trim().split(",");

                if (isHeader) {
                    transformedRows.add(fields);
                    isHeader = false;
                    continue;
                }

                if (fields.length != 4 || fields[0].isEmpty() || fields[2].isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int productID = Integer.parseInt(fields[0].trim());
                    double price = Double.parseDouble(fields[2].trim());
                    String name = fields[1].trim().toUpperCase();
                    String category = fields[3].trim();

                    if ("Electronics".equals(category)) {
                        price *= 0.9;
                    }
                    if (price > 500.00 && "Electronics".equals(category)) {
                        category = "Premium Electronics";
                    }

                    String priceRange = getPriceRange(price);

                    BigDecimal roundedPrice = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);

                    transformedRows.add(new String[]{
                        String.valueOf(productID), name, String.format("%.2f", roundedPrice), category, priceRange
                    });
                    rowsTransformed++;
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String[] row : transformedRows) {
                    writer.write(String.join(",", row));
                    writer.newLine();
                }
            }

            System.out.println("Rows Read: " + rowsRead);
            System.out.println("Rows Transformed: " + rowsTransformed);
            System.out.println("Rows Skipped: " + rowsSkipped);
            System.out.println("Output file written to: " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }

    private static String getPriceRange(double price) {
        if (price <= 10.00) return "Low";
        else if (price <= 100.00) return "Medium";
        else if (price <= 500.00) return "High";
        else return "Premium";
    }
}