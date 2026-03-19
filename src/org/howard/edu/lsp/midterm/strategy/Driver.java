package org.howard.edu.lsp.midterm.strategy;

public class Driver {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        // Testing Regular Pricing
        calculator.setStrategy(new RegularPricing());
        System.out.println("Regular Price: " + calculator.calculateTotal(100.0, 2));

        // Testing Member Pricing
        calculator.setStrategy(new MemberPricing());
        System.out.println("Member Price: " + calculator.calculateTotal(100.0, 2));

        // Testing Holiday Pricing
        calculator.setStrategy(new HolidayPricing());
        System.out.println("Holiday Price: " + calculator.calculateTotal(100.0, 2));
    }
}