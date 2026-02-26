package org.howard.edu.lsp.assignment3;

public class Product {
    private int productID;
    private String name;
    private double price;
    private String category;

    public Product(int productID, String name, double price, String category) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount() {
        if ("Electronics".equals(this.category)) {
            this.price *= 0.9;  // Apply 10% discount
        }
    }

    public void updateCategory() {
        if (this.price > 500.00 && "Electronics".equals(this.category)) {
            this.category = "Premium Electronics";  // Update category for high-priced electronics
        }
    }

    public String getPriceRange() {
        if (this.price <= 10.00) return "Low";
        else if (this.price <= 100.00) return "Medium";
        else if (this.price <= 500.00) return "High";
        else return "Premium";
    }

    public String toCSV() {
        return productID + "," + name + "," + String.format("%.2f", price) + "," + category + "," + getPriceRange();
    }
}