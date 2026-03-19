package org.howard.edu.lsp.midterm.strategy;

public interface PricingStrategy {
    double calculatePrice(double unitPrice, int quantity);
}