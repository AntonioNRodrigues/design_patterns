package com.implementations.designpatterns.strategy;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class CreditCardPaymentTest {

    @Test
    void payWithPositiveAmount() {
        CreditCardPayment creditCardPayment = mock(CreditCardPayment.class);
        creditCardPayment.pay(100.0);
        verify(creditCardPayment).pay(100.0);
    }

    @Test
    void payWithZeroAmount() {
        CreditCardPayment creditCardPayment = mock(CreditCardPayment.class);
        creditCardPayment.pay(0.0);
        verify(creditCardPayment).pay(0.0);
    }

    @Test
    void payWithNegativeAmount() {
        CreditCardPayment creditCardPayment = mock(CreditCardPayment.class);
        creditCardPayment.pay(-50.0);
        verify(creditCardPayment).pay(-50.0);
    }
}