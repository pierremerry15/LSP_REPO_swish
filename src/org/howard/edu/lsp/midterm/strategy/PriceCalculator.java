package org.howard.edu.lsp.midterm.strategy;

public class PriceCalculator {
    private PricingStrategy strategy;

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateTotal(double unitPrice, int quantity) {
        return strategy.calculatePrice(unitPrice, quantity);
    }
}