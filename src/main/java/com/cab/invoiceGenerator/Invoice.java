package com.cab.invoiceGenerator;

import java.util.Random;

public class Invoice {
    public final int invoiceNumber;
    public final User user;

    public Invoice( User user) {
        this.invoiceNumber = new Random().nextInt(100000);
        this.user = user;
    }

    public double calculateTotalFair() {
        return user.getRides().stream()
                .map(Ride::calculateFair)
                .reduce(0.0, Double::sum);
    }
}
