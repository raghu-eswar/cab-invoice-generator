package com.cab.invoiceGenerator;

public abstract class Ride {

    public final double distance;
    public final int time;
    public final RideType type;

    public Ride(double distance, int time, RideType type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }

    public abstract double calculateFair();

}
