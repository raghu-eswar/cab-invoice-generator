package com.cab.invoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UserTest {

    @Test
    public void givenUserId_shouldCreateUserWithEmptyRides() {
        User user = new User("raghu");
        Assert.assertEquals("raghu", user.getUserId());
        Assert.assertEquals(0, user.getRides().size());
    }

    @Test
    public void givenListOfRides_addRides_shouldAddRidesToUser() {
        User user = new User("raghu");
        List<Ride> rides = Arrays.asList(new NormalRide(3,2), new PremiumRide(5,10), new NormalRide(2,7));
        user.addRides(rides);
        Assert.assertEquals("raghu", user.getUserId());
        Assert.assertEquals(3, user.getRides().size());
    }

    @Test
    public void givenRides_addRides_shouldAddRidesToUser() {
        User user = new User("raghu");
        user.addRides(new NormalRide(3,2), new PremiumRide(5,10), new NormalRide(2,7));
        Assert.assertEquals("raghu", user.getUserId());
        Assert.assertEquals(3, user.getRides().size());
    }


}
