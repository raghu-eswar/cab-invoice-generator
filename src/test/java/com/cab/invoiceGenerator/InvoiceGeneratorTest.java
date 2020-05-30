package com.cab.invoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

    public InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAAndTime_shouldReturnCorrectFair() {
        InvoiceSummary actualInvoiceSummary = invoiceGenerator.generateInvoice(2.2, 3);
        InvoiceSummary requiredInvoiceSummary = new InvoiceSummary(1, 25);
        Assert.assertEquals(requiredInvoiceSummary, actualInvoiceSummary);
    }

     @Test
    public void givenDistanceAAndTime_shouldReturnMinimumFair() {
         InvoiceSummary actualInvoiceSummary = invoiceGenerator.generateInvoice(0.3, 1);
         InvoiceSummary requiredInvoiceSummary = new InvoiceSummary(1, 5);
         Assert.assertEquals(requiredInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenRideArray_shouldReturnCorrectFair() {
        Ride[] rides = {new Ride(4 , 10), new Ride(3, 5),new Ride(5, 2)};
        InvoiceSummary actualInvoiceSummary = invoiceGenerator.generateInvoice(rides);
        InvoiceSummary requiredInvoiceSummary = new InvoiceSummary(3, 137);
        Assert.assertEquals(requiredInvoiceSummary, actualInvoiceSummary);
    }
}
