package org.howard.edu.lsp.midterm.strategy;

public class RegularPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }
}