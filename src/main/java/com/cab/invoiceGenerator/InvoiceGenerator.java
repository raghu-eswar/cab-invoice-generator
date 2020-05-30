package com.cab.invoiceGenerator;

import java.util.Arrays;

public class InvoiceGenerator {

    public InvoiceSummary generateInvoice(double distance, int time) {
        return generateInvoice(new NormalRide(distance, time));
    }

    public InvoiceSummary generateInvoice(Ride ... rides) {
        Double fair = Arrays.stream(rides)
                            .map(Ride::calculateFair)
                            .reduce(0.0, Double::sum);
        return new InvoiceSummary(rides.length, fair);
    }

    public InvoiceSummary generateInvoice(User user) {
        return generateInvoice(user.getRides().toArray(Ride[]::new));
    }
}
