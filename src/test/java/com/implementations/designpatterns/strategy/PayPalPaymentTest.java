package com.implementations.designpatterns.strategy;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class PayPalPaymentTest {

    @Test
    void payWithPositiveAmount() {
        PayPalPayment payPalPayment = mock(PayPalPayment.class);
        payPalPayment.pay(100.0);
        verify(payPalPayment).pay(100.0);
    }

    @Test
    void payWithZeroAmount() {
        PayPalPayment payPalPayment = mock(PayPalPayment.class);
        payPalPayment.pay(0.0);
        verify(payPalPayment).pay(0.0);
    }

    @Test
    void payWithNegativeAmount() {
        PayPalPayment payPalPayment = mock(PayPalPayment.class);
        payPalPayment.pay(-50.0);
        verify(payPalPayment).pay(-50.0);
    }
}