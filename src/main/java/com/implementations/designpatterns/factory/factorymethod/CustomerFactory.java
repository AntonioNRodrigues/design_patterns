package com.implementations.designpatterns.factory.factorymethod;

public class CustomerFactory extends UserFactory {
    @Override
    public User createUser(String type) {
        return new CustomerUser();
    }
}
