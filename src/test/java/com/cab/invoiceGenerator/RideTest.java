package com.cab.invoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class RideTest {

    @Test
    public void givenDistanceAAndTime_shouldReturnCorrectFair() {
        Ride ride = new Ride(2.2, 3);
        double fair = ride.calculateFair();
        Assert.assertEquals(25, fair, 0.0);
    }

    @Test
    public void givenDistanceAAndTime_shouldReturnMinimumFair() {
        Ride ride = new Ride(.3, 1);
        double fair = ride.calculateFair();
        Assert.assertEquals(5, fair, 0.0);
    }

}
