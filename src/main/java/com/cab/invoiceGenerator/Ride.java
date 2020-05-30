package com.cab.invoiceGenerator;

public abstract class Ride {

    public final double distance;
    public final int time;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public abstract double calculateFair();

}
