package com.implementations.designpatterns.factory.factorymethod;

public abstract class UserFactory {
    public abstract User createUser(String type);

    public static UserFactory getFactory(String type) {
        if (type.equalsIgnoreCase("Admin")) {
            return new AdminFactory();
        } else if (type.equalsIgnoreCase("Customer")) {
            return new CustomerFactory();
        } else {
            throw new IllegalArgumentException("Unknown type");
        }
    }
}

