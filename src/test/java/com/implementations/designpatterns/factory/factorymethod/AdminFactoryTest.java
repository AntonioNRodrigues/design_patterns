package com.implementations.designpatterns.factory.factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void createUserReturnsAdminUser() {
        AdminFactory factory = new AdminFactory();
        User user = factory.createUser("Admin");
        assertInstanceOf(AdminUser.class, user);
    }

    @Test
    void createUserIgnoresTypeParameter() {
        AdminFactory factory = new AdminFactory();
        User user = factory.createUser("Customer");
        assertInstanceOf(AdminUser.class, user);
    }
}