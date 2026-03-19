package org.howard.edu.lsp.midterm.design;

public class OrderProcessor {
    private TaxCalculator taxCalc = new TaxCalculator();

    public void processOrder(Order order) {
        double tax = taxCalc.calculateTax(order.getPrice());
        double total = order.getPrice() + tax;
        
        System.out.println("Processing order for: " + order.getCustomerName());
        System.out.println("Total with tax: " + total);
    }
}