package com.cab.invoiceGenerator;

public class PremiumRide extends Ride{
    private static final double COST_PER_KM = 15.00;
    private static final double COST_PER_MINUTE = 2.00;
    private static final double MINIMUM_FAIR = 20.00;

    public PremiumRide(double distanceInKm, int timeInMin) {
        super(distanceInKm, timeInMin, RideType.PREMIUM);
    }

    @Override
    public double calculateFair() {
        double fair = (this.distance * COST_PER_KM)+(this.time * COST_PER_MINUTE);
        return Math.max(fair, MINIMUM_FAIR);
    }
}
