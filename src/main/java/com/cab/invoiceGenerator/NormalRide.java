package com.cab.invoiceGenerator;

public class NormalRide extends Ride{

    private static final double COST_PER_KM = 10.00;
    private static final double COST_PER_MINUTE = 1.00;
    private static final double MINIMUM_FAIR = 5.00;

    public NormalRide(double distanceInKm, int timeInMin) {
        super(distanceInKm, timeInMin, RideType.NORMAL);
    }

    @Override
    public double calculateFair() {
        double fair = (this.distance * COST_PER_KM)+(this.time * COST_PER_MINUTE);
        return Math.max(fair, MINIMUM_FAIR);
    }
}
