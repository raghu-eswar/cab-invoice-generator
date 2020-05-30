package com.cab.invoiceGenerator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class User {
    private String userId;
    private List<Ride> rides;

    public User(String userId) {
        this.userId = userId;
        this.rides = new LinkedList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void addRides(List<Ride> rides) {
        this.rides.addAll(rides);
    }

    public void addRides(Ride ... rides) {
        this.rides.addAll(Arrays.asList(rides));
    }
}
