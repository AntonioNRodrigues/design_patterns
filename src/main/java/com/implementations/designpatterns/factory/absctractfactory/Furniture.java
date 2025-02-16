package com.implementations.designpatterns.factory.absctractfactory;

public class Furniture implements Product {
    private final String description;
    private final double price;

    public Furniture() {
        this.description = "Default Furniture";
        this.price = 200.0;
    }

    public Furniture(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Furniture [description=" + description + ", price=" + price + "]";
    }
}
