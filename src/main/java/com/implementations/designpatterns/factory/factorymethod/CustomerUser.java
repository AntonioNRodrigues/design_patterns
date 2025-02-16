package com.implementations.designpatterns.factory.factorymethod;

public class CustomerUser extends User {

    public CustomerUser() {
        super("Default Customer", "Customer");
    }

    public CustomerUser(String name) {
        super(name, "Customer");
    }

    @Override
    public void displayInfo() {
        System.out.println("CustomerUser: Name = " + name + ", Role = " + role);
    }
}
