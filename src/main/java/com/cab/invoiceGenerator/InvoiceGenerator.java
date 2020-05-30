package com.cab.invoiceGenerator;

public class InvoiceGenerator {

    private static final double COST_PER_KM = 10.00;
    private static final double COST_PER_MIN = 1.00;

    public double calculateFair(double distance, int time) {
        return (distance * COST_PER_KM)+(time * COST_PER_MIN);
    }
}
