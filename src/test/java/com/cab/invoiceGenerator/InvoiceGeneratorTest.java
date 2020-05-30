package com.cab.invoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

    public InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAAndTime_shouldReturnCorrectFair() {
        double fair = invoiceGenerator.calculateFair(2.2, 3);
        Assert.assertEquals(25, fair, 0.0);
    }

     @Test
    public void givenDistanceAAndTime_shouldReturnMinimumFair() {
        double fair = invoiceGenerator.calculateFair(0.3, 1);
        Assert.assertEquals(5, fair, 0.0);
    }

    @Test
    public void givenRideArray_shouldReturnCorrectFair() {
        Ride[] rides = {new Ride(4 , 10), new Ride(3, 5),new Ride(5, 2)};
        double fair = invoiceGenerator.calculateFair(rides);
        Assert.assertEquals(137, fair, 0.0);
    }
}
