package com.implementations.designpatterns.adapter;

public class StripePayment {
    public void makePayment(String amount) {
        System.out.println("Processing Stripe payment of " + amount);
    }
}
