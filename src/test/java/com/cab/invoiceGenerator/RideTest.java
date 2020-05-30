package com.cab.invoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class RideTest {

    @Test
    public void givenDistanceAAndTime_normalRide_shouldReturnCorrectFair() {
        Ride ride = new NormalRide(2.2, 3);
        double fair = ride.calculateFair();
        Assert.assertEquals(25, fair, 0.0);
    }

    @Test
    public void givenDistanceAndTime_normalRide_shouldReturnMinimumFair() {
        Ride ride = new NormalRide(0.3, 1);
        double fair = ride.calculateFair();
        Assert.assertEquals(5, fair, 0.0);
    }

    @Test
    public void givenDistanceAAndTime_premiumRide_shouldReturnCorrectFair() {
        Ride ride = new PremiumRide(2.2, 3);
        double fair = ride.calculateFair();
        Assert.assertEquals(39, fair, 0.0);
    }

    @Test
    public void givenDistanceAndTime_premiumRide_shouldReturnMinimumFair() {
        Ride ride = new PremiumRide(0.3, 1);
        double fair = ride.calculateFair();
        Assert.assertEquals(20, fair, 0.0);
    }

}
