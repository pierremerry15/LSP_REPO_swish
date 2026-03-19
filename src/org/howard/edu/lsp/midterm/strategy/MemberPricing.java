package org.howard.edu.lsp.midterm.strategy;

public class MemberPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double unitPrice, int quantity) {
        return (unitPrice * quantity) * 0.90;
    }
}