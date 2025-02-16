package com.implementations.designpatterns.factory.factorymethod;

public class AdminUser extends User {

    public AdminUser() {
        super("Default Admin", "Admin");
    }

    public AdminUser(String name) {
        super(name, "Admin");
    }

    @Override
    public void displayInfo() {
        System.out.println("AdminUser: Name = " + name + ", Role = " + role);
    }
}
