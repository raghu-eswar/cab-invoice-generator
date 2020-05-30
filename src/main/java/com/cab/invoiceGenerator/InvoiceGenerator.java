package com.cab.invoiceGenerator;

public class InvoiceGenerator {

    private static final double COST_PER_KM = 10.00;
    private static final double COST_PER_MINUTE = 1.00;
    private static final double MINIMUM_FAIR = 5.00;

    public double calculateFair(double distance, int time) {
        double fair = (distance * COST_PER_KM)+(time * COST_PER_MINUTE);
        return (fair > 5)? fair : MINIMUM_FAIR;
    }
}
