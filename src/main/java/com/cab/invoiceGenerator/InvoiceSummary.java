package com.cab.invoiceGenerator;

public class InvoiceSummary {
    public final int totalRider;
    public final double totalFair;
    public final double averageFair;

    public InvoiceSummary(int totalRider, double totalFair) {
        this.totalRider = totalRider;
        this.totalFair = totalFair;
        this.averageFair = (totalFair/totalRider);
    }

    public InvoiceSummary(Invoice invoice) {
        this.totalRider = invoice.user.getRides().size();
        this.totalFair = invoice.calculateTotalFair();
        this.averageFair = (totalFair/totalRider);
    }

    @Override
    public boolean equals(Object o) {
        InvoiceSummary that = (InvoiceSummary) o;
        if (this == that) return true;
        if (that == null || getClass() != o.getClass()) return false;
        return totalRider == that.totalRider &&
                Double.compare(that.totalFair, totalFair) == 0 &&
                Double.compare(that.averageFair, averageFair) == 0;
    }

}
