package com.implementations.designpatterns.factory.factorymethod;

public class AdminFactory extends UserFactory {
    @Override
    public User createUser(String type) {
        return new AdminUser();
    }
}
