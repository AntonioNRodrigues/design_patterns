package com.implementations.designpatterns.factory.factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void createUserReturnsCustomerUser() {
        CustomerFactory factory = new CustomerFactory();
        User user = factory.createUser("Customer");
        assertInstanceOf(CustomerUser.class, user);
    }

    @Test
    void createUserIgnoresTypeParameter() {
        CustomerFactory factory = new CustomerFactory();
        User user = factory.createUser("Admin");
        assertInstanceOf(CustomerUser.class, user);
    }
}