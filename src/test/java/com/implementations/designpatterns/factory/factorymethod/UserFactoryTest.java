package com.implementations.designpatterns.factory.factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void getFactoryReturnsAdminFactoryForAdminType() {
        UserFactory factory = UserFactory.getFactory("Admin");
        assertInstanceOf(AdminFactory.class, factory);
    }

    @Test
    void getFactoryReturnsCustomerFactoryForCustomerType() {
        UserFactory factory = UserFactory.getFactory("Customer");
        assertInstanceOf(CustomerFactory.class, factory);
    }

    @Test
    void getFactoryThrowsExceptionForUnknownType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserFactory.getFactory("Unknown");
        });
        assertEquals("Unknown type", exception.getMessage());
    }

    @Test
    void createUserReturnsAdminUserForAdminType() {
        UserFactory factory = UserFactory.getFactory("Admin");
        User user = factory.createUser("Admin");
        assertInstanceOf(AdminUser.class, user);
    }

    @Test
    void createUserReturnsCustomerUserForCustomerType() {
        UserFactory factory = UserFactory.getFactory("Customer");
        User user = factory.createUser("Customer");
        assertInstanceOf(CustomerUser.class, user);
    }
}