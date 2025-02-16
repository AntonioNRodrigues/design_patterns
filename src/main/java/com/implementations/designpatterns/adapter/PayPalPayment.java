package com.implementations.designpatterns.adapter;

public class PayPalPayment implements PaymentGateway {
    @Override
    public void processPayment(String amount) {
        System.out.println("Processing PayPal payment of " + amount);
    }
}
