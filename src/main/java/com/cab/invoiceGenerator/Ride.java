package com.cab.invoiceGenerator;

public class Ride {
    private static final double COST_PER_KM = 10.00;
    private static final double COST_PER_MINUTE = 1.00;
    private static final double MINIMUM_FAIR = 5.00;

    public final double distance;
    public final int time;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public double calculateFair() {
        double fair = (this.distance * COST_PER_KM)+(this.time * COST_PER_MINUTE);
        return (fair > 5)? fair : MINIMUM_FAIR;
    }

}
