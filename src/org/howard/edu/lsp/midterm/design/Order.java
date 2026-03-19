package org.howard.edu.lsp.midterm.design;

public class Order {
    private String customerName;
    private double price;

    public Order(String name, double price) {
        this.customerName = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getCustomerName() { return customerName; }
}