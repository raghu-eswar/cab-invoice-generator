package com.cab.invoiceGenerator;

import java.util.Arrays;

public class InvoiceGenerator {

    public double calculateFair(double distance, int time) {
        return calculateFair(new Ride(distance,time));
    }

    public double calculateFair(Ride ... rides) {
        return Arrays.stream(rides)
                     .map(Ride::calculateFair)
                     .reduce(0.0, Double::sum);
    }
}
