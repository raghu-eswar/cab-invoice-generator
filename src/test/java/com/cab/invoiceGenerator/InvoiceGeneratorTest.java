package com.cab.invoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

    public InvoiceServices invoiceServices;

    @Before
    public void setUp() {
        invoiceServices = new InvoiceServices();
    }

    @Test
    public void givenDistanceAAndTime_shouldReturnCorrectSummary() {
        InvoiceSummary actualInvoiceSummary = invoiceServices.generateInvoice(2.2, 3);
        InvoiceSummary requiredInvoiceSummary = new InvoiceSummary(1, 25);
        Assert.assertEquals(requiredInvoiceSummary, actualInvoiceSummary);
    }

     @Test
    public void givenDistanceAAndTime_shouldReturnSummaryWithMinimumFair() {
         InvoiceSummary actualInvoiceSummary = invoiceServices.generateInvoice(0.3, 1);
         InvoiceSummary requiredInvoiceSummary = new InvoiceSummary(1, 5);
         Assert.assertEquals(requiredInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenRideArray_shouldReturnCorrectSummary() {
        Ride[] rides = {new NormalRide(4 , 10), new NormalRide(3, 5),new NormalRide(5, 2)};
        InvoiceSummary actualInvoiceSummary = invoiceServices.generateInvoice(rides);
        InvoiceSummary requiredInvoiceSummary = new InvoiceSummary(3, 137);
        Assert.assertEquals(requiredInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void forGivenUser_withNormalRides_shouldReturnCorrectSummary() {

        User user = new User("raghu");
        Ride[] rides = {new NormalRide(4 , 10), new NormalRide(3, 5),new NormalRide(5, 2)};
        user.addRides(rides);
        InvoiceSummary actualInvoiceSummary = invoiceServices.generateInvoice(user);
        InvoiceSummary requiredInvoiceSummary = new InvoiceSummary(3, 137);
        Assert.assertEquals(requiredInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void forGivenUser_withPremiumRides_shouldReturnCorrectSummary() {

        User user = new User("raghu");
        Ride[] rides = {new PremiumRide(4 , 10), new NormalRide(3, 5),
                        new PremiumRide(6 , 15),new NormalRide(5, 2)};
        user.addRides(rides);
        InvoiceSummary actualInvoiceSummary = invoiceServices.generateInvoice(user);
        InvoiceSummary requiredInvoiceSummary = new InvoiceSummary(4, 287);
        Assert.assertEquals(requiredInvoiceSummary, actualInvoiceSummary);
    }

}




