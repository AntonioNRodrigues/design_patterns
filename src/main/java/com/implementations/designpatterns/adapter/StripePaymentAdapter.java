package com.implementations.designpatterns.adapter;

public class StripePaymentAdapter implements PaymentGateway {
    private final StripePayment stripePayment;

    public StripePaymentAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment(String amount) {
        stripePayment.makePayment(amount);
    }
}
